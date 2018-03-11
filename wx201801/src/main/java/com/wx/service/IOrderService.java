package com.wx.service;

import com.github.pagehelper.PageInfo;
import com.wx.common.ServerResponse;
import com.wx.model.WxproOrder;

/**
 *<p>Title: IOrderService</p>
 *<p>Description: </p>
 * @author zhugf
 * @date 2018年3月6日
 */
public interface IOrderService {
	
	public ServerResponse<PageInfo<WxproOrder>> list(Integer pageSize, Integer currentPage);

}
