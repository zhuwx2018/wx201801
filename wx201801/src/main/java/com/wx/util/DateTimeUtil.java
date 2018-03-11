package com.wx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);
	
	private static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static Date strToDate(String strDate, String formatStr){
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			format.parse(strDate);
		} catch (ParseException e) {
			logger.error("时间格式转换出错",e);
		}
		return null;
	}
	
	public static String DateToStr(Date date, String formatStr){
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(date);
	}
	
	public static Date strToDate(String strDate){
		return strToDate(strDate,STANDARD_FORMAT);
	}
	
	public static String DateToStr(Date date){
		return DateToStr(date,STANDARD_FORMAT);
	}
	
	public static Date currentDate(){
		return new Date();
	}

}
