package com.cjj.oa.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cjj.oa.domain.Role;
import com.cjj.oa.service.IRoleService;

public class TestRole
{
	
	@Test
	public void testAdd()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ; 
		IRoleService roleServiceImpl =(IRoleService) applicationContext.getBean("roleServiceImpl") ; 
		
//		for(int i = 0 ; i < 10 ; i++)
//		{
			Role role = new Role() ; 
			role.setName("technology");
			roleServiceImpl.add(role);
//		}
	
	}
	
	@Test
	public void testDelete()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ; 
		IRoleService roleService=(IRoleService) applicationContext.getBean("roleServiceImpl") ; 
		roleService.delete(2);
	}
	
	@Test
	public void testList()
	{

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ; 
		IRoleService roleService=(IRoleService) applicationContext.getBean("roleServiceImpl") ; 
		List<Role> list = roleService.list() ; 
		
		for(Role role : list)
		{
			System.out.println(role.getId());
		}
	}
	
	@Test
	public void testUpdate()
	{

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ; 
		IRoleService roleService=(IRoleService) applicationContext.getBean("roleServiceImpl") ; 
		Role role = new Role() ; 
		role.setId(4) ; 
		role.setName("economy");
		roleService.update(role);
	}
}
