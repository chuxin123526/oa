package com.cjj.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.dao.IForumDao;
import com.cjj.oa.domain.Forum;
import com.cjj.oa.service.IForumService;

@Transactional
@Service
public class ForumServiceImpl implements IForumService
{
	@Resource
	private IForumDao forumDaoImpl ; 

	@Override
	public List<Forum> list()
	{
		return this.forumDaoImpl.findAll() ; 
	}

	@Override
	public void add(Forum forum)
	{
		this.forumDaoImpl.add(forum);
	}

	@Override
	public void delete(int id)
	{
		this.forumDaoImpl.deleteByid(id);
	}

	@Override
	public void update(Forum forum)
	{
		this.forumDaoImpl.update(forum);
	}

	@Override
	public Forum getById(int id)
	{
		return this.forumDaoImpl.getById(id) ;
	}

	@Override
	public void moveUp(int id)
	{
		this.forumDaoImpl.moveUp(id); 
	}

	@Override
	public void moveDown(int id)
	{
		this.forumDaoImpl.moveDown(id);
	}
	
}
