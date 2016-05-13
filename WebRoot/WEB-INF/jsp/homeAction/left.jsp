<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<title>导航菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" src="script/jquery.js"></script>
<script language="JavaScript" src="script/menu.js"></script>
<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
</head>
<body style="margin: 0">
<div id="Menu">
    
            <ul id="MenuUl">
	            <s:iterator value = "#application.topPrivilegeList">
	           
	            	  <s:if test="#session.user.hasPrivilegeById(id)">
		            	  <div onClick="menuClick(this)" class="level1Style"><img src="style/images/MenuIcon/FUNC20001.gif" class="Icon" />${name}</div>
		            	 
		            	 <s:iterator value = "children">
			            	 <s:if test="#session.user.hasPrivilegeById(id)">
				            	 <li class="level2">
				            	 <s:a action = "%{url}" target="right">
			                    	<div class="level2Style"><img src="style/images/MenuIcon/menu_arrow_single.gif" /> ${name}</div>
			               		 </s:a>
			               		 </li>
			               	 </s:if>
		            	 </s:iterator>
	            	
	            	 </s:if>
	            </s:iterator>
	          
            </ul>
        </li>
    </ul>
</div>
</body>
</html>

