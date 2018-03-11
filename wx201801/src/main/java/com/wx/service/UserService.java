package com.wx.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.github.pagehelper.PageInfo;
import com.wx.model.Userinfo;

public interface UserService {
    @Cacheable(value="userFindCache")
	PageInfo<Userinfo> findUserByCondition();
    @CacheEvict(value="userFindCache",allEntries=true)
    Userinfo addUser(Userinfo userinfo);
}
