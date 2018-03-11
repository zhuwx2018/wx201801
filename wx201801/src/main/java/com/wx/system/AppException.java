package com.wx.system;

/**
 *<p>Title: AppException</p>
 *<p>Description: 自定义异常类</p>
 * @author zhugf
 * @date 2018年2月12日
 */
public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public AppException() {
	}
	public AppException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
