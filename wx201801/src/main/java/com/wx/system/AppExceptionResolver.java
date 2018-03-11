package com.wx.system;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

/**
 *<p>Title: AppExceptionResolver</p>
 *<p>Description:异常解析类 </p>
 * @author zhugf
 * @date 2018年2月12日
 */
public class AppExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		FastJsonJsonView view = new FastJsonJsonView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", false);
		if(ex instanceof AppException){
			map.put("msg", ex.getMessage());
		}else{
			map.put("msg", "未知的系统异常！");
		}
		view.setAttributesMap(map);
		ModelAndView mav = new ModelAndView();
		mav.setView(view);
		return mav;
	}

}
