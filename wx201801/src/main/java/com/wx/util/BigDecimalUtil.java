package com.wx.util;

import java.math.BigDecimal;

/**
 *<p>Title: BigDecimalUtil</p>
 *<p>Description: 计算处理工具类</p>
 * @author zhugf
 * @date 2018年2月24日
 */
public class BigDecimalUtil {
	
	private BigDecimalUtil(){}
	
	public static BigDecimal add(double d1, double d2){
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.add(b2);
	}
	
	public static BigDecimal subtract(double d1, double d2){
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.subtract(b2);
	}
	

	public static BigDecimal multiply(double d1, double d2){
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.multiply(b2);
	}
	
	public static BigDecimal divide(double d1, double d2){
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);//四舍五入保留两位小数
	}

}
