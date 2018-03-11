package com.wx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wx.common.ServerResponse;
import com.wx.dao.WxproOrderMapper;
import com.wx.model.WxproOrder;
import com.wx.model.WxproOrderExample;
import com.wx.service.IOrderService;
@Service("iOrderService")
public class OrderService implements IOrderService {
	@Autowired
	private WxproOrderMapper wxproOrderMapper;
	
	public ServerResponse<PageInfo<WxproOrder>> list(Integer pageSize, Integer currentPage){
		PageHelper.startPage(currentPage, pageSize);
		WxproOrderExample example = new WxproOrderExample();
//		example.setOrderByClause("");
		List<WxproOrder> orderList = wxproOrderMapper.selectByExample(example);
		PageInfo<WxproOrder> pageInfo = new PageInfo<WxproOrder>(orderList);
		return ServerResponse.createBySuccess(pageInfo);
	}

}
