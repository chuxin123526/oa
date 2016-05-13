package com.cjj.oa.domain;

import java.util.HashSet;
import java.util.Set;

public class Privilege
{
	private int id ; 
	private String name ; 
	private String icon ;
	private String url ; 
	
	private Privilege parent ;
	private Set<Privilege> children = new HashSet<Privilege>() ;
	private Set<Role> roles = new HashSet<Role>() ;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getIcon()
	{
		return icon;
	}
	public void setIcon(String icon)
	{
		this.icon = icon;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public Privilege getParent()
	{
		return parent;
	}
	public void setParent(Privilege parent)
	{
		this.parent = parent;
	}
	public Set<Privilege> getChildren()
	{
		return children;
	}
	public void setChildren(Set<Privilege> chilren)
	{
		this.children = chilren;
	}
	public Set<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}
	
	
}
