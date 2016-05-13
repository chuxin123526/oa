package com.cjj.oa.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cjj.oa.domain.Forum;
import com.cjj.oa.domain.Topic;
import com.cjj.oa.domain.User;
import com.cjj.oa.service.IForumService;
import com.cjj.oa.service.ITopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TopicAction extends ActionSupport
{	
	@Resource
	private ITopicService topicServiceImpl ; 
	
	@Resource
	private IForumService forumServiceImpl ; 
	
	private Forum forum ; 
	private Topic topic ; 

	
	public String addUI() throws Exception
	{
		this.forum = this.forumServiceImpl.getById(this.forum.getId()) ; 
		return "addUI" ; 
	}
	
	public String add() throws Exception
	{
		System.out.println(topic.getTitle());
		
		
		User user = (User)ActionContext.getContext().getSession().get("user") ; 
		this.topic.setAuthor(user); 
		this.topic.setPostTime(new Date()) ; 
		this.topic.setIpAddress(ServletActionContext.getRequest().getRemoteAddr());
		this.topic.setForum(this.forumServiceImpl.getById(this.forum.getId()));
		this.topic.setLastUpdateTime(new Date());
		
		this.topicServiceImpl.add(this.topic);
		
		
		return "toShow" ; 
	}
	
	
	public String show() throws Exception
	{
		this.topic = this.topicServiceImpl.getById(this.topic.getId()) ;
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

	public Topic getTopic()
	{
		return topic;
	}

	public void setTopic(Topic topic)
	{
		this.topic = topic;
	}

	
	
	
	
}
