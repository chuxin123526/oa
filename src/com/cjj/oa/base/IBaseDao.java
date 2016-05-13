package com.cjj.oa.base;

import java.util.List;

public interface IBaseDao<T>
{
	public void add(T entity) ; 
	public void deleteByid(int id) ;
	public void update(T entity) ; 
	public T getById(int id) ; 
	public List<T> findAll() ; 
	public List<T> getByIds(Integer[] ids) ;
}
