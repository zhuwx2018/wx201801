package com.wx.service.impl;


import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.wx.common.ServerResponse;
import com.wx.dao.WxproCategoryMapper;
import com.wx.model.WxproCategory;
import com.wx.service.ICategoryService;
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {
	public static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private WxproCategoryMapper wxproCategoryMapper;
	
	public ServerResponse addCategory(Integer parentId, String name){
		//校验参数
		if(parentId==null||StringUtils.isBlank(name)){
			ServerResponse.createByErrorMessage("参数错误！");
		}
		WxproCategory category = new WxproCategory();
		category.setParentId(parentId);
		category.setName(name);
		if(wxproCategoryMapper.insert(category)>0){
			return ServerResponse.createBySuccess("新增成功");
		}
		return ServerResponse.createByErrorMessage("新增失败！");
		
	}
	
	public ServerResponse updateCategoryName(Integer categoryId, String newCategoryName){
		WxproCategory category = new WxproCategory();
		category.setId(categoryId);
		category.setName(newCategoryName);
		int count = wxproCategoryMapper.updateByPrimaryKeySelective(category);
		if(count>0){
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByErrorMessage("修改失败！");
	}
	
	public ServerResponse<List<WxproCategory>> getCategoryName(Integer parentId){
		List<WxproCategory> list = wxproCategoryMapper.selectByParentId(parentId);
		if(CollectionUtils.isEmpty(list)){
			logger.info("未找到改分类："+parentId);
		}
		return ServerResponse.createBySuccess(list);
	}
	
	public ServerResponse<List<WxproCategory>> selectCategoryChildrenById(Integer categoryId){
		
		Set<WxproCategory> categorySet = Sets.newHashSet();
		findChildCategory(categorySet, categoryId);
		List<WxproCategory> categoryList = Lists.newArrayList();
		for(WxproCategory item : categorySet){
			categoryList.add(item);
		}
		return ServerResponse.createBySuccess(categoryList);
	}
	
	private Set<WxproCategory> findChildCategory(Set<WxproCategory> categorySet, Integer categoryId){
		WxproCategory wxproCategory = wxproCategoryMapper.selectByPrimaryKey(categoryId);
		if(wxproCategory!=null){
			categorySet.add(wxproCategory);
		}
		List<WxproCategory> list = wxproCategoryMapper.selectByParentId(categoryId);
		for(WxproCategory item:list){
			findChildCategory(categorySet,item.getId());
		}
		return categorySet;
	}
	
	

}
