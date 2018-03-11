package com.wx.service;

import java.util.List;

import com.wx.common.ServerResponse;
import com.wx.model.WxproCategory;

public interface ICategoryService {
	public ServerResponse addCategory(Integer parentId, String name);
	
	public ServerResponse updateCategoryName(Integer categoryId, String newCategoryName);
	
	public ServerResponse<List<WxproCategory>> getCategoryName(Integer parentId);
	
	public ServerResponse<List<WxproCategory>> selectCategoryChildrenById(Integer categoryId);

}
