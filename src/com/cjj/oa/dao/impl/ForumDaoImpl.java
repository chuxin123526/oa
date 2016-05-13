package com.cjj.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.base.impl.BaseDaoImpl;
import com.cjj.oa.dao.IForumDao;
import com.cjj.oa.domain.Forum;

@Transactional
@Repository
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements IForumDao
{

	@Override
	public List<Forum> findAll()
	{
		String hql = "from Forum f order by f.position" ; 
		return this.sessionFactory.getCurrentSession().createQuery(hql).list() ; 
	}
	
	@Override
	public void add(Forum forum)
	{
		this.sessionFactory.getCurrentSession().save(forum) ; 
		forum.setPosition(forum.getId());
	}
	
	@Override
	public void moveUp(int id)
	{
		Forum forum = this.getById(id) ; 
		Forum upForum =(Forum) this.sessionFactory.getCurrentSession().
				createQuery("from Forum f where f.position<? order by f.position desc").
			setParameter(0, forum.getPosition()).setFirstResult(0).setMaxResults(1).uniqueResult() ; 
		
		
		
		if(upForum == null)
		{
			return ; 
		}
		
		int tempPosition = forum.getPosition() ; 
		forum.setPosition(upForum.getPosition());
		upForum.setPosition(tempPosition);
		
	}
	
	@Override
	public void moveDown(int id)
	{
		Forum forum = this.getById(id) ; 
		Forum downForum =(Forum) this.sessionFactory.getCurrentSession().
				createQuery("from Forum f where f.position>? order by f.position").
			setParameter(0, forum.getPosition()).setFirstResult(0).setMaxResults(1).uniqueResult() ; 
		
		
		
		if(downForum == null)
		{
			return ; 
		}
		
		int tempPosition = forum.getPosition() ; 
		forum.setPosition(downForum.getPosition());
		downForum.setPosition(tempPosition);
	}

}
