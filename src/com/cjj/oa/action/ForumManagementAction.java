package com.cjj.oa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cjj.oa.domain.Forum;
import com.cjj.oa.service.IForumService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ForumManagementAction extends ActionSupport
{
	@Resource
	private IForumService forumServiceImpl ;
	
	private Forum forum ; 
	
	public String list() throws Exception
	{
		List<Forum> forumList = this.forumServiceImpl.list() ; 
		ActionContext.getContext().put("forumList", forumList);
		return "list" ; 
	}
	
	public String addUI() throws Exception
	{
		return "addUI" ; 
	}
	
	public String add() throws Exception
	{
		this.forumServiceImpl.add(this.forum);
		return "toList" ; 
	}
	
	public String delete() throws Exception
	{
		this.forumServiceImpl.delete(this.forum.getId());
		return "toList" ; 
	}
	
	public String updateUI() throws Exception
	{
		this.forum = this.forumServiceImpl.getById(this.forum.getId()) ; 
		
		return "updateUI" ;
	}
	
	public String moveUp() throws Exception
	{
		this.forumServiceImpl.moveUp(this.forum.getId());
		return "toList" ;
	}
	
	public String moveDown() throws Exception
	{
		this.forumServiceImpl.moveDown(this.forum.getId());
		return "toList" ;
	}
	
	public String update() throws Exception
	{
		//取出原对象
		Forum forum1 = this.forumServiceImpl.getById(this.forum.getId()) ; 
		
		//设置属性
		forum1.setName(this.forum.getName());
		forum1.setDescription(this.forum.getDescription());
		
		//保存
		this.forumServiceImpl.update(forum1);
		
		return "toList" ; 
	}

	
	
	public Forum getForum()
	{
		return forum;
	}

	public void setForum(Forum forum)
	{
		this.forum = forum;
	}
	
	
	
	
	
}
