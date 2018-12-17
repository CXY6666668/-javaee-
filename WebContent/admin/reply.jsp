<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>留言管理</title>
<script type="text/javascript" src="/xyjygl/ckeditor/ckeditor.js"></script>
</head>
<body>
<form action="/xyjygl/messageManage" method="post">
<input type="hidden" name="action" value="addreply">
<input type="hidden" name="mid" value="${message.mid }">
<table width="66%" border="0" cellpadding="0" cellspacing="0">
<tr>
<td width="20%">
<strong>留言用户:</strong>
</td>
<td width="80%"><c:out value="${message.username }"></c:out>
</td>
</tr>

<tr>
<td width="20%">
<strong>留言标题:</strong>
</td>
<td width="80%"><c:out value="${message.title }"></c:out>
</td>
</tr>

<tr>
<td width="20%">
<strong>留言内容:</strong>
</td>
<td width="80%"><c:out value="${message.content }" escapeXml="false"/>
</td>
</tr>

 <tr>
                  <td><strong>留言回复：</strong></td>
                  <td>
                      <textarea rows="10" cols="80" name="reply" id="reply"></textarea> 
                      <ck:replace replace="reply" basePath=""></ck:replace>                     
                  </td>
              </tr>
              
              <tr>
                 <td colspan="2" align="center">
                    <input type="submit" value="提交回复">
                 </td>
              </tr>
</table> 
</form>
</body>
</html>