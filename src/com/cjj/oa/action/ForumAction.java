package com.cjj.oa.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cjj.oa.domain.Forum;
import com.cjj.oa.domain.Topic;
import com.cjj.oa.service.IForumService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ForumAction extends ActionSupport
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
	
	public String show() throws Exception
	{
		this.forum = this.forumServiceImpl.getById(this.forum.getId()) ;
		
		List<Topic> topicList = new ArrayList<Topic>(forum.getTopics()) ;
		ActionContext.getContext().put("topicList", topicList);
		return "show" ;
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
