package com.cjj.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.base.impl.BaseDaoImpl;
import com.cjj.oa.dao.IDepartmentDao;
import com.cjj.oa.domain.Department;

@Repository
@Transactional
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements IDepartmentDao
{

	@Override
	public List<Department> topList()
	{
		String hql = "from Department d where d.parent.id is null" ;
		List<Department> list = this.sessionFactory.getCurrentSession().createQuery(hql).list() ;
		return list;
	}

	@Override
	public List<Department> childrenList(int parentId)
	{	
		String hql = "from Department d where d.parent.id=?" ; 
		
		return this.sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, parentId).list() ; 
	}
	
}
