package com.cjj.oa.dao;

import java.util.List;

import com.cjj.oa.base.IBaseDao;
import com.cjj.oa.domain.Department;

public interface IDepartmentDao extends IBaseDao<Department>
{
	public List<Department> topList() ; 
	public List<Department> childrenList(int parentId) ;
}
