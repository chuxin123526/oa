package com.cjj.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Topic
{
	private int id ; 
	private String title ; 
	private String content ; 
	private String faceIcon ; 
	
	private User author ; // 作者
	private Date postTime ; //发表时间
	private String ipAddress ; //ip地址
	
	private Forum forum ; //所属板块
	private Set<Reply> replys = new HashSet<Reply>() ; //回复
	private int type ; //帖子类型,0为普通帖，1为精华帖，2为置顶帖
	private int replyCount ; //回复数量
	private Reply lastReply ; //最后回复
	private Date lastUpdateTime ; // 最后更新时间
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getFaceIcon()
	{
		return faceIcon;
	}
	public void setFaceIcon(String faceIcon)
	{
		this.faceIcon = faceIcon;
	}
	public User getAuthor()
	{
		return author;
	}
	public void setAuthor(User author)
	{
		this.author = author;
	}
	public Date getPostTime()
	{
		return postTime;
	}
	public void setPostTime(Date postTime)
	{
		this.postTime = postTime;
	}
	public String getIpAddress()
	{
		return ipAddress;
	}
	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}
	public Forum getForum()
	{
		return forum;
	}
	public void setForum(Forum forum)
	{
		this.forum = forum;
	}
	public Set<Reply> getReplys()
	{
		return replys;
	}
	public void setReplys(Set<Reply> replys)
	{
		this.replys = replys;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public int getReplyCount()
	{
		return replyCount;
	}
	public void setReplyCount(int replyCount)
	{
		this.replyCount = replyCount;
	}
	public Reply getLastReply()
	{
		return lastReply;
	}
	public void setLastReply(Reply lastReply)
	{
		this.lastReply = lastReply;
	}
	public Date getLastUpdateTime()
	{
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime)
	{
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
	
}
