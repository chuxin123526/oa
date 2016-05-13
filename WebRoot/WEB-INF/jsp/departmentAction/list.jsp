<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>部门列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript"></script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 部门管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="150px">部门名称</td>
				<td width="150px">上级部门名称</td>
				<td width="200px">职能说明</td>
				<td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="departmentList">
        <s:iterator value = "#departmentList">
			<tr class="TableDetail1 template">
				<td><s:a action = "departmentAction_list?parentId=%{id}">${name}&nbsp;</s:a></td>
				<td>${parent.name}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td>
			<s:if test="#session.user.hasPrivilegeByUrl('departmentAction_delete')">	
				<s:a action="departmentAction_delete?department.id=%{id}">删除</s:a>
			</s:if>
			<s:if test="#session.user.hasPrivilegeByUrl('departmentAction_updateUI')">
				<s:a action = "departmentAction_updateUI?department.id=%{id}" >修改</s:a>
			</s:if>
			
				</td>
				<%-- 
				<td><a onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" href="#">删除</a>
					<a href="saveUI.html">修改</a>
				</td>
				--%>
			</tr>
		</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        <s:if test="#session.user.hasPrivilegeByUrl('departmentAction_addUI')">
            <a href="departmentAction_addUI.action?parentId=${parentId}"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></a>
        </s:if>
            <a href="departmentAction_list.action?parentId=${departmentList[0].parent.parent.id}" ><label style = "line-height: 28px">返回上一级</label></a>
        	
        </div>
    </div>
</div>

<!--说明-->	
<div id="Description"> 
	说明：<br />
	1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
	2，点击部门名称，可以查看此部门相应的下级部门列表。<br />
	3，删除部门时，同时删除此部门的所有下级部门。
</div>

</body>
</html>

