package com.wx.dao;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml","classpath:spring-mybatis.xml"})
public class UserinfoMapperTest {
	@Autowired
	private SqlSession sqlSession;
	@Test
	public void test() {
		UserinfoMapper mapper = sqlSession.getMapper(UserinfoMapper.class);
		mapper.selectByPrimaryKey("1001");
		mapper.selectByPrimaryKey("1001");
	}

}
