package com.cjj.oa.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.base.impl.BaseDaoImpl;
import com.cjj.oa.dao.IRoleDao;
import com.cjj.oa.domain.Role;

@Repository
@Transactional
public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao
{

}
