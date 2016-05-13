package com.cjj.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.dao.IRoleDao;
import com.cjj.oa.dao.impl.RoleDaoImpl;
import com.cjj.oa.domain.Role;
import com.cjj.oa.service.IRoleService;

@Transactional
@Service
public class RoleServiceImpl implements IRoleService
{
	@Resource
	private IRoleDao roleDaoImpl ; 
	
	@Override
	public List<Role> list()
	{	
		return roleDaoImpl.findAll() ;
	}

	@Override
	public void add(Role role)
	{
		roleDaoImpl.add(role);
	}

	@Override
	public void delete(int id)
	{
		roleDaoImpl.deleteByid(id);
	}

	@Override
	public void update(Role role)
	{
		roleDaoImpl.update(role);
	}

	@Override
	public Role getById(int id)
	{
		return roleDaoImpl.getById(id) ; 
	}

	@Override
	public List<Role> getByIds(Integer[] ids)
	{		
		return this.roleDaoImpl.getByIds(ids) ; 
	}

}
