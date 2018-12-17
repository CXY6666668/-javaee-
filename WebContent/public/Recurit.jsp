<%@ page language="java"
	pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>招聘信息</title>
<link href="/xyjygl/css/stucss.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/xyjygl/recruitManage" name="form" method="post">

	<table class="regtable" width="550" align="center" border="0"
			cellpadding="5" cellspacing="1">
			<caption class="txt">招聘信息</caption>
			<tr>
			<td></td>
			</tr>
			
			<tr>
				<td valign="top" width="500" bgcolor="#f9f9f9" height="350">
					<table width="500" align="center" border="0" cellpadding="0"
						cellspacing="0">
						
						
						<tr>
							<td colspan="2" class="tdinfo" height="25"><span
								style="font-weight: bold;">招聘信息</span>
							</td>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" height="25">
							<%
							Object obj=request.getAttribute("rid");
							String rectuitid=String.valueOf(obj);
							if(obj!=null)
							{
								rectuitid=String.valueOf(obj);
							}
							%>
							<input type="hidden" value="<%=rectuitid%>">
							</td>
							<td>
							  <input type="hidden" value="add" name="action">
							</td>
							<td colspan="2">&nbsp;</td>
						</tr>
						
						<tr>
							<td align="right" height="30" width="190">公司名称：</td>
							<td height="30" width="370" align="left">&nbsp;&nbsp; <input type="text"
								name="companyname" size="30" value="${company.companyname}"/>
							</td>
							<td colspan="2" width="310">
							<input type="hidden" value="${company.cid }" name="cid"/>
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">单位地址：</td>
							<td width="370" align="left">&nbsp;&nbsp; <input type="text"
								name="address" value="${company.address}" size="50" />
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">邮编：</td>
							<td width="370" align="left">&nbsp;&nbsp; <input type="text"
								name="postcode" value="${company.postcode}" size="50" />
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">招聘人数：</td>
							<td width="370" align="left">&nbsp;&nbsp; <input type="text"
								name="recruitment" size="50" />
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">工作地点：</td>
							<td width="370" align="left">&nbsp;&nbsp; <input type="text"
								name="workingplace"  size="50" />
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="190">职位性质：</td>
							<td width="310" align="left">&nbsp;&nbsp; <select
								name="positiontype">
									<option value="00" selected="selected">请选择</option>
									<option value="全职">全职</option>
									<option value="兼职">兼职</option>
									<option value="实习">实习</option>
							</select>
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">学历要求：</td>
							<td width="370" align="left">&nbsp;&nbsp;<input
								name="edurequire" type="text" size="50" />
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">职位描述及要求：</td>
							<td width="370" align="left">&nbsp;&nbsp;<textarea 
								 name="description" rows="2" cols="30" ></textarea>
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">使用部门：</td>
							<td width="370" align="left">&nbsp;&nbsp;<input
								name="branch" type="text" size="20" />
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">联系人：</td>
							<td width="370" align="left">&nbsp;&nbsp;<input
								name="linkman" type="text" size="20" />
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">电话：</td>
							<td width="370" align="left">&nbsp;&nbsp; <input type="text"
								name="telephone"  size="50" />
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">网站：</td>
							<td width="370" align="left">&nbsp;&nbsp; 
								 <input type="text" name="hostpage" value="${company.webaddress}" size="20"> 
							
							</td>
						</tr>
						<tr>
							<td align="right" height="30" width="130">邮箱：</td>
							<td width="370" align="left">&nbsp;&nbsp; <input type="text"
								name="email" value="${company.email}" size="50" />
							</td>
						</tr>
						<tr>
							<td width="20%" height="38">&nbsp;</td>
							<td colspan="2" align="center">
							<input type="submit" value="提交">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</form>
</body>
</html>