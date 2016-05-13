
package com.cjj.oa.domain;

import java.util.Date;

public class Reply
{
	private int id ; 
	private String title ; 
	private String content ; 
	private String faceIcon ; 
	
	private User author ; // 作者
	private Date postTime ; //发表时间
	private String ipAddress ; //ip地址
	private Topic topic ; // 所属主题
	
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
	public Topic getTopic()
	{
		return topic;
	}
	public void setTopic(Topic topic)
	{
		this.topic = topic;
	}
	
	
}
