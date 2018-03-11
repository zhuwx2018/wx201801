package com.wx.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.wx.common.Const;
import com.wx.common.ServerResponse;
import com.wx.dao.WxproCartMapper;
import com.wx.dao.WxproProductMapper;
import com.wx.model.WxproCart;
import com.wx.model.WxproProduct;
import com.wx.service.ICartService;
import com.wx.util.BigDecimalUtil;
import com.wx.vo.CartProductVo;
import com.wx.vo.CartVo;
/**
 *<p>Title: CartServiceImpl</p>
 *<p>Description: </p>
 * @author zhugf
 * @date 2018年2月25日
 */
@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private WxproCartMapper wxproCartMapper;
	@Autowired
	private WxproProductMapper wxproProductMapper;
	
	public ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count){
		WxproCart cart = wxproCartMapper.selectCartByUserIdProductId(userId, productId);
		if(cart==null){
			//不存在时新增
			WxproCart newCart = new WxproCart();
			newCart.setChecked(1);
			newCart.setProductId(productId);
			newCart.setQuantity(count);
			newCart.setUserId(userId);
			newCart.setCreateTime(new Date());
			newCart.setUpdateTime(new Date());
			wxproCartMapper.insert(newCart);
		}else{
			//存在时累加数量
			count = cart.getQuantity() + count;
			cart.setQuantity(count);
			wxproCartMapper.updateByPrimaryKeySelective(cart);
		}
		
		return this.list(userId);
	}
	
	
	public ServerResponse<CartVo> deleteProduct(Integer userId, Integer productId){
		wxproCartMapper.deleteByUserIdProductId(userId,productId);
		return this.list(userId);
	}
	
	public ServerResponse<CartVo> deleteProducts(Integer userId, String productIds){
		List<String> productIdlist = Splitter.on(",").splitToList(productIds);
		wxproCartMapper.deleteByUserIdProductIds(userId,productIdlist);
		return this.list(userId);
	}
	
	
	public ServerResponse<CartVo> list(Integer userId){
		CartVo cartVo = new CartVo();
		cartVo = this.getCartVoLimit(userId);
		return ServerResponse.createBySuccess(cartVo);
	}
	
	public ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count){
		WxproCart cart = wxproCartMapper.selectCartByUserIdProductId(userId, productId);
		if(cart!=null){
			cart.setQuantity(count);
		}
		wxproCartMapper.updateByPrimaryKey(cart);
		return this.list(userId);
	}
	
	/**
	 * 修改选中状态
	 * @param userId
	 * @param checked
	 * @return
	 */
	public ServerResponse<CartVo> changeSelectStatus(Integer userId, Integer checked, Integer productId){
		wxproCartMapper.updateByUserId4Checked(userId, checked, productId);
		return this.list(userId);
	}
	
	
	
	
	
	/**
	 * 校验库存组装购物车(核心方法)
	 * @param userId
	 * @return
	 */
	private CartVo getCartVoLimit(Integer userId){
		CartVo cartvo = new CartVo();
		List<WxproCart> cartList = wxproCartMapper.selectCartByUserId(userId);
		List<CartProductVo> cartProductVoList = Lists.newArrayList();
		BigDecimal cartTotalPrice = new BigDecimal("0");
		Boolean isAllCheck = true;
		if(CollectionUtils.isNotEmpty(cartList)){
			for(WxproCart cart : cartList){
				CartProductVo cartProductVo = new CartProductVo();
				cartProductVo.setId(cart.getId());
				cartProductVo.setUserId(userId);
				cartProductVo.setProductId(cart.getProductId());
				//获取商品信息
				WxproProduct wxproProduct = wxproProductMapper.selectByPrimaryKey(cart.getProductId());
				
				cartProductVo.setProductName(wxproProduct.getName());
				cartProductVo.setProductMainImage(wxproProduct.getMainImage());
				cartProductVo.setProductPrice(wxproProduct.getPrice());
				cartProductVo.setProductStatus(wxproProduct.getStatus());
				cartProductVo.setProductStock(wxproProduct.getStock());
				cartProductVo.setProductSubtitle(wxproProduct.getSubtitle());
				cartProductVo.setProductChecked(cart.getChecked());
				//判断库存
				int buyLimitCount = 0;
				if(wxproProduct.getStock() >= cart.getQuantity()){
					//库存够时
					buyLimitCount = cart.getQuantity();
					cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
					
				}else{
					//库存不够时
					buyLimitCount = wxproProduct.getStock();
					cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
					//更新购物车中的有效库存
					WxproCart cartForUpdate = new WxproCart();
					cartForUpdate.setQuantity(buyLimitCount);
					cartForUpdate.setId(cart.getId());
					wxproCartMapper.updateByPrimaryKeySelective(cartForUpdate);
					
				}
				cartProductVo.setQuantity(buyLimitCount);
				cartProductVo.setProductTotalPrice(BigDecimalUtil.multiply(wxproProduct.getPrice().doubleValue(), cartProductVo.getQuantity()));
				cartProductVoList.add(cartProductVo);
				if(cartProductVo.getProductChecked() == Const.Cart.CHECKEED){
					//把勾选的商品总价添加到购物车的总价中
					cartTotalPrice.add(cartProductVo.getProductTotalPrice());
				}else{
					isAllCheck = false;
				}
				
			}
			cartvo.setCartProductVo(cartProductVoList);
			cartvo.setAllChecked(isAllCheck);
			cartvo.setCartTotalPrice(cartTotalPrice);
		}
		return cartvo;
		
	}
	
}
