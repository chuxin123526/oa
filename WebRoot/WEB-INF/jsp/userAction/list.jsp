<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户列表</title>
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        <s:iterator value = "#userList">
            <tr class="TableDetail1 template">
                <td>${loginName}&nbsp;</td>
                <td>${name}&nbsp;</td>
                <td>${department.name}&nbsp;</td>
                <td><s:iterator value = "roles">${name}&nbsp;&nbsp;</s:iterator></td>
                <td>${description}&nbsp;</td>
                <td>
               <s:if test="#session.user.hasPrivilegeByUrl('userAction_delete')">
               		<a onClick="return delConfirm()" href="userAction_delete.action?user.id=${id}">删除</a>
                   </s:if>
                    <s:if test="#session.user.hasPrivilegeByUrl('userAction_updateUI')">
                   	    <a href="userAction_updateUI.action?user.id=${id}">修改</a>
					</s:if>
					 <s:if test="#session.user.hasPrivilegeByUrl('userAction_initPassword')">
						<a href="userAction_initPassword.action?user.id=${id}" onClick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</a>
               		</s:if>
                </td>
            </tr>
            </s:iterator>
            
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
         <s:if test="#session.user.hasPrivilegeByUrl('userAction_addUI')">
            <a href="userAction_addUI.action"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></a>
        </s:if>
        </div>
    </div>
</div>

</body>
</html>

