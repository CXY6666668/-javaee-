<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生信息管理</title>
<style type="text/css">
body{
background-color: #e6e6fa;
}

*{
font-size: 12px;
}

</style>
</head>
<body>
<form action="/xyjygl/studentManage" method="post">
<table width="80%" border="1">
<tr bgcolor="#dcdcdc">
<th width="20%" height="30px">姓名</th>
<th width="20%" height="30px">性别</th>
<th width="20%" height="30px">毕业院校</th>
<th width="20%" height="30px">专业</th>
<th width="20%" height="30px">操作</th>
</tr>

<c:forEach var="student" items="${list}"><!--迭代标签  -->
<tr>
<td align="left" height="26px">
<c:out value="${student.sname}"></c:out>
</td>

<td align="left" height="26px">
<c:out value="${student.gender}"></c:out>
</td>

<td align="left" height="26px">
<c:out value="${student.school }"></c:out>
</td>

<td align="left" height="26px">
<c:out value="${student.major}"></c:out>
</td>
<td align="left" height="26px">
<a href="/xyjygl/studentManage?action=show&sid=${student.sid}">查看</a>
<a href="/xyjygl/studentManage?action=delete&sid=${student.sid}">删除</a>
</td>
</tr>
</c:forEach>
</table>
</form>

</body>
</html>