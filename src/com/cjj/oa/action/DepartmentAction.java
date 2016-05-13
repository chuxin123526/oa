package com.cjj.oa.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cjj.oa.domain.Department;
import com.cjj.oa.service.IDepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport
{
	@Resource
	private IDepartmentService departmentServiceImpl ; 
	
	private Department department ; 
	private int parentId ; 
	
	
	public String list() throws Exception
	{
		List<Department> departmentList = null ; 
		if(this.parentId == 0)
		{
			departmentList = this.departmentServiceImpl.topList(); 		
		}
		else
		{
			departmentList = this.departmentServiceImpl.childrenList(this.parentId); 			
		}
		
		ActionContext.getContext().put("departmentList", departmentList);
		
		return "list" ; 
	}
	
	public String addUI() throws Exception
	{
		List<Department> departmentList = this.departmentServiceImpl.getDepartmentList() ;
		ActionContext.getContext().put("departmentList", departmentList);
		
		return "addUI" ; 
	}
	
	public String add() throws Exception
	{
		
		Department parentDepartment = this.departmentServiceImpl.getById(this.parentId) ; 
		this.department.setParent(parentDepartment);
		this.departmentServiceImpl.add(this.department);
		
		return "toList" ; 
	}
	
	
	public String delete() throws Exception
	{
		this.departmentServiceImpl.delete(department.getId());
		return "toList" ;
	}
	
	public String updateUI() throws Exception
	{
		this.department = this.departmentServiceImpl.getById(this.department.getId()) ; 
		System.out.println(this.department.getName());
		return "updateUI";
	}
	
	public String update() throws Exception
	{
		this.departmentServiceImpl.update(this.department);
		return "toList" ;
	}

	public IDepartmentService getDepartmentServiceImpl()
	{
		return departmentServiceImpl;
	}

	public void setDepartmentServiceImpl(IDepartmentService departmentServiceImpl)
	{
		this.departmentServiceImpl = departmentServiceImpl;
	}

	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public int getParentId()
	{
		return parentId;
	}

	public void setParentId(int parentId)
	{
		this.parentId = parentId;
	}
	
	

	
	
}
