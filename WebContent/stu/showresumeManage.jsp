<%@ page language="java"  import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>查看简历</title>
</head>
<body>
<form action="/xyjygl/resumeManage" method="post">
				<input type="hidden" name="action" value="show" />
				<input type="hidden" name="sid" value="${resume.sid}" />
<h4>简历信息</h4>
<p>（*为必填项)</p>
<table width="100%" border="0">
<tr>
<td width="15%">*姓名:</td>
<td width="35%"><input type="text" name="sname" value="${resume.sname }" ></td>
<td width="15%">*性别:</td>
<td width="35%"><input type="text" name="gender" value="${resume.gender }"></td>
</tr>

<tr>
<td width="15%">*出生日期:</td>
<td width="35%">
 <input type="text" name="birthdate" style="width: 100px" value="${resume.birthdate }">
</td>

<td width="15%">*民族:</td>
<td width="35%">&nbsp;&nbsp; <input type="text" name="nation" value="${resume.nation }"></td>
							
</tr>

<tr>
<td width="15%">*政治面貌:</td>
<td width="35%"><input type="text" name="politics" value="${resume.politics }"></td>
<td width="15%">*毕业时间:</td>
<td width="35%"> 
<input type="text" name="graduation" style="width: 100px" value="${resume.graduation }">
</td>
</tr>

<tr>
<td width="15%">*毕业院校:</td>
<td width="35%"><input type="text" name="school" value="${resume.school }"></td>
<td width="15%">*所学专业:</td>
<td width="35%"><input type="text" name="major" value="${resume.major }"></td>
</tr>

<tr>
<td width="15%">*学历:</td>
<td width="35%"><input type="text" name="education" value="${resume.education }"></td>
<td width="15%">*邮箱:</td>
<td width="35%"><input type="text" name="email" id="email" value="${resume.email }"></td>
</tr>
 

<tr>
<td width="15%">*联系电话:</td>
<td width="35%"><input type="text" name="phone" id="phone" value="${resume.phone }"></td>
<td width="15%">*外语水平:</td> 
<td width="35%"><input type="text" name="foreignlanguage" value="${resume.foreignlanguage }"></td>
</tr>
<tr>
<td>特长爱好</td>
<td><input type="text" style="width: 400px;height: 70px" name="hobby" value="${resume.hobby }"></td>

</tr>

<tr>
<td>社会实践经历</td>
<td><input type="text" name="practice" style="width: 400px;height: 70px" value="${resume.practice }"></td>
</tr>

<tr>
<td>在学校担任职务：</td>
<td><input type="text" name="position" style="width: 400px;height: 70px" value="${resume.position }"></td>
</tr>

<tr>
<td>在校期间获奖：</td>
<td><input type="text" name="honor" style="width: 400px;height: 70px" value="${resume.honor }"></td>
</tr>

<tr>
<td>科研成果：</td>
<td><input type="text" name="research" style="width: 400px;height: 70px" value="${resume.research }"></td>
</tr>

<tr>
<td>自我评价：</td>
<td><input type="text" name="selfevaluation" style="width: 400px;height: 70px" value="${resume.selfevaluation }"></td>
</tr>


</tr>

</table>
</form>
</body>
</html>