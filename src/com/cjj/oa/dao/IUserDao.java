package com.cjj.oa.dao;

import com.cjj.oa.base.IBaseDao;
import com.cjj.oa.domain.User;

public interface IUserDao extends IBaseDao<User>
{
	public User validateByLoginNameAndPassword(String loginName , String password) ; 
}
