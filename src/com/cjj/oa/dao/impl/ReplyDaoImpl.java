package com.cjj.oa.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.base.impl.BaseDaoImpl;
import com.cjj.oa.dao.IReplyDao;
import com.cjj.oa.domain.Reply;


@Transactional
@Repository
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements IReplyDao
{

}
