<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生个人基本信息</title>
<link href="/xyjygl/css/stucss.css" rel="stylesheet" type="text/css">
</head>
<body>
<table class="regtable" width="500" align="center" border="0" cellpadding="0" cellspacing="1">
<caption class="txt">学生个人基本信息</caption>
<tr>
<td></td>
</tr>

<tr>
<td valign="top" width="500" bgcolor="#f9f9f9" height="350">
<table width="500" align="center" border="0" cellpadding="0" cellspacing="0">
<tr>
<td colspan="2" class="tdinfo" height="25">
<span style="font-weight: bold;">学生基本信息</span>
</td>
<td colspan="2"></td>
</tr>

<tr>
<td align="right" height="30" width="130">姓名：</td>
<td width="370" align="left">
<input type="text" name="sname" value="${student.sname}"size="30"/> 
</td>
</tr>

<tr>
<td align="right" height="30">性别：</td>
<td width="370">
<input type="text" name="gender" value="${student.gender }" size="20"/>
</td>
</tr>

<tr>
<td align="right" height="30">身份证号码：</td>
<td width="370">
<input type="text" name="idnumber" value="${student.idnumber}"size="50"/>
</td>
</tr>

<tr>
<td align="right" height="30">学校：</td>
<td>
<input type="text" name="school" value="${student.school }" size="50"/>
</td>
</tr>

<tr>
<td align="right" height="30">院系：</td>
<td>
<input type="text" name="department" value="${student.department }" size="50"/>
</td>
</tr>

<tr>
<td align="right" height="30">专业：</td>
<td>
<input type="text" name="major" value="${student.major }" size="50"/>
</td>
</tr>

<tr>
<td align="right" height="30">学历：</td>
<td>
<input type="text" name="education" value="${student.education }" size="20"/>
</td>
</tr>


<tr>
<td align="right" height="30">入学时间：</td>
<td>
<input type="text" name="entrancedate" value="${student.entrancedate }" size="50"/>
</td>
</tr>

<tr>
<td align="right" height="30">籍贯：</td>
<td>
<input type="text" name="nativeplace" value="${student.nativeplace }" size="50"/>
</td>
</tr>

<tr>
<td colspan="2">
</td>
</tr>

</table>
</td>
</tr>

</table>

</body>
</html>