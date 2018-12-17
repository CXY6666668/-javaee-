<%@page import="cn.yjpt.dao.service.UserDaoImpl"%>
<%@page import="cn.yjpt.dao.UserDao,cn.yjpt.dao.service.UserDaoImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户名检测</title>
</head>
<body>
<jsp:useBean id="user" class="cn.yjpt.bean.User"></jsp:useBean>
<jsp:setProperty property="username" name="user" param="username"/>
<%
UserDao ud=new UserDaoImpl();
boolean flag=ud.checkUsername(user.getUsername());
//定义用户名有效性uservalid,如果 uservalid 为true，说明用户可以注册
String uservalidate="no";
request.setAttribute("uname", user.getUsername());
if(flag){
	request.setAttribute("usermessage", "用户名已被注册，请重新输入");
}else{
	request.setAttribute("usermessage", "该用户名有效，可以注册");
	uservalidate="ok";
}request.setAttribute("userflag", uservalidate);
%>
<jsp:forward page="register.jsp"></jsp:forward>

</body>
</html>