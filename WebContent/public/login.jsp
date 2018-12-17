<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网站管理员登录</title>
<link href="/xyjygl/css/skin.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function reshesh(){
	//使用new Date()参数实现路径更换，预防图片重新加载
	document.getElementById("codeimage").src="/xyjygl/createImage?"+new Date();
}
</script>
</head> 
<body>
	<table cellSpacing="0" cellPadding="0" width="350" border="0"
		align="center">
		<tr>
			<td height="150">&nbsp;</td>
		</tr>

		<tr>
			<td height="164" colspan="2" align="center"><span
				class="logintitle">为学堂学生就业信息管理系统</span>
			<!--  	<form action="/xyjygl/login" method="post" name="form1">-->
			<form action="/xyjygl/checkCode" method="post" name="form1">
					<table cellSpacing=0 cellPadding=0 width=100% border="0" height=143>
						<tr>
							<td width="25%" height="38"><span class="logintxt">用户名:&nbsp;&nbsp;</span>
							</td>
							<td height="38" colspan="2"><input type="text"
								name="username" size="20"></td>
						</tr>



						<tr>
							<td width="25%" height="35"><span class="logintxt">密码：&nbsp;&nbsp;</span>
							</td>
							<td height="35" colspan="2"><input type="password"
								name="password" size="20"> <img
								src="/xyjygl/images/luck.gif" width="19" height="18"></td>
						</tr>

						<tr>
							<td width="25%" height="35"><span class="logintxt">用户身份：</span>
							</td>
							<td height="35" colspan="2"><input type="radio"
								value="student" name="usertypes" checked="checked"> <span
								class="logintxt">学生</span>&nbsp; <input type="radio"
								value="company" name="usertypes"> <span class="logintxt">公司</span>&nbsp;
								<input type="radio" value="admin" name="usertypes"> <span
								class="logintxt">管理员</span></td>
						</tr>

						<tr>
							<td clospan="3">
								<%
									Object obj = request.getAttribute("errorMsg");
									if (obj != null) {
								%> <font color="red" style="font-size: 12px"> <%=String.valueOf(obj)%>
							</font> <%
 	}
 %>

							</td>
						</tr>
						
						<tr>
						<td><span class="logintxt">验证码：</span></td>
						<td colspan="2">
						<input type="text" name="code" size="6"> 
						<img alt="*" src="/xyjygl/createImage" onclick="reshesh()" id="codeimage" title="单击更换图片">
						<span class="errorcode">${codeMsg }</span>
						</td>
						</tr>

						<tr>
							<td height="35"></td>
							<td width="20%" height="35" colspan="1"><span
								style="color: #ff0000;"></span></td>

							<td><a href="/xyjygl/public/register.jsp">新用户注册</a></td>
						</tr>

						<tr>
							<td height="35">&nbsp;</td>
							<td width="20%" height="35"><input type="submit"
								name="Subit" class="btn" value="登录"></td>
							<td width="67%"><input name="cs" type="reset" class="btn"
								value="取消"></td>
						</tr>
					</table>
				</form></td>
		</tr>
	</table>
</body>
</html>