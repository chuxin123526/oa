package com.cjj.oa.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cjj.oa.domain.Privilege;
import com.cjj.oa.service.IPrivilegeService;
import com.cjj.oa.service.impl.PrivilegeServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class InitPrivilegeListener implements ServletContextListener
{

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent application)
	{
		ApplicationContext applicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(application.getServletContext()) ; 
		IPrivilegeService privilegeServiceImpl =(IPrivilegeService) applicationContext.getBean("privilegeServiceImpl") ; 
	
		//准备所有顶级权限的集合
		List<Privilege> topPrivilegeList = privilegeServiceImpl.topList() ; 
		application.getServletContext().setAttribute("topPrivilegeList", topPrivilegeList);
		
		//准备所有权限
		List<Privilege> privilegeList = privilegeServiceImpl.list() ; 
		application.getServletContext().setAttribute("privilegeList", privilegeList);
	}

}
