package com.cjj.oa.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cjj.oa.dao.IDepartmentDao;
import com.cjj.oa.domain.Department;
import com.cjj.oa.domain.TestUser;

public class Test
{
	@org.junit.Test
	public void test1()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		SessionFactory factory =(SessionFactory) applicationContext.getBean("sessionFactory") ; 
//		Session session = factory.openSession() ; 
//		TestUser testUser = new TestUser() ; 
//		testUser.setName("believe");
//		testUser.setPassword("000000");
//		session.save(testUser) ; 
//		session.save(testUser) ; 
	}
	
	
	@org.junit.Test
	public void test3()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		IDepartmentDao departmentDao = (IDepartmentDao)applicationContext.getBean("departmentDaoImpl") ;
		List<Department> list = departmentDao.childrenList(2) ;
		for(Department department : list)
		{
			System.out.println(department.getName());
		}
	}
}
