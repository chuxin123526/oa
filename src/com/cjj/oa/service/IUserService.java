package com.cjj.oa.service;

import java.util.List;

import com.cjj.oa.domain.User;

public interface IUserService
{
	public List<User> list() ; 
	public void add(User user) ; 
	public void delete(int id) ; 
	public void update(User user) ; 
	public User getById(int id) ; 	
	public User validateByLoginNameAndPassword(String loginName , String password) ; 
}
