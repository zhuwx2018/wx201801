package com.wx.service;

import com.wx.common.ServerResponse;
import com.wx.vo.CartVo;

/**
 *<p>Title: ICartService</p>
 *<p>Description: </p>
 * @author zhugf
 * @date 2018年2月23日
 */
public interface ICartService {
	
	public ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
	
	public ServerResponse<CartVo> list(Integer userId);
	
	public ServerResponse<CartVo> deleteProduct(Integer userId, Integer productId);
	
	public ServerResponse<CartVo> deleteProducts(Integer userId, String productIds);
	
	public ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);
	
	public ServerResponse<CartVo> changeSelectStatus(Integer userId, Integer checked, Integer productId);

}
