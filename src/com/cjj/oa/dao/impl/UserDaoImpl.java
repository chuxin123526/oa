package com.cjj.oa.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.base.impl.BaseDaoImpl;
import com.cjj.oa.dao.IUserDao;
import com.cjj.oa.domain.User;

@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao
{

	@Override
	public User validateByLoginNameAndPassword(String loginName , String password)
	{
		String hql = "from User u where u.loginName = ? and u.password = ?" ; 
		User user = (User)this.sessionFactory.getCurrentSession().createQuery(hql).
				setParameter(0, loginName).setParameter(1, password).uniqueResult() ; 

		return user ; 
	}

}
