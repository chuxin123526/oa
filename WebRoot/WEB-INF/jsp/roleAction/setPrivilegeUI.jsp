<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>配置权限</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" src="<%=basePath%>script/jquery.js"></script>
<script language="javascript" src="<%=basePath%>script/pageCommon.js"
	charset="utf-8"></script>
<script language="javascript" src="<%=basePath%>script/PageUtils.js"
	charset="utf-8"></script>
<script language="javascript" src="<%=basePath%>script/DemoData.js"
	charset="utf-8"></script>
<script language="javascript"
	src="<%=basePath%>script/DataShowManager.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>style/blue/pageCommon.css" />
<script language="javascript"
	src="<%=basePath%>script/jquery_treeview/jquery.treeview.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>style/blue/file.css" />
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>script/jquery_treeview/jquery.treeview.css" />

<script type="text/javascript">
	$(function() {

		$("[name=privilegeIds]").click(
				function() {

					$(this).siblings("ul").find("input").attr("checked",
							this.checked);

					if (this.checked) {
						$(this).parents("li").children("input").attr("checked",
								true);
					} else {
						if ($(this).parent().siblings("li").children(
								"input:checked").size() == 0) {
							$(this).parent().parent().siblings("input").attr(
									"checked", false);
							var start = $(this).parent().parent();
							if (start.parent().siblings("li").children(
									"input:checked").size() == 0) {
								start.parent().parent().siblings("input").attr(
										"checked", false);
							}
						}
					}
				});

	});
</script>

</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="<%=basePath%>style/images/title_arrow.gif" /> 配置权限
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>
		<form action="roleAction_setPrivilege.action">
		<s:hidden name = "role.id"></s:hidden>
			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="<%=basePath%>style/blue/images/item_point.gif" />
					正在为【部门经理】配置权限
				</div>
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<!--表头-->
						<thead>
							<tr align="LEFT" valign="MIDDLE" id="TableTitle">
								<td width="300px" style="padding-left: 7px;">
									<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
									<input type="CHECKBOX" id="cbSelectAll"
									onClick="selectAll(this.checked)" /> <label for="cbSelectAll">全选</label>
								</td>
							</tr>
						</thead>

						<!--显示数据列表-->
						<tbody id="TableData">
							<tr class="TableDetail1">
								<!-- 显示权限树 -->
								<td>

									<ul id=privilegeTree>
										<s:iterator value="#topPrivilegeList">
											<li><input type="checkbox" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>
												name="privilegeIds"> <label for="cb_${id}"><span
													class="folder">${name}</span></label>
												<ul>
													<s:iterator value="%{children}">

														<li><input type="checkbox" value="${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>
															name="privilegeIds" id="cb_${id}"> <label
															for="cb_${id}"><span class="folder">${name}</span></label>
															<ul>
																<s:iterator value="%{children}">

																	<li><input type="checkbox" value="${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>
																		name="privilegeIds" id="cb_${id}" /> <label
																		for="cb_${id}"> <span class="folder">${name}</span></label>
																	</li>

																</s:iterator>
															</ul></li>

													</s:iterator>
												</ul></li>
										</s:iterator>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<script type="text/javascript">
				$(function() {
					$("#privilegeTree").treeview();
				});
			</script>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image" src="<%=basePath%>style/images/save.png" /> <a
					href="javascript:history.go(-1);"><img
					src="<%=basePath%>style/images/goBack.png" /></a>
			</div>
		</form>
	</div>

	<div class="Description">
		说明：<br /> 1，选中一个权限时：<br /> &nbsp;&nbsp;&nbsp;&nbsp; a，应该选中 他的所有直系上级。<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br /> 2，取消选择一个权限时：<br />
		&nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择 他的所有直系下级。<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并递归向上做这个操作。<br />

		3，全选/取消全选。<br /> 4，默认选中当前岗位已有的权限。<br />
	</div>

</body>
</html>

