package com.wx.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import net.sf.ehcache.hibernate.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wx.dao.IBaseDAO;

public abstract class BaseDAO<T> implements IBaseDAO<T> {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseDAO.class);
	private Class<T> clazz;
	private Session session;
	@SuppressWarnings("unchecked")
	public BaseDAO(){
		 //获取泛型参数的具体类型
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public void setSession(Session session) {
		this.session = session;
	}
	@Override
	public Session getSession() {
		if(session ==null){
			
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		List<T> lsit = getSession().createCriteria(clazz).add(Restrictions.eq(propertyName, value)).list();
		return lsit;
	}
	
	

}
