<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>企业基本信息</title>
<link href="/xyjygl/css/stucss.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/xyjygl/js/datepicker.js"></script>
</head>
<body>
</head>
<body>
<form action="/xyjygl/companyManage" method="post" style="margin: 0pt;">

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
									Object obj = request.getAttribute("cid");
									String companyid = "";
									if (obj!= null) {
										companyid = String.valueOf(obj);
									}
								%> 
								<input type="hidden" value="<%=companyid%>" name="cid" />
							</td>
							<td colspan="2" width="310">
							<input type="hidden" value="companyregister" name="action" /></td>
						</tr>
					
						<tr>
							<td align="right" height="30" width="190">公司名称：</td>
							<td width="310" align="left">&nbsp;&nbsp;
							 <input type="text" name="companyname" size="30">
							 </td>
						</tr>
						
						<tr>
							<td align="right" height="30">公司性质：</td>
							<td width="310" align="left">&nbsp;&nbsp;
							 <input type="text" name="unitproperty" size="30">
							 </td>
						</tr>
						
						<tr>
							<td align="right" height="30">营业执照号：</td>
							<td>&nbsp; 
							<input type="text" name="licensenumber" size="50" />
							</td>
						</tr>

						<tr>
							<td align="right" height="30">所属行业</td>
							<td>&nbsp;&nbsp; <input type="text" name="industry" size="50" />
							</td>
						</tr>

						<tr>
							<td align="right" height="30">单位规模</td>
							<td>&nbsp;&nbsp; 
							<input type="text" name="unitscale" size="50" />
							</td>
						</tr>

						<tr>
							<td align="right" height="30">公司地址</td>
							<td width="310" align="left">&nbsp;&nbsp;
							 <input type="text" name="address" size="30">
							 </td>
						</tr>

						<tr>
							<td align="right" height="30">公司网址</td>
							<td>&nbsp;&nbsp; <input type="text" name="webaddress" size="50">
							</td>
						</tr>
						
						<tr>
							<td align="right" height="30">联系人</td>
							<td>&nbsp;&nbsp; <input type="text" name="linkman" size="50">
							</td>
						</tr>


						
						<tr>
							<td align="right" height="30">电话</td>
							<td>&nbsp;&nbsp; <input type="text" name="telephone"
								size="50">
							</td>
						</tr>
						
						<tr>
							<td align="right" height="30">邮箱</td>
							<td>&nbsp;&nbsp; <input type="text" name="email" size="50">
							</td>
						</tr>
						
						<tr>
				 			<td align="right" height="30">邮编</td>
							<td>&nbsp;&nbsp; <input type="text" name="postcode" size="50">
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