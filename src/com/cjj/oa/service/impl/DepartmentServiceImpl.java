package com.cjj.oa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.dao.IDepartmentDao;
import com.cjj.oa.domain.Department;
import com.cjj.oa.service.IDepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService
{

	@Resource
	private IDepartmentDao departmentDaoImpl ; 
	
	@Override
	public List<Department> list()
	{
		return this.departmentDaoImpl.findAll();
	}

	@Override
	public void add(Department department)
	{
		this.departmentDaoImpl.add(department);		
	}

	@Override
	public void delete(int id)
	{
		this.departmentDaoImpl.deleteByid(id);
	}

	@Override
	public void update(Department department)
	{
		this.departmentDaoImpl.update(department);
	}

	@Override
	public Department getById(int id)
	{	
		return this.departmentDaoImpl.getById(id) ;
	}

	@Override
	public List<Department> topList()
	{	
		List<Department> list = this.departmentDaoImpl.topList() ; 
		
		return list ; 
	}

	@Override
	public List<Department> childrenList(int parentId)
	{
		List<Department> list = this.departmentDaoImpl.childrenList(parentId) ; 

		return list ; 
	}

	@Override
	public List<Department> getDepartmentList()
	{
		List<Department> list = this.topList() ;
		List<Department> departmentList = new ArrayList<Department>() ; 
		for(Department department : list)
		{		
			this.getChildrenDepartmentList(departmentList,"" ,  department.getId());
		}
		return departmentList ; 
	}

	@Override
	public void getChildrenDepartmentList(List<Department> departmentList,
			String f, int parentId)
	{
		Department tempDepartment = new Department() ; 
		 Department department = this.getById(parentId) ; 
		 tempDepartment.setId(department.getId());
		 tempDepartment.setName(f+department.getName());
		 departmentList.add(tempDepartment) ; 
		 for(Department d : department.getDepartments())
		 {
			 this.getChildrenDepartmentList(departmentList, f+"　　", d.getId());
		 }
		
	}

}
