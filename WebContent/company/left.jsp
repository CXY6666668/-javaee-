<%@ page language="java"  import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>导航菜单</title>
<link rel="stylesheet" type="text/css" href="/xyjygl/css/leftmenu.css"/>
</head>
<body>
<table width="100%" height="319" border="0" cellpadding="0" cellspacing="0" bgcolor="#eef2fb">
<tr>
<td width="182" valign="top">
<div id="container">
<h1 class="type">
<a href="javascript:void(0)">企业管理导航</a></h1>
<div class="container">
<ul class="menuitem">
<li>
<a href="/xyjygl/public/right.jsp" target="right">企业首页</a>
</li>

<li> <a href="/xyjygl/companyManage?action=edit"	target="right">修改资料</a>
</li>

<li>
<a href="/xyjygl/companyManage?action=choose" target="right">发布招聘信息</a>
</li>
 
<li>
<a  href="/xyjygl/recruitManage?action=recruitlist" target="right">管理招聘信息</a>
</li>

<li><a href="/xyjygl/recruitresumeManage?action=list" target="right">查看学生简历</a>
</li>

<li>
<a href="/xyjygl/employmentManage?action=list"  target="right">查看就业信息</a>
</li>

<li><a href="/xyjygl/public/message.jsp" target="right">给管理员留言</a>
</li>

<li>
<a  href="/xyjygl/messageManage?action=list" target="right">查看管理员回复</a>
</li>

<li><a href="/xyjygl/public/updatepassword.jsp" target="right">修改密码</a>
</li>


</ul>
</div>
 </div>

</td>

</tr>
</table>

</body>
</html>