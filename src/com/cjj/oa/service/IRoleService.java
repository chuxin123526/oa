package com.cjj.oa.service;

import java.util.List;

import com.cjj.oa.domain.Role;

public interface IRoleService
{
	public List<Role> list() ; 
	public void add(Role role) ; 
	public void delete(int id) ; 
	public void update(Role role) ; 
	public Role getById(int id) ; 
	public List<Role> getByIds(Integer[] ids) ; 
}
