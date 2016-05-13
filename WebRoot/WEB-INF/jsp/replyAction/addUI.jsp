<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<title>帖子回复</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="<%=basePath %>script/jquery.js"></script>
    <script language="javascript" src="<%=basePath %>script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="<%=basePath %>script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="<%=basePath %>script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="<%=basePath %>script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="<%=basePath %>style/blue/pageCommon.css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath %>style/blue/forum.css" />

	<script language="javascript" src="<%=basePath %>script/fckeditor/fckeditor.js" charset="utf-8"></script>
    <script type="text/javascript">
		$(function(){
			var fck = new FCKeditor("reply.content");
			fck.Width = "99%";
			fck.Height = "100%";
			fck.ToolbarSet = "bbs";
			fck.BasePath = "<%=basePath %>script/fckeditor/";
			//fck.Config['SkinPath'] = "<%=basePath %>scriipt/fckeditoreditor/skins/office2003/";
			//fck.Config['SkinPath'] = "http://bbs.itcast.cn:80/widgets/fckeditor/editor/skins/office2003/";
			fck.ReplaceTextarea();
		});
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="<%=basePath %>style/images/title_arrow.gif"/> 帖子回复
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
<form action="replyAction_add.action" style="margin: 0; padding: 0;">
	<s:hidden name = "topic.id"></s:hidden>
	
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1">
			<div width=85% style="float:left">
				<font class="MenuPoint"> &gt; </font>
				<a href="forumAction_list.action">论坛</a>
				<font class="MenuPoint"> &gt; </font>
				<a href="forumAction_show.action?forum.id=${topic.forum.id}">${topic.forum.name}</a>
				<font class="MenuPoint"> &gt;&gt; </font>
				帖子回复
			</div>
		</div>
		<div class="ItemBlockBorder">
			<table border="0" cellspacing="1" cellpadding="1" width="100%" id="InputArea">
				<tr>
					<td class="InputAreaBg" height="30"><div class="InputTitle">帖子主题</div></td>
					<td class="InputAreaBg"><div class="InputContent">${topic.title}</div></td>
				</tr>
				<tr>
					<td class="InputAreaBg" height="30"><div class="InputTitle">标题</div></td>
					<td class="InputAreaBg"><div class="InputContent">
						<input type="text" name="reply.title" class="InputStyle" style="width:100%" /></div>
					</td>
				</tr>
				<tr>
					<td class="InputAreaBg" height="30"><div class="InputTitle">表情</div></td>
					<td class="InputAreaBg"><div class="InputContent">
						<!-- 显示表情符号 -->
						<!--现在在设计单选框(radio)和复选框(checkbox)时都会给选择文字加上label增大选择范围，以提高用户体验。
							但在给单独的图片加label时无法成功。
							解决方法是：给图片img标签加上disabled即可。-->
						<table cellpadding="0" border="0" cellspacing="0">
							<tr>
								
							</tr>
						</table></div>
					</td>
				</tr>
				<tr height="240">
					<td class="InputAreaBg"><div class="InputTitle">内容</div></td>
					<td class="InputAreaBg"><div class="InputContent"><textarea name="reply.content"></textarea></div></td>
				</tr>
				<tr height="30">
					<td class="InputAreaBg" colspan="2" align="center">
						<input type="image" src="<%=basePath %>style/blue/images/button/submit.PNG" style="margin-right:15px;"/>
						<a href="javascript:history.go(-1);"><img src="<%=basePath %>style/blue/images/button/goBack.png"/></a>
					</td>
				</tr>
			</table>
		</div>
	</center>
</form>
</div>

<div class="Description">
	说明：<br />
	
</div>

</body>
</html>

