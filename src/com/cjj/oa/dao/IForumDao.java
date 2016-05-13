package com.cjj.oa.dao;

import com.cjj.oa.base.IBaseDao;
import com.cjj.oa.domain.Forum;

public interface IForumDao extends IBaseDao<Forum>
{
	public void moveUp(int id) ;
	public void moveDown(int id) ;
}
