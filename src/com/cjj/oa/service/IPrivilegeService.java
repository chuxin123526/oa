package com.cjj.oa.service;

import java.util.List;

import com.cjj.oa.domain.Privilege;

public interface IPrivilegeService
{
	public List<Privilege> topList() ; 
	public List<Privilege> getByIds(Integer[] ids) ; 
	public List<Privilege> list() ; 
}
