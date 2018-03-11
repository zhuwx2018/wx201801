package com.wx.config.system;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;
//@ControllerAdvice
public class JSONPConfig extends AbstractJsonpResponseBodyAdvice{
	
	public JSONPConfig() {
		super("callback");
	}

}
