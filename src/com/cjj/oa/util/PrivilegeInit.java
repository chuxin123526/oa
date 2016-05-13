package com.cjj.oa.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cjj.oa.domain.Privilege;
import com.cjj.oa.domain.User;
import com.sun.mail.smtp.DigestMD5;

@Component
@Transactional
public class PrivilegeInit
{
	@Resource
	private SessionFactory sessionFactory ; 
	
	public static void main(String[] args)
	{
		ApplicationContext applicationContext =			
				new ClassPathXmlApplicationContext("applicationContext.xml") ; 
		PrivilegeInit privilegeInit =(PrivilegeInit) applicationContext.getBean("privilegeInit") ; 
		privilegeInit.init();
	}
	
	public void init()
	{	
		Session session = sessionFactory.openSession(); 
		
		Privilege communicationPrivilege = new Privilege() ; 
		communicationPrivilege.setName("网上交流");
		session.save(communicationPrivilege) ; 
		
		Privilege forumManagementPrivilege = new Privilege() ;
		forumManagementPrivilege.setName("论坛管理");
		forumManagementPrivilege.setUrl("forumManagementAction_list");
		forumManagementPrivilege.setParent(communicationPrivilege);
		session.save(forumManagementPrivilege) ;
		
		Privilege forumPrivilege = new Privilege() ; 
		forumPrivilege.setName("论坛");
		forumPrivilege.setUrl("forumAction_list");
		forumPrivilege.setParent(communicationPrivilege);
		session.save(forumPrivilege) ; 

		
		
		Privilege systemPrivilege = new Privilege() ; 
		systemPrivilege.setName("系统管理");
		session.save(systemPrivilege) ; 
		
		Privilege departmentPrivilege = new Privilege() ; 
		departmentPrivilege.setName("部门管理");
		departmentPrivilege.setParent(systemPrivilege);
		departmentPrivilege.setUrl("departmentAction_list");;
		Privilege userPrivilege = new Privilege() ; 
		userPrivilege.setName("用户管理") ; 
		userPrivilege.setParent(systemPrivilege);
		userPrivilege.setUrl("userAction_list");;
		Privilege rolePrivilege = new Privilege() ; 
		rolePrivilege.setName("岗位管理") ; 
		rolePrivilege.setUrl("roleAction_list");; 
		rolePrivilege.setParent(systemPrivilege);
		
		session.save(departmentPrivilege) ; 
		session.save(userPrivilege) ; 
		session.save(rolePrivilege) ; 
		
		
		Privilege departmentDeletePrivilege = new Privilege() ; 
				  departmentDeletePrivilege.setName("删除部门");
				  departmentDeletePrivilege.setUrl("departmentAction_delete");
				  departmentDeletePrivilege.setParent(departmentPrivilege);
		Privilege departmentAddpPrivilege = new Privilege() ; 
				  departmentAddpPrivilege.setName("增加部门");
				  departmentAddpPrivilege.setUrl("departmentAction_addUI");
				  departmentAddpPrivilege.setParent(departmentPrivilege);
		Privilege departmentUpdatepPrivilege = new Privilege() ; 
				  departmentUpdatepPrivilege.setName("更改部门");
				  departmentUpdatepPrivilege.setUrl("departmentAction_updateUI");
				  departmentUpdatepPrivilege.setParent(departmentPrivilege);
		Privilege departmentqueryPrivilege = new Privilege() ; 
				  departmentqueryPrivilege.setName("查看部门");
				  departmentqueryPrivilege.setUrl("departmentAction_list");
				  departmentqueryPrivilege.setParent(departmentPrivilege);
		
				  session.save(departmentqueryPrivilege) ;
				  session.save(departmentAddpPrivilege) ; 
				  session.save(departmentDeletePrivilege) ; 
				  session.save(departmentUpdatepPrivilege) ;
				  
				  
				  
				  
		Privilege departmentDeletePrivilege1 = new Privilege() ; 
				  departmentDeletePrivilege1.setName("删除用户");
				  departmentDeletePrivilege1.setUrl("userAction_delete");;
				  departmentDeletePrivilege1.setParent(userPrivilege);
		Privilege departmentAddpPrivilege2 = new Privilege() ; 
				  departmentAddpPrivilege2.setName("增加用户");
				  departmentAddpPrivilege2.setUrl("userAction_addUI");
				  departmentAddpPrivilege2.setParent(userPrivilege);
		Privilege departmentUpdatepPrivilege3 = new Privilege() ; 
				  departmentUpdatepPrivilege3.setName("更改用户");
				  departmentUpdatepPrivilege3.setUrl("userAction_updateUI");
				  departmentUpdatepPrivilege3.setParent(userPrivilege);
		Privilege departmentqueryPrivilege4 = new Privilege() ; 
				  departmentqueryPrivilege4.setName("查看用户");
				  departmentqueryPrivilege4.setUrl("userAction_list");
				  departmentqueryPrivilege4.setParent(userPrivilege);
		
				  session.save(departmentqueryPrivilege4) ;
				  session.save(departmentAddpPrivilege2) ; 
				  session.save(departmentDeletePrivilege1) ; 
				  session.save(departmentUpdatepPrivilege3) ;
	
				  
				  
	    Privilege departmentDeletePrivilege11 = new Privilege() ; 
				  departmentDeletePrivilege11.setName("删除岗位");
				  departmentDeletePrivilege11.setUrl("roleAction_delete");;
				  departmentDeletePrivilege11.setParent(rolePrivilege);
		Privilege departmentAddpPrivilege22 = new Privilege() ; 
				  departmentAddpPrivilege22.setName("增加岗位");
				  departmentAddpPrivilege22.setUrl("roleAction_add");;
				  departmentAddpPrivilege22.setParent(rolePrivilege);
		Privilege departmentUpdatepPrivilege33 = new Privilege() ; 
				  departmentUpdatepPrivilege33.setName("更改岗位");
				  departmentUpdatepPrivilege33.setUrl("roleAction_updateUI");;
				  departmentUpdatepPrivilege33.setParent(rolePrivilege);
		Privilege departmentqueryPrivilege44 = new Privilege() ; 
				  departmentqueryPrivilege44.setName("查询岗位");
				  departmentqueryPrivilege44.setUrl("roleAction_list");;
				  departmentqueryPrivilege44.setParent(rolePrivilege);
		
				  session.save(departmentqueryPrivilege44) ;
				  session.save(departmentAddpPrivilege22) ; 
				  session.save(departmentDeletePrivilege11) ; 
				  session.save(departmentUpdatepPrivilege33) ;
				  
				  
				  
				  
				  
				  
				  
				  User admin= new User() ; 
				  admin.setLoginName("admin");
				  admin.setPassword(DigestUtils.md5Hex("000000"));
				  session.save(admin) ; 
				  
	}
}
