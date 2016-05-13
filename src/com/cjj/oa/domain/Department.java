package com.cjj.oa.domain;

import java.util.HashSet;
import java.util.Set;

public class Department
{
	private int id ; // id 
	private String name ; // 部门名称
	private String description ; // 描述
	
	private Department parent ; //父部门
	private Set<Department> departments = new HashSet<Department>() ; // 子部门 
	private Set<User> users = new HashSet<User>() ; // 部门所拥有员工 
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Department getParent()
	{
		return parent;
	}
	public void setParent(Department parent)
	{
		this.parent = parent;
	}
	public Set<Department> getDepartments()
	{
		return departments;
	}
	public void setDepartments(Set<Department> departments)
	{
		this.departments = departments;
	}
	public Set<User> getUsers()
	{
		return users;
	}
	public void setUsers(Set<User> users)
	{
		this.users = users;
	}
	
	
	
}
