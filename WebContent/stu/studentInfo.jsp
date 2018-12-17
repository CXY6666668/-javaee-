<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>學生基本信息</title>
<link href="/xyjygl/css/stucss.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/xyjygl/js/datepicker.js"></script>
</head>
<body>
</head>
<body>
<form action="/xyjygl/studentManage" method="post" style="margin: 0pt;">

		<jsp:include page="/public/info.jsp"></jsp:include>
		<table class="regtable" width="500" align="center" border="0" cellpadding="5" cellspacing="1">
			<tr>
				<td valign="top" width="500" bgcolor="#f9f9f9" height="350">
					<table width="500" align="center" border="0" cellpadding="0"   cellspacing="0">
						<tr>
							<td colspan="2" class="tdinfo" height="25">&nbsp;
							<span style="font-weight: bold;">基本信息</span>
							</td>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" width="190">
								<%
									Object obj = request.getAttribute("sid");
									String stuid = "";
									if (obj!= null) {
										stuid = String.valueOf(obj);
									}
								%> 
								<input type="hidden" value="<%=stuid%>" name="sid" />
							</td>
							<td colspan="2" width="310">
							<input type="hidden" value="sturegister" name="action" /></td>
						</tr>
					
						<tr>
							<td align="right" height="30" width="190">姓名：</td>
							<td width="310" align="left">&nbsp;&nbsp;
							 <input type="text" name="sname" size="30">
							 </td>
						</tr>
						
						<tr>
							<td align="right" height="30">性別：</td>
							<td>&nbsp;&nbsp; 
							<input name="gender" type="radio" value="女" checked style="border:0;"/>女&nbsp; 
								<input name="gender" type="radio" value="男" style="border:0;"/>男&nbsp;
							</td>
						</tr>
						
						<tr>
							<td align="right" height="30">身份證號：</td>
							<td>&nbsp; 
							<input type="text" name="idnumber" size="50" />
							</td>
						</tr>

						<tr>
							<td align="right" height="30">学校</td>
							<td>&nbsp;&nbsp; <input type="text" name="school" size="50" />
							</td>
						</tr>

						<tr>
							<td align="right" height="30">院系</td>
							<td>&nbsp;&nbsp; 
							<input type="text" name="department" size="50" />
							</td>
						</tr>

						<tr>
							<td align="right" height="30">专业</td>
							<td>&nbsp;&nbsp; <input type="text" name="major" size="50" />
							</td>
						</tr>

						<tr>
							<td align="right" height="30">学历</td>
							<td>&nbsp;&nbsp; <select name="education">
									<option value="00" selected="selected">请选择</option>
									<option value="本科">专科</option>
									<option value="本科">本科</option>
									<option value="硕士研究生">硕士研究生</option>
									<option value="博士研究生">博士研究生</option>
							</select>
							</td>
						</tr>


						<tr>
							<td align="right" height="30">入學時間</td>
							<td>&nbsp;&nbsp;
							 <input type="text" name="entrancedate" style="width: 100px" onfocus="HS_setDate(this)">
							</td>
						</tr>

						<tr>
							<td align="right" height="30">籍貫</td>
							<td>&nbsp;&nbsp; <input type="text" name="nativeplace"   size="50">
							</td>
						</tr>

						<tr>
							<td></td>
							<td align="left" height="30"><input name="imageField"
								src="/xyjygl/images/Login_but.gif" type="image"
								style="margin-left: 50px">
								</td>

						</tr>
					
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>