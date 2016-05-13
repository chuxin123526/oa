package com.cjj.oa.service;

import java.util.List;

import com.cjj.oa.domain.Forum;

public interface IForumService
{
	public List<Forum> list() ; 
	public void add(Forum forum) ; 
	public void delete(int id ) ; 
	public void update(Forum forum) ;
	public Forum getById(int id) ;
	public void moveUp(int id) ; 
	public void moveDown(int id) ;
}
