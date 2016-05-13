package com.cjj.oa.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cjj.oa.domain.Privilege;
import com.cjj.oa.domain.Role;
import com.cjj.oa.service.IPrivilegeService;
import com.cjj.oa.service.IRoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport
{
	@Resource
	private IRoleService roleServiceImpl ; 
	
	@Resource
	private IPrivilegeService privilegeServiceImpl ; 
	
	private Role role ; 
	private Integer[] privilegeIds ; 
	

	public String setPrivilegeUI() throws Exception
	{
		this.role = this.roleServiceImpl.getById(this.role.getId()) ;
		
		Set<Privilege> privilegeList = this.role.getPrivileges() ; 
		
		this.privilegeIds = new Integer[privilegeList.size()] ; 
		int i = 0 ; 
		for(Privilege privilege : this.role.getPrivileges())
		{
			this.privilegeIds[i++] = privilege.getId() ; 
		}
		
		List<Privilege> topPrivilegeList = this.privilegeServiceImpl.topList() ; 
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
		
		return "setPrivilegeUI" ; 
	}
	
	public String setPrivilege() throws Exception
	{
		this.role = this.roleServiceImpl.getById(this.role.getId()) ; 
		List<Privilege> privilegeList = this.privilegeServiceImpl.getByIds(this.privilegeIds) ; 
		Set<Privilege> set = new HashSet<Privilege>(privilegeList) ;
		this.role.setPrivileges(set);
		this.roleServiceImpl.update(this.role);
		return "toList" ; 
	}
	
	public String list() throws Exception
	{
		List<Role> list = this.roleServiceImpl.list() ; 
		ActionContext.getContext().put("roleList", list);
		return "list" ; 
	}
	
	
	public String add() throws Exception
	{
		this.roleServiceImpl.add(this.role);
		return "toList" ; 
	}
	
	public String addUI() throws Exception
	{
		return "addUI" ; 
	}
	
	public String delete() throws Exception
	{
		this.roleServiceImpl.delete(role.getId());
		return "toList" ; 
	}
	
	public String update() throws Exception
	{
		this.roleServiceImpl.update(this.role);
		return "toList" ; 
	}
	
	public String updateUI() throws Exception
	{
		Role roleUpdate= this.roleServiceImpl.getById(role.getId()) ;
		this.role.setName(roleUpdate.getName());
		this.role.setDescription(roleUpdate.getDescription());
		return "updateUI" ; 
	}


	public IRoleService getRoleServiceImpl()
	{
		return roleServiceImpl;
	}


	public void setRoleServiceImpl(IRoleService roleServiceImpl)
	{
		this.roleServiceImpl = roleServiceImpl;
	}


	public Role getRole()
	{
		return role;
	}


	public void setRole(Role role)
	{
		this.role = role;
	}

	public Integer[] getPrivilegeIds()
	{
		return privilegeIds;
	}

	public void setPrivilegeIds(Integer[] privilegeIds)
	{
		this.privilegeIds = privilegeIds;
	}
	
	

	
}
