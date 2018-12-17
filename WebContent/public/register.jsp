<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户注册页面</title>
<style type="text/css">
body {
	background-color: #EDEDED;
}

table{
margin:30px; auto;
}


.regtitle {
	font-family: 楷体_gb2312;
	font-size: 16px;
	line-height: 40px;
	color: #333333;
}

.regtxtbt {
	font-family: 楷体, Arail;
	font-size: 16px;
	color: #000000;
	height: 38px;
	line-height: 38px;
}

.regtxt {
	font-family: 宋体，Arial;
	font-size: 12px;
	color: #000000;
	line-height: 25px;
	text-right: right
}

#usernamemessage {
	font-size: 12px;
	line-height: 25px;
	color: #FF0000;
}

#pwdmessage {
	font-size: 12px;
	line-height: 25px;
	color: #ff0000;
}
#password{
font-size: 12px;
line-height: 25px;
color:#ff0000;
}
</style>
<script type="text/javascript">
	function checkUser() {
		var name = document.form1.username.value;
		var flag=document.form1.uflag.value;
		if ((name == null) || (name.length == 0)) {
			document.getElementById("usernamemessage").innerHTML = "用户名不能为空";
			return false;
		} else if(flag=="no"){
			document.forms["form1"].method="post";
			document.forms["form1"].username.value=name;
			document.forms["form1"].action="checkUser.jsp";
			document.forms["form1"].submit();
			
		}   
		else { 
			return true;
		}
	}
	function checkPassword() {
		var password = document.form1.password.value;
		if ((password == null) || (password.length == 0)) {
			document.getElementById("pwdmessage").innerHTML = "密码不能为空";
			return false;
		} else {
			return true;
		}
	}
	function submitForm() {
		return (checkUser()) && (checkPassword());
	}
</script>
</head>
<body>
	<form name="form1" action="/xyjygl/doregister" method="post"
		onSubmit="return submitForm();">
		<table width="500" class="ta" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr height="40" valign="top">
				<td></td>
				<td><span class="logintitle">为学堂学生管理系统</span></td>
			</tr>
			<td width="20%" height="38" align="right">
			<span class="regtxt">用户名：</span>
			</td>

 <td colspan="1">
 <%
         String flag="no";
         Object uflag=request.getAttribute("userflag");
         if(uflag!=null){
        	 flag=String.valueOf(uflag);
         }
         %><input type="hidden" name="uflag" value="<%=flag %>"> 
         <%
         String uname="";
         Object username=request.getAttribute("uname");
         if(username!=null){
        	 uname=String.valueOf(username);
         }
         %><input type="text"  name="username" size="20" value="<%=uname %>" onblur="checkUser()">
         <%
         Object msgObj=request.getAttribute("usermessage");
         String msg="";
         if(msgObj!=null){
        	 msg=String.valueOf(msgObj);
         }
         %> <span id="usernamemessage"><%=msg%></span>
 
 </td>
			</tr>

			<tr>
				<td width="20%" height="38" align="right"><span class="regtxt">密碼</span>
				</td>
				<td colspan="2"><input type="password" name="password" 	size="20" onblur="checkPassword();"> 
				<img alt="1" src="/xyjygl/images/luck.gif" width="18" height="19">
				 <span id="pwdmessage"></span>
					 </td>
			</tr>

			<tr>
				<td width="20%" height="38" align="right"><span class="regtxt">用戶身份</span>
				</td>
				<td colspan="2"><input type="radio" name="usertypes" value="student">
				 <span class="regtxt">學生</span>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="usertypes" value="admin"> 
					<span class="regtxt">管理員</span>&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="radio" name="usertypes" value="company">
					 <span class="regtxt">企業</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<td width="20%" height="38">&nbsp;</td>
			<td colspan="2">
			<input type="submit" value="註冊">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="取消"></td>
			</tr>

		</table>
	</form>
</body>
</html>
