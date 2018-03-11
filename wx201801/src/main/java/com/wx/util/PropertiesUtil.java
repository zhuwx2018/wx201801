package com.wx.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *<p>Title: PropertiesUtil</p>
 *<p>Description: </p>
 * @author zhugf
 * @date 2018年3月6日
 */
public class PropertiesUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	
	public static Properties properties;
	
	static{
		properties = new Properties();
		try {
			properties.load(new InputStreamReader((PropertiesUtil.class.getClassLoader().getResourceAsStream("wxpro.properties")),"UTF-8"));
		} catch (IOException e) {
			logger.error("配置文件读取异常",e);
		}
	}
	
	/**
	 * 获取参数配置
	 * @param key
	 * @return
	 */
	public static String getProperty(String key){
		String value = properties.getProperty(key.trim());
		if(StringUtils.isEmpty(value)){
			return null;
		}
		return key;
	}
	
	public static String getProperty(String key, String defaultValue){
		String value = properties.getProperty(key.trim());
		if(StringUtils.isEmpty(value)){
			value = defaultValue;
		}
		return key;
	}

}
