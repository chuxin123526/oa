package com.cjj.oa.base.impl;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.cjj.oa.base.IBaseDao;

public class BaseDaoImpl<T>  implements IBaseDao<T>
{
	@Resource
	protected SessionFactory sessionFactory ; 
	private Class clazz ;
	
	public BaseDaoImpl()
	{
		Type genType = getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        clazz = (Class) params[0];
	}
	
	@Override
	public void add(T entity)
	{
		sessionFactory.getCurrentSession().save(entity) ; 
	}

	@Override
	public void deleteByid(int id)
	{
		System.out.println("enter");
		Object object = this.getById(id);
		
		sessionFactory.getCurrentSession().delete(object) ;
	}

	@Override
	public void update(T entity)
	{
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public T getById(int id)
	{
		T entity = (T)sessionFactory.getCurrentSession().load(clazz, id) ;
		return entity ;
	}

	@Override
	public List<T> findAll()
	{
		String hql = "from "+clazz.getSimpleName() ;
		return sessionFactory.getCurrentSession().createQuery(hql).list() ;
		
	}

	@Override
	public List<T> getByIds(Integer[] ids)
	{ 
		String hql = "from "+clazz.getSimpleName()+" where id in(:ids)" ; 
		
		return sessionFactory.getCurrentSession().createQuery(hql).setParameterList("ids", ids).list() ;
	}

}
