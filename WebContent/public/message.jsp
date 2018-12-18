<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ck" uri="http://ckeditor.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>給管理員留言</title>
<style type="text/css">
td{ 
font-size: 12px; 
} 
</style>
<script type="text/javascript"src="/xyjygl/ckeditor/ckeditor.js"></script>
</head>
<body bgcolor="eff2fb">
<c:set var="u" value="${user }"></c:set>
<form action="/xyjygl/messageManage" method="post">
<input type="hidden" name="action" value="add">
<input type="hidden" name="id" value="${u.id }">
<input type="hidden" name="username" value="${u.username }"/>
<table width="66%" border="0" cellpadding="0" cellspacing="0">
<tr>
<td width="20%">留言標題</td>
<td width="80%">
<input type="text" name="title" size="50">
</td>
</tr>
 
<tr>
<td>留言内容</td>
<td>
<textarea rows="10" cols="80" name="content" id="content"></textarea>
<ck:replace replace="content" basePath=""></ck:replace>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="提交留言">
</td>
</tr>
</table>

</form>

</body>
</html>