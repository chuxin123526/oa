package com.cjj.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.dao.IPrivilegeDao;
import com.cjj.oa.domain.Privilege;
import com.cjj.oa.service.IPrivilegeService;

@Transactional
@Service
public class PrivilegeServiceImpl implements IPrivilegeService
{
	@Resource
	private IPrivilegeDao privilegeDaoImpl ; 

	@Override
	public List<Privilege> topList()
	{
		return this.privilegeDaoImpl.topList();
	}

	@Override
	public List<Privilege> getByIds(Integer[] ids)
	{
		
		return this.privilegeDaoImpl.getByIds(ids) ; 
	}

	@Override
	public List<Privilege> list()
	{
		return this.privilegeDaoImpl.findAll() ;
	}



}
