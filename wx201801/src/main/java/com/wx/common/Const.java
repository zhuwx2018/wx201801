package com.wx.common;

/**
 *<p>Title: Const</p>
 *<p>Description:全局的常量 </p>
 * @author zhugf
 * @date 2018年2月23日
 */
public class Const {
	
	public static final String CURRENT_USER = "CURRENT_USER";
	
	public interface Cart{
		/**选中*/
		int CHECKEED = 1;
		/**未选中*/
		int UN_CHECKED = 0;
		
		String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
		String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
	}

}
