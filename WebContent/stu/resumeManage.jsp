<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>制作简历</title>
 <script type="text/javascript" src="/xyjygl/js/datepicker.js" ></script>
</head>
<script type="text/javascript">
function isEmail(str){
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(!reg.test(str)){
	alert("邮件格式不正确!");
	return false;
	}
	return true;
	}

</script>
<body>

<form action="/xyjygl/resumeManage" method="post">
				<input type="hidden" name="action" value="add" />
				<input type="hidden" name="sid" value="${student.sid}" />
<h4>简历信息</h4>
<p>（*为必填项)</p>
<table width="100%" border="0">
<tr>
<td width="15%">*姓名:</td>
<td width="35%"><input type="text" name="sname" value="${student.sname }" ></td>
<td width="15%">*性别:</td>
<td width="35%"><input type="text" name="gender" value="${student.gender }"></td>
</tr>

<tr>
<td width="15%">*出生日期:</td>
<td width="35%">
 <input type="text" name="birthdate" style="width: 100px" onfocus="HS_setDate(this)">
</td>

<td width="15%">*民族:</td>
<td width="35%">&nbsp;&nbsp; <select name="nation">
									<option value="00" selected="selected">请选择</option>
									<option value="汉">汉</option>
									<option value="苗">苗</option>
									<option value="藏">藏</option>
									<option value="黎">黎</option>
							</select>
							
</tr>

<tr>
<td width="15%">*政治面貌:</td>
<td width="35%"><input type="text" name="politics"></td>
<td width="15%">*毕业时间:</td>
<td width="35%"> 
<input type="text" name="graduation" style="width: 100px" onfocus="HS_setDate(this)">
</td>
</tr>

<tr>
<td width="15%">*毕业院校:</td>
<td width="35%"><input type="text" name="school" value="${student.school }"></td>
<td width="15%">*所学专业:</td>
<td width="35%"><input type="text" name="major" value="${student.major }"></td>
</tr>

<tr>
<td width="15%">*学历:</td>
<td width="35%"><input type="text" name="education" value="${student.education }"></td>
<td width="15%">*邮箱:</td>
<td width="35%"><input type="text" name="email" id="email" onblur="isEmail()"></td>
</tr>
 

<tr>
<td width="15%">*联系电话:</td>
<td width="35%"><input type="text" name="phone" id="phone"></td>
<td width="15%">*外语水平:</td> 
<td width="35%"><input type="text" name="foreignlanguage" ></td>
</tr>
<tr>
<td>特长爱好</td>
<td><input type="text" style="width: 400px;height: 70px" name="hobby"></td>

</tr>

<tr>
<td>社会实践经历</td>
<td><input type="text" name="practice" style="width: 400px;height: 70px"></td>
</tr>

<tr>
<td>在学校担任职务：</td>
<td><input type="text" name="position" style="width: 400px;height: 70px"></td>
</tr>

<tr>
<td>在校期间获奖：</td>
<td><input type="text" name="honor" style="width: 400px;height: 70px"></td>
</tr>

<tr>
<td>科研成果：</td>
<td><input type="text" name="research" style="width: 400px;height: 70px"></td>
</tr>

<tr>
<td>自我评价：</td>
<td><input type="text" name="selfevaluation" style="width: 400px;height: 70px"></td>
</tr>

<tr>
<td colspan="4"> 
<input type="submit" name="Submit" value="提交">
</td>
</tr>

</table>
</form>
</body>
</html>