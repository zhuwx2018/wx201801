package com.wx.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.github.pagehelper.PageInfo;
import com.wx.common.Const;
import com.wx.common.ResponseCode;
import com.wx.common.ServerResponse;
import com.wx.common.TokenCache;
import com.wx.model.Userinfo;
import com.wx.model.WxproUser;
import com.wx.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/showUserByCondition")
	public @ResponseBody PageInfo<Userinfo> showUserByCondition(){
		PageInfo<Userinfo> userPage = new PageInfo<Userinfo>();
		userPage = userService.findUserByCondition();
		return userPage;
	}
	
	@RequestMapping("/showMessage/{message}")
	public String showMessage(@PathVariable String message,Model model){
		model.addAttribute("messsage", message);
		return "home";
	}
	@RequestMapping(value="/registUser",method = RequestMethod.POST)
	public @ResponseBody Userinfo registUser(Userinfo userinfo){
		Userinfo result = userService.addUser(userinfo);
		return result;
	}
	@RequestMapping(value="/registView", method=RequestMethod.GET)
	public String registView(){
		return "registUser";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpSession session){
		WxproUser userinfo = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		if(userinfo != null){
			return "userdetail";
		}
		return "login";
	}
	
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public @ResponseBody String loginCheck(@RequestBody Userinfo userinfo, HttpSession session){
		WxproUser user = new WxproUser();
		user.setId(100001);
		String token = UUID.randomUUID().toString();
		TokenCache.setKey("token_"+user.getId(), token);
		System.out.println(token);
		session.setAttribute(Const.CURRENT_USER, user);
		return "redirect:login";
	}
	@RequestMapping(value="/out_login")
	public String outLogin(HttpSession session){
		session.removeAttribute(Const.CURRENT_USER);
		return "redirect:login";
	}
	@RequestMapping(value="/testAjax", method=RequestMethod.POST)
	public @ResponseBody JSONObject testAjax(String jsonStr,HttpServletResponse response){ 
//		response.addHeader( "Access-Control-Allow-Origin", "http://127.0.0.1:8020" );
		System.out.println(jsonStr);
		JSONObject json = new JSONObject();
		json.put("success", "success");
		return json;
	}
	@RequestMapping("/gettoken")
	@ResponseJSONP(callback="callback")
	public ServerResponse<String> getToken(HttpSession session){ 
		WxproUser userinfo = (WxproUser) session.getAttribute(Const.CURRENT_USER);
		if(userinfo==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		String token = TokenCache.getKey("token_"+userinfo.getId());
		return ServerResponse.createBySuccess("success", token);
	}
	
	
}
