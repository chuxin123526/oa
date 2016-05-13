package com.cjj.oa.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cjj.oa.domain.Forum;
import com.cjj.oa.domain.Reply;
import com.cjj.oa.domain.Topic;
import com.cjj.oa.domain.User;
import com.cjj.oa.service.IForumService;
import com.cjj.oa.service.IReplyService;
import com.cjj.oa.service.ITopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ReplyAction extends ActionSupport
{
	@Resource
	private IReplyService replyServiceImpl ; 
	
	@Resource
	private ITopicService topicServiceImpl ; 
	
	private Reply reply ;
	private Topic topic ;
	
	public String addUI() throws Exception
	{
		this.topic = this.topicServiceImpl.getById(this.topic.getId()) ; 
		return "addUI" ;
	}
	
	public String add() throws Exception
	{
		this.topic = this.topicServiceImpl.getById(this.topic.getId()) ; 
		this.reply.setTopic(this.topic);
		this.reply.setAuthor((User)ActionContext.getContext().getSession().get("user"));
		this.reply.setPostTime(new Date());
		this.reply.setIpAddress(ServletActionContext.getRequest().getRemoteAddr());
	
		this.replyServiceImpl.add(this.reply);
		
		return "toTopic" ;
	}
	
	
	
	

	public Reply getReply()
	{
		return reply;
	}

	public void setReply(Reply reply)
	{
		this.reply = reply;
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
