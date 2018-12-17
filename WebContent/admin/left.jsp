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
<a href="javascript:void(0)">管理员管理导航</a></h1>
<div class="container">
<ul class="menuitem">
<li>
<a href="/xyjygl/public/right.jsp" target="main">首页</a>
</li>

<li><a href="/xyjygl/userManage?action=list" target="main">用户管理</a>
</li>

<li>
<a href="/xyjygl/public/register.jsp" target="main">添加学生信息</a>
</li>

<li>
<a href="/xyjygl/studentManage?action=studentlist" target="main">管理学生信息</a>
</li>

<li>
<a href="/xyjygl/public/register.jsp" target="main">添加企业信息</a>
</li>

<li><a href="/xyjygl/companyManage?action=companylist" target="main">管理企业信息</a>
</li>

<li> 
<a  href="/xyjygl/recruitManage?action=recruitlist" target="main">管理招聘信息</a>
</li>

<li><a href="/xyjygl/admin/publishEmployment.jsp" target="main">发布就业信息</a>
</li>

<li> 
<a href="/xyjygl/employmentManage?action=list" target="main">管理就业信息</a>
</li>

<li>
<a href="/xyjygl/messageManage?action=list" target="main">留言管理</a>
</li>
</ul>
</div>
 </div>

</td>

</tr>
</table>

</body>
</html>