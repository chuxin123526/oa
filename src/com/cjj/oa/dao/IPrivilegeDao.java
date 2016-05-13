package com.cjj.oa.dao;

import java.util.List;

import com.cjj.oa.base.IBaseDao;
import com.cjj.oa.domain.Privilege;

public interface IPrivilegeDao extends IBaseDao<Privilege>
{
	public List<Privilege> topList() ; 
}
