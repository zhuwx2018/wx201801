package com.wx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wx.dao.UserinfoMapper;
import com.wx.model.Userinfo;
import com.wx.model.UserinfoExample;
import com.wx.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Override
	public PageInfo<Userinfo> findUserByCondition() {
		PageHelper.startPage(1, 10);
		List<Userinfo> list = userinfoMapper.selectByExample(new UserinfoExample());
		PageInfo<Userinfo> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	@Override
	public Userinfo addUser(Userinfo userinfo) {
		userinfoMapper.addUser(userinfo);
		return userinfo;
	}

}
