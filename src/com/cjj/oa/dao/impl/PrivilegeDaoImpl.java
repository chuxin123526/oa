package com.cjj.oa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.base.impl.BaseDaoImpl;
import com.cjj.oa.dao.IPrivilegeDao;
import com.cjj.oa.domain.Privilege;

@Transactional
@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements IPrivilegeDao
{
	@Resource
	private SessionFactory sessionFactory ; 

	@Override
	public List<Privilege> topList()
	{
		String hql = "from Privilege p where p.parent is null " ; 
		List<Privilege> list = this.sessionFactory.getCurrentSession().createQuery(hql).list() ; 
		return list ; 
	}

}
