package com.cjj.oa.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.base.impl.BaseDaoImpl;
import com.cjj.oa.dao.ITopicDao;
import com.cjj.oa.domain.Topic;

@Repository
@Transactional
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements ITopicDao
{

}
