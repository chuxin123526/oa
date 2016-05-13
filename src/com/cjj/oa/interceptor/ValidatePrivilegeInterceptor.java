package com.cjj.oa.interceptor;

import java.util.List;

import com.cjj.oa.domain.Privilege;
import com.cjj.oa.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ValidatePrivilegeInterceptor extends AbstractInterceptor
{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		String nameSpace = invocation.getProxy().getNamespace() ;
		String actionName = invocation.getProxy().getActionName() ; 
		
		List<Privilege> privilegeList =
				(List) ActionContext.getContext().getApplication().get("privilegeList") ; 
		boolean flag = false ; 
		for(Privilege privilege : privilegeList)
		{
			if(privilege.getUrl() != null)
			{
				if(privilege.getUrl().equals(actionName))
				{
					flag = true ;
					break ; 
				}
			}
		}
		if(flag == false)
		{
			invocation.invoke() ; 
		}
		else
		{
			User user =(User) ActionContext.getContext().getSession().get("user"); 
			
			if(user == null)
			{
				return "loginUI" ; 
			}

			if(user.hasPrivilegeByUrl(actionName))
			{
				invocation.invoke() ; 
			}
			else
			{
				return "noPrivilege" ; 
			}
			
			
		}
		

		return invocation.invoke() ; 
	}

}
