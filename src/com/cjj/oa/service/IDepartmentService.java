package com.cjj.oa.service;

import java.util.List;

import com.cjj.oa.domain.Department;

public interface IDepartmentService
{
	public List<Department> list() ;
	public void add(Department department) ; 
	public void delete(int id) ; 
	public void update(Department department) ; 
	public Department getById(int id) ; 
	public List<Department> topList() ; 
	public List<Department> childrenList(int parentId) ; 
	public List<Department> getDepartmentList() ;
	public void getChildrenDepartmentList(List<Department> departmentList  ,String f, int parentId) ;
}
