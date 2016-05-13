package com.cjj.oa.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cjj.oa.domain.Department;
import com.cjj.oa.domain.Role;
import com.cjj.oa.domain.User;
import com.cjj.oa.service.IDepartmentService;
import com.cjj.oa.service.IRoleService;
import com.cjj.oa.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.smtp.DigestMD5;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport
{
	@Resource
	private IUserService userServiceImpl ;
	@Resource
	private IDepartmentService departmentServiceImpl ; 
	@Resource
	private IRoleService roleServiceImpl ;
	
	private User user ; 
	private Integer[] roleIds ; 
	private int departmentId ; 
	
	public String logout() throws Exception
	{
		ActionContext.getContext().getSession().remove("user") ; 
		return "loginUI" ; 
	}
	
	
	public String loginUI() throws Exception
	{
		return "loginUI" ;
	}
	
	public String index() throws Exception
	{
		return "toIndex" ; 
	}
	
	public String login() throws Exception
	{
		this.user = this.userServiceImpl.validateByLoginNameAndPassword
				(this.user.getLoginName(), DigestUtils.md5Hex(this.user.getPassword())) ; 
		if(this.user != null)
		{
			ActionContext.getContext().getSession().put("user", this.user) ; 
			return "index" ; 
		}
		else
		{
			return "loginUI" ; 
		}
		
	}
	
	public String list() throws Exception
	{
		List<User> userList = this.userServiceImpl.list() ; 
		ActionContext.getContext().put("userList", userList);
		return "list" ; 
	}
	
	public String addUI() throws Exception
	{
		List<Department> departmentList = this.departmentServiceImpl.getDepartmentList();
		ActionContext.getContext().put("departmentList" , departmentList) ;	
		List<Role> roleList = this.roleServiceImpl.list() ;
		ActionContext.getContext().put("roleList" , roleList) ;
		return "addUI" ; 
	}
	
	public String add() throws Exception
	{
		this.user.setPassword(DigestUtils.md5Hex("1234"));
		this.userServiceImpl.add(this.user);
		return "toList" ; 
	}
	
	public String delete() throws Exception
	{
		this.userServiceImpl.delete(this.user.getId());
		return "toList" ; 
	}
	
	public String updateUI() throws Exception
	{
		this.user = this.userServiceImpl.getById(this.user.getId()) ;
		List<Department> departmentList = this.departmentServiceImpl.getDepartmentList();
		ActionContext.getContext().put("departmentList" , departmentList) ;	
		List<Role> roleList = this.roleServiceImpl.list() ;
		ActionContext.getContext().put("roleList" , roleList) ; 
		return "updateUI" ; 
	}
	
	public String initPassword()
	{
		this.user = this.userServiceImpl.getById(this.user.getId()) ; 
		this.user.setPassword(DigestUtils.md5Hex("1234"));	
		this.userServiceImpl.update(user);
		return "toList" ; 
	}
	
	public String update() throws Exception
	{
		User user = this.userServiceImpl.getById(this.user.getId()) ; 
		this.user.setPassword(user.getPassword());
		this.user.setDepartment(this.departmentServiceImpl.getById(this.departmentId));
		if(this.roleIds != null && this.roleIds.length != 0)
		{
			List<Role> roleList = this.roleServiceImpl.getByIds(this.roleIds) ;
			Set<Role> set = new HashSet<Role>(roleList) ;
			this.user.setRoles(set);
		}
		this.userServiceImpl.update(this.user);
		return "toList" ; 
	}

	public IUserService getUserServiceImpl()
	{
		return userServiceImpl;
	}

	public void setUserServiceImpl(IUserService userServiceImpl)
	{
		this.userServiceImpl = userServiceImpl;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Integer[] getRoleIds()
	{
		return roleIds;
	}

	public void setRoleIds(Integer[] roleIds)
	{
		this.roleIds = roleIds;
	}

	public int getDepartmentId()
	{
		return departmentId;
	}

	public void setDepartmentId(int departmentId)
	{
		this.departmentId = departmentId;
	}
	
	
	
	
}
