<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>修改用户密码</title> 
  </head>
  <script type="text/javascript">
	function check() {	
	    if (document.getElementById("password").value==""){
	        alert("请输入密码");
             window.event.returnValue = false;
	  }	else{	   
	   window.event.returnValue = true;}
	}
</script>
  <body>  
  <form method="post" action="/xyjygl/userManage" onsubmit="check()">
    <INPUT type="hidden" value="update" name="action"/>
    <INPUT type="hidden" value="${param.id}" name="id"/>
    <table border="1" width="314" height="141" border="0" frame="void" rules="none">       
       <tr>          
          <td>&nbsp;新密码：</td>
          <td>&nbsp;<input type="password" name="password" id="password">
          </td>
       </tr>
       <tr>
         <td colspan="2" align="center">
            <input type="submit" value="提交" name="button1">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="重置" name="button2">
         </td>
       </tr>
    </table>
   </form>
  </body>
</html>
