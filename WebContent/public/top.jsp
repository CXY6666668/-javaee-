<%@page import="cn.yjpt.bean.User"%>
<%@ page language="java" import="java.util.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>top</title>
<style type="text/css">
.tb{
background-image: url("/xyjygl/images/top-right.gif");
background-repeat: repeat-x;
}

.td{
font-size:12px;
color:#ffffff;
height:38px;
line-height:38px;
}

</style>
<script type="text/javascript">
function logout(){
	var flag=window.confirm("确定退出登录");
	if(flag){
		top.location="exit.jsp";
	}
	return false;
}
</script>
</head>
<body>
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="tb">
<tr>
<td width="61%" height="64">
<img alt="logo" src="/xyjygl/images/logo.gif" width="262" height="64">
</td>

<td width="39%" height="64" valign="top">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>

							<!-- 这个单元格用来保存上一个页面的用户名 -->
						<td width="75%" height="38" class="td">
					
						<%
						User u=(User) session.getAttribute("user");
						if(u.getUsertypes().equals("admin")){
							%>
							管理员
							<% 
							
						}if(u.getUsertypes().equals("student")){
							%>
							学生
							<%}
						if(u.getUsertypes().equals("company")){
						%>
						公司
						<%
						}
						
						%>
						<%=u.getUsername() %>
						

						</td>


<td>
<a href="#" target="_self" onClick="logout()">
<img src="/xyjygl/images/out.gif"  width="46" height="20" border="0"> 
</a>
</td>

</tr>
</table>

</td>
</tr>

</table>

</body>
</html>