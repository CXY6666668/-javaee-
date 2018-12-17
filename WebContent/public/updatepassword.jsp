<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改密码</title>
<style type="text/css">
body {
	font-size: 12px;
}

.tb {
	width: 350px;
	height: 161px;
	margin-left: 50px;
	margin-top: 50px;
	border-style: 1px solid #99CCFF;
}
</style>
<script type="text/javascript">
	function check() {
		var oldpwd = document.getElementById("old").value;
		var hidpwd = document.getElementById("hidold").value;
		var newpwd = document.getElementById("password").value;
		if (oldpwd != hidpwd) {
			alert("旧密码不正确，请重新输入");
			return false;
		} else if ((newpwd == "") || (newpwd.length == 0)) {
			alert("请输入密码");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body bgcolor="eff2fb">
	<form method="post" action="/xyjygl/userManage"
		onsubmit="return check()">
		<table class="tb">
			<tr> 
				<td>&nbsp;用户名：</td>
				<td>&nbsp;<c:out value="${user.username }"></c:out></td>
			</tr>
			<tr>
				<td>&nbsp;旧密码：</td>
				<td>&nbsp; <input type="hidden" name="hidold" value="${user.password }" id="hidold">
				<input type="hidden" name="id" value="${user.id }" id="id"> 
					<input type="password" name="old" id="old">
				</td>
			</tr>
			<tr>
				<td>&nbsp;新密码：</td>
				<td>&nbsp;
					<input type="password" name="password" id="password">
                     <input type="hidden" name="action" value="update">
                 </td>
               </tr>
                <tr >
                  <td colspan="2" align="center">
                    &nbsp;<input type="submit" value="修改" >
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" >
                  </td>
                </tr>                    
             </table>
        </form>
  </body>
</html>
