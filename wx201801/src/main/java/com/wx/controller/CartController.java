package com.wx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.common.Const;
import com.wx.common.ResponseCode;
import com.wx.common.ServerResponse;
import com.wx.model.WxproUser;
import com.wx.service.ICartService;
import com.wx.vo.CartVo;

/**
 *<p>Title: CartController</p>
 *<p>Description: 购物车处理，包括增删改查，全选，反选</p>
 * @author zhugf
 * @date 2018年2月25日
 */
@Controller
@RequestMapping("/cart/")
public class CartController {
	@Autowired
	private ICartService iCartService;
	/**
	 * 添加商品到购物车
	 * @param session
	 * @param count
	 * @param productId
	 * @return
	 */
	@RequestMapping("add")
	public @ResponseBody ServerResponse<CartVo> add(HttpSession session, Integer count, Integer productId){
//		WxproUser user = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		//这个判断可以通过过滤器或者拦截器去判断拦截
//		if(user==null){
//			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
//		}
		
//		return iCartService.add(user.getId(), productId, count);
		return iCartService.add(100001, productId, count);
	}
	
	@RequestMapping("delete_product")
	public ServerResponse<CartVo> deleteproduct(HttpSession session, String productIds){
		WxproUser user = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		//这个判断可以通过过滤器或者拦截器去判断拦截
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.deleteProducts(user.getId(), productIds);
	}
	
	@RequestMapping("update")
	public @ResponseBody ServerResponse<CartVo> update(HttpSession session, Integer productId, Integer count){
		WxproUser user = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		//这个判断可以通过过滤器或者拦截器去判断拦截
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.update(user.getId(), productId, count);
	}
	
	/**
	 * 展示购物车中的商品
	 * @param session
	 * @param count
	 * @param productId
	 * @return
	 */
	@RequestMapping("list")
	public@ResponseBody ServerResponse<CartVo> list(HttpSession session){
		WxproUser user = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		//这个判断可以通过过滤器或者拦截器去判断拦截
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.list(user.getId());
	}
	
	/**
	 * 全选
	 * @param session
	 * @return
	 */
	@RequestMapping("select_all")
	public @ResponseBody ServerResponse<CartVo> selectAll(HttpSession session){
		WxproUser user = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		//这个判断可以通过过滤器或者拦截器去判断拦截
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.changeSelectStatus(user.getId(), Const.Cart.CHECKEED, null);
	}
	
	/**
	 * 全不选
	 * @param session
	 * @return
	 */
	@RequestMapping("un_select_all")
	public @ResponseBody ServerResponse<CartVo> unSelectAll(HttpSession session){
		WxproUser user = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		//这个判断可以通过过滤器或者拦截器去判断拦截
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.changeSelectStatus(user.getId(), Const.Cart.UN_CHECKED, null);
	}
	/**
	 * 
	 * @param session
	 * @param productId
	 * @return
	 */
	@RequestMapping("select")
	public ServerResponse<CartVo> select(HttpSession session, Integer productId){
		WxproUser user = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		//这个判断可以通过过滤器或者拦截器去判断拦截
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.changeSelectStatus(user.getId(), Const.Cart.UN_CHECKED, productId);
	}
	
	@RequestMapping("un_select")
	public ServerResponse<CartVo> unSelect(HttpSession session, Integer productId){
		WxproUser user = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		//这个判断可以通过过滤器或者拦截器去判断拦截
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.changeSelectStatus(user.getId(), Const.Cart.UN_CHECKED, productId);
	}
	@RequestMapping("cartpage")
	public String cartpage(){
		return "shopping/shoppingcart";
	}

}
