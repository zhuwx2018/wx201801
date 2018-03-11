package com.wx.vo;

import java.math.BigDecimal;

/**
 *<p>Title: CartProductVo</p>
 *<p>Description:购物车和产品的抽象类 </p>
 * @author zhugf
 * @date 2018年2月23日
 */
public class CartProductVo {
	
	/** 购物车 id*/
	private Integer id;
	/** 用户 id*/
	private Integer userId;
	/** 商品的ID*/
	private Integer productId;
	/** 商品的数量*/
    private Integer quantity;//购物车中此商品的数量
    /** 商品名称*/
    private String productName;
    /** 商品副标题*/
    private String productSubtitle;
    /** 商品的图片*/
    private String productMainImage;
    /** 商品的价格*/
    private BigDecimal productPrice;
    /** 商品的状态*/
    private Integer productStatus;
    /** 商品的总价*/
    private BigDecimal productTotalPrice;
    /** 商品的库存*/
    private Integer productStock;
    /** 此商品是否勾选*/
    private Integer productChecked;//此商品是否勾选
    /** 限制数量的一个返回结果*/
    private String limitQuantity;//限制数量的一个返回结果
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSubtitle() {
		return productSubtitle;
	}
	public void setProductSubtitle(String productSubtitle) {
		this.productSubtitle = productSubtitle;
	}
	public String getProductMainImage() {
		return productMainImage;
	}
	public void setProductMainImage(String productMainImage) {
		this.productMainImage = productMainImage;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public BigDecimal getProductTotalPrice() {
		return productTotalPrice;
	}
	public void setProductTotalPrice(BigDecimal productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}
	public Integer getProductStock() {
		return productStock;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public Integer getProductChecked() {
		return productChecked;
	}
	public void setProductChecked(Integer productChecked) {
		this.productChecked = productChecked;
	}
	public String getLimitQuantity() {
		return limitQuantity;
	}
	public void setLimitQuantity(String limitQuantity) {
		this.limitQuantity = limitQuantity;
	}
    
    

}
