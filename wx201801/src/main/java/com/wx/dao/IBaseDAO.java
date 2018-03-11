package com.wx.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

/**
* 抽象出所有DAO应遵循的接口
*
* @param <T>
*实体类型
*/
public interface IBaseDAO<T> {
    Serializable save(T transientInstance);
    /**
    * 删除实体
    *
    * @param persistentInstance
    *持久态对象
    */
    public void delete(T persistentInstance);
    /**
    *
    * @param instance
    *瞬时态或者持久态对象
    */
    public void saveOrUpdate(T instance);
    /**
    * 复制给定对象的状态到与之拥有同样id的持久对象，如果当前session没有该持久对象，
      则load一个，更新持久对象
    * 如果没有id，则保存并返回持久对象
    * 指定的这个对象，永远不会与session发生关联，这个和saveOrUpdate是不同的
    * 如果cascade="merge"，这个操作会级联到关联对象
    * 该方法是为了解决一个session有两个标识相同的实体的时候无法更新的问题
    *
    * @param detachedInstance
    *脱管对象，即将合并到对应的持久态对象
    *@return更新过的、注册的持久态对象
    */
    public T merge(T detachedInstance);
    /**
    * 根据id查询实体
    *
    * @param id
    * @return T
    */
    public T findById(Serializable id);
    /**
    * 根据id删除实体
    *
    * @param id
    */
    void deleteById(Serializable id);
    /**
    * 根据示例查询
    *
    * @param instance
    *示例
    * @param enableLike
    *是否对字符串执行like操作
    * @param excludeProperty
    *要排除的比对属性
    * @return List<T>
    */
    public List<T> findByExample(T instance, boolean enableLike,
            String... excludeProperty);
    /**
    * 根据单个属性查询
    *
    * @param propertyName
    *属性名
    * @param value
    *属性值
    * @return List<T>
    */
    public List<T> findByProperty(String propertyName, Object value);
    /**
    * 根据多个属性查询
    *
    * @param propertyNames
    * @param values
    * @return List<T>
    */
    public List<T> findByProperties(String[] propertyNames, Object[] values);
    /**
    * 根据单个属性查询，带分页功能
    *
    * @param pageNo
    *页码，从1开始
    * @param pageSize
    *每页记录数
    * @param propertyName
    *属性名
    * @param value
    *属性值
    * @return List<T>
    */
    public List<T> findByProperty(int pageNo, int pageSize,
            String propertyName, Object value);
    /**
    * 根据多个属性查询，带分页功能
    *
    * @param pageNo
    * @param pageSize
    * @param propertyNames
    * @param values
    * @return List<T>
    */
    public List<T> findByProperties(int pageNo, int pageSize,
            String[] propertyNames, Object[] values);
    /**
    * 获取所有实体实例
    *
    * @return List<T>
    */
    public List<T> findAll();
    /**
    * 无条件查询所有实体实例，带分页功能
    *
    * @param pageNo
    * 页码，从1开始
    * @param pageSize
    * 每页记录数
    * @return List<T>
    */
    public List<T> findAll(int pageNo, int pageSize);
    
    Session getSession();

}
