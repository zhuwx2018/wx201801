package com.wx.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author zhugf
 * <p>中文转汉语拼音工具类</p>
 */
public class PinyinUtils {
	
	/**
	 * 汉字转拼音小写,英文字母不变,存在多音字的以数组第一个为准
	 * @param inputString
	 * @return
	 */
	public static String changeToPingyin(String inputString){
		
		StringBuffer sb = new StringBuffer();
		char[] strArray = inputString.toCharArray();
		//格式化输出
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		/*
			其中使用HanyuPinyinOutputFormat来格式化返回拼音的格式还有例如以下几种： 
		- WITH_V：用v表示ü (nv) 
		- WITH_U_AND_COLON：用”u:”表示ü (nu:) 
		- WITH_U_UNICODE：直接用ü (nü) 
		–>使用：format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE); 
		- UPPERCASE：大写 (XING) 
		- LOWERCASE：小写 (xing) 
		–>使用：format.setCaseType(HanyuPinyinCaseType.LOWERCASE); 
		- WITHOUT_TONE：无音标 (xing) 
		- WITH_TONE_NUMBER：1-4数字表示英标 (xing2) 
		- WITH_TONE_MARK：直接用音标符 
		–>使用：format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK); 
		 */
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);
		for(char strChar:strArray){
			if(strChar>128){
				try {
					sb.append(PinyinHelper.toHanyuPinyinStringArray(strChar,format)[0]);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			}else{
				sb.append(strChar);
			}
		}
		return sb.toString();
	}
	 /**
     * 将字符串中的中文转化为拼音,英文字符不变
     *
     * @param inputString 汉字
     * @return
     */
    public static String getPingYin(String inputString) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String output = "";
        if (inputString != null && inputString.length() > 0
                && !"null".equals(inputString)) {
            char[] input = inputString.trim().toCharArray();
            try {
                for (int i = 0; i < input.length; i++) {
                    if (java.lang.Character.toString(input[i]).matches(
                            "[\\u4E00-\\u9FA5]+")) {
                        String[] temp = PinyinHelper.toHanyuPinyinStringArray(
                                input[i], format);
                        output += temp[0];
                    } else
                        output += java.lang.Character.toString(input[i]);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            return "*";
        }
        return output;
    }
    
    /**
     * 汉字转换位汉语拼音首字母，英文字符不变
     *
     * @param chines 汉字
     * @return 拼音
     */
    public static String converterToFirstSpell(String chines) {
        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(
                            nameChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }
    
    /**
     * 获得汉语拼音首字母
     *
     * @param chines 汉字
     * @return
     */
    public static String getAlpha(String chines) {
        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(
                            nameChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }

	
}
