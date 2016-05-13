package com.cjj.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.dao.IForumDao;
import com.cjj.oa.dao.IReplyDao;
import com.cjj.oa.dao.ITopicDao;
import com.cjj.oa.domain.Forum;
import com.cjj.oa.domain.Reply;
import com.cjj.oa.domain.Topic;
import com.cjj.oa.service.IReplyService;

@Transactional
@Service
public class ReplyServiceImpl implements IReplyService
{
	@Resource
	private IReplyDao replyDaoImpl ; 
	
	@Resource
	private IForumDao forumDaoImpl ; 
	
	@Resource
	private ITopicDao topicDaoimpl ; 

	@Override
	public void add(Reply reply)
	{
		this.replyDaoImpl.add(reply);
		
		//维护相关字段
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();
		
		topic.setReplyCount(topic.getReplyCount() + 1); 
		topic.setLastReply(reply); 
		topic.setLastUpdateTime(reply.getPostTime());
		
		this.topicDaoimpl.update(topic);
		this.forumDaoImpl.update(forum);
		
	}

}
