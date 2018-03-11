package com.wx.common;

/**
 *<p>Title: ResponseCode</p>
 *<p>Description:相应编码枚举类 </p>
 * @author zhugf
 * @date 2018年2月23日
 */
public enum ResponseCode {
	
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");
    /**
     * 代码
     */
    private final int code;
    /**
     * 描述
     */
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
