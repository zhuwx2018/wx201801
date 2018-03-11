package com.wx.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 *<p>Title: CartVo</p>
 *<p>Description: 购物车VO类</p>
 * @author zhugf
 * @date 2018年2月23日
 */
public class CartVo {
	
	/** 商品列表 */
	private List<CartProductVo> cartProductVo;
	/** 购物车总价 */
	private BigDecimal cartTotalPrice;
	/** 购物车里面是否全选 */
	private Boolean allChecked;
	/** 图片路径 */
	private String imageHost;

	public List<CartProductVo> getCartProductVo() {
		return cartProductVo;
	}

	public void setCartProductVo(List<CartProductVo> cartProductVo) {
		this.cartProductVo = cartProductVo;
	}

	public BigDecimal getCartTotalPrice() {
		return cartTotalPrice;
	}

	public void setCartTotalPrice(BigDecimal cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}

	public Boolean getAllChecked() {
		return allChecked;
	}

	public void setAllChecked(Boolean allChecked) {
		this.allChecked = allChecked;
	}

	public String getImageHost() {
		return imageHost;
	}

	public void setImageHost(String imageHost) {
		this.imageHost = imageHost;
	}
	
	
	

}
