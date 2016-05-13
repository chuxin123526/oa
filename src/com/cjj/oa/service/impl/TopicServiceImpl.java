package com.cjj.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.dao.IForumDao;
import com.cjj.oa.dao.ITopicDao;
import com.cjj.oa.domain.Forum;
import com.cjj.oa.domain.Topic;
import com.cjj.oa.service.ITopicService;

@Transactional
@Service
public class TopicServiceImpl implements ITopicService
{
	@Resource
	private ITopicDao topicDaoImpl ; 
	
	@Resource
	private IForumDao forumDaoImpl ;

	@Override
	public void add(Topic topic)
	{
		this.topicDaoImpl.add(topic);
		Forum forum = topic.getForum() ; 
		forum.setTopicCount(forum.getTopicCount()+1);
		forum.setArticleCount(forum.getArticleCount()+1);
		forum.setLastTopic(topic);
		this.forumDaoImpl.update(forum);
	}

	@Override
	public Topic getById(int id)
	{	
		return this.topicDaoImpl.getById(id) ;
	}

}
