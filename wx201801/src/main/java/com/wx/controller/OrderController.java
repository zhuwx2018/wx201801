package com.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wx.common.ServerResponse;
import com.wx.model.WxproOrder;
import com.wx.service.IOrderService;

/**
 *<p>Title: OrderController</p>
 *<p>Description: 订单处理</p>
 * @author zhugf
 * @date 2018年3月5日
 */
@Controller
@RequestMapping("/order/")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("order_page")
	public String orderPage(){
		return "shopping/orderdetail";
	}
	@RequestMapping("/list_order")
	@ResponseBody
	public ServerResponse<PageInfo<WxproOrder>> listOrder(@RequestParam(value="pageSize",defaultValue = "10")Integer pageSize,@RequestParam(value="currentPage",defaultValue="1")Integer currentPage){
		
		return orderService.list(pageSize, currentPage);
	}

}
