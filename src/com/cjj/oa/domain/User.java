package com.cjj.oa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable
{
	private int id ; //id 
	private String loginName ; // 登录名 
	private String password ; //密码
	private String name ; //真实姓名
	private String gender ; // 性别
	private String phoneNumber ; //电话号码
	private String email ; //邮箱
	private String description ; // 说明
	
	private Department department ; // 所属部门
	private Set<Role> roles = new HashSet<Role>() ; // 任职岗位
	
	private Set<Topic> topics = new HashSet<Topic>() ; 
	private Set<Reply> replys = new HashSet<Reply>() ;
	
	
	public boolean hasPrivilegeByUrl(String url)
	{
		if(!this.loginName.equals("admin"))
		{
			for(Role role : this.roles)
			{
				for(Privilege privilege : role.getPrivileges())
				{
					if(url.equals(privilege.getUrl()))
					{
						return true ; 
					}
				}
			}
		}
		else
		{
			return true ; 
		}
		
		return false ; 
	}
	
	public boolean hasPrivilegeById(String privilegeId)
	{
		if(this.loginName.equals("admin"))
		{
			return true ; 
		}
		
		for(Role role : roles)
		{
			for(Privilege privilege : role.getPrivileges())
			{
				if(privilege.getId() == Integer.parseInt(privilegeId))
				{
					return true ; 
				}
			}
		}
		return false ;
	}
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getLoginName()
	{
		return loginName;
	}
	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Department getDepartment()
	{
		return department;
	}
	public void setDepartment(Department department)
	{
		this.department = department;
	}
	public Set<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	public Set<Topic> getTopics()
	{
		return topics;
	}

	public void setTopics(Set<Topic> topics)
	{
		this.topics = topics;
	}

	public Set<Reply> getReplys()
	{
		return replys;
	}

	public void setReplys(Set<Reply> replys)
	{
		this.replys = replys;
	}
	
	
	
}
