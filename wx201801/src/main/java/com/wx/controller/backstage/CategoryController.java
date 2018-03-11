package com.wx.controller.backstage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.common.ServerResponse;
import com.wx.model.WxproCategory;
import com.wx.service.ICategoryService;

@Controller
@RequestMapping("/manage/category/")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	
	@RequestMapping("add_category")
	@ResponseBody
	public ServerResponse<?> addCategory(HttpSession session,@RequestParam(value="parentId",defaultValue="0") int parentId, String categoryName){
		
		return categoryService.addCategory(parentId, categoryName);
	}

	@RequestMapping("update_name")
	@ResponseBody
	public ServerResponse<?> updateCategoryName(Integer categoryId,String newCategoryName){
		
		return categoryService.updateCategoryName(categoryId, newCategoryName);
	}

	@RequestMapping("get_category")
	@ResponseBody
	public ServerResponse<List<WxproCategory>>  getCategory(@RequestParam(value="parentId",defaultValue="0")Integer parentId){
		
		return categoryService.getCategoryName(parentId);
		
	}
	@RequestMapping("get_deep_category")
	@ResponseBody
	public ServerResponse<List<WxproCategory>>  getDeepCategory(Integer categoryId){
		return categoryService.selectCategoryChildrenById(categoryId);
	}
	
	
	
	
	

}
