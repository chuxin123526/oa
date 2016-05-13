package com.cjj.oa.domain;

import java.util.HashSet;
import java.util.Set;

public class Forum
{
	private int id ; 
	private String name ; 
	private String description ; 
	private int position ; // 排序位置
	
	private Set<Topic> topics  = new HashSet<Topic>() ; 
	private int topicCount ; // 主题数
	private int articleCount ; //文章数
	private Topic lastTopic ; //最后发表的主题
	
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
	public int getPosition()
	{
		return position;
	}
	public void setPosition(int position)
	{
		this.position = position;
	}
	public Set<Topic> getTopics()
	{
		return topics;
	}
	public void setTopics(Set<Topic> topics)
	{
		this.topics = topics;
	}
	public int getTopicCount()
	{
		return topicCount;
	}
	public void setTopicCount(int topicCount)
	{
		this.topicCount = topicCount;
	}
	public int getArticleCount()
	{
		return articleCount;
	}
	public void setArticleCount(int articleCount)
	{
		this.articleCount = articleCount;
	}
	public Topic getLastTopic()
	{
		return lastTopic;
	}
	public void setLastTopic(Topic lastTopic)
	{
		this.lastTopic = lastTopic;
	}
	
	

	
}
