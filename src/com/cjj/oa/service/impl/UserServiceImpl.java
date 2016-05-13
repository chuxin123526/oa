package com.cjj.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.dao.IUserDao;
import com.cjj.oa.domain.User;
import com.cjj.oa.service.IUserService;

@Transactional
@Service
public class UserServiceImpl implements IUserService
{
	@Resource
	private IUserDao userDaoImpl ;

	@Override
	public List<User> list()
	{		
		return this.userDaoImpl.findAll() ;
	}

	@Override
	public void add(User user)
	{
		this.userDaoImpl.add(user);
	}

	@Override
	public void delete(int id)
	{
		this.userDaoImpl.deleteByid(id);
	}

	@Override
	public void update(User user)
	{
		this.userDaoImpl.update(user);
	}

	@Override
	public User getById(int id)
	{
		return this.userDaoImpl.getById(id) ; 
	}

	@Override
	public User validateByLoginNameAndPassword(String loginName, String password)
	{
		return this.userDaoImpl.validateByLoginNameAndPassword(loginName, password);
	}

}
