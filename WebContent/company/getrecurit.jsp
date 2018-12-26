<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>看投简历情况</title>
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
<form action="/xyjygl/recruitresumeManage" method="post">
<table width="80%" border="1">
<tr bgcolor="#dcdcdc">
<th width="20%" height="30px">招聘部门</th>
              <th width="20%" height="30px">招聘人数</th>
              <th width="20%" height="30px">职位性质</th>              
              <th width="20%" height="30px">工作地点</th>
              <th width="20%" height="30px">操作</th>  
</tr>

<c:forEach var="recurit" items="${recuritlist}"><!--迭代标签  -->
<tr>
<td align="left" height="26px">
<c:out value="${recurit.branch}"></c:out>
</td>

<td align="left" height="26px">
<c:out value="${recurit.recruitment}"></c:out>
</td>

<td align="left" height="26px">
<c:out value="${recurit.positiontype }"></c:out>
</td>

<td align="left" height="26px">
<c:out value="${recurit.workingplace}"></c:out>
</td>
<td align="left" height="26px">
  <a href="/xyjygl/recruitresumeManage?action=showresumes&rid=${recurit.rid}">查看</a> 
</td>
</tr>
</c:forEach>
</table>
</form>
 

</body>
</html>