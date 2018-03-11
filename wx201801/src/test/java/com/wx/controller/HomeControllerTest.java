package com.wx.controller;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.PageHelper;
import com.wx.dao.UserinfoMapper;
import com.wx.model.Userinfo;
import com.wx.model.UserinfoExample;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml","classpath:spring-mybatis.xml","classpath:spring-cache.xml"})
public class HomeControllerTest {
	@Autowired
	private UserinfoMapper userInfoMapper;
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		//Userinfo userinfo = userInfoMapper.selectByPrimaryKey("1001");
//		UserinfoExample uie = new UserinfoExample();
//	//	PageHelper.startPage(2, 10);
//	    userInfoMapper.selectByExample(uie);
//	    userInfoMapper.selectByExample(uie);
		//System.out.println(userinfo.getUserName());
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//		format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
		String hanyu = "谁";
		try {
			System.out.println(PinyinHelper.toHanyuPinyinStringArray(hanyu.charAt(0), format)[1]);
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String str = "123";
	    System.out.println(DigestUtils.md5DigestAsHex(str.getBytes()));;
	}

}
