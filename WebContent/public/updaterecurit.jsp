<%@page import="cn.yjpt.bean.Recurit"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>招聘信息</title>
<style type="text/css">	  
	  .tb td{
	     background-color:#f0fafc;
	     font-size:12px;
	  }
	</style>
</head>
<body bgcolor="eff2fb">

<form action="/xyjygl/recruitManage" method="post">
   	  <table width="500" border="0" align="center" id="table" class="ta">
			<tr>
				<td colspan="6" align="center" bgcolor="#f9f9f9" height="25">
					<span class="STYLE1">招聘信息</span>
				</td>
			</tr>
			 
			 
			<tr>
				<td width="30%" align="center">单位名称：</td>
				<td width="70%" >		
						    <input type="hidden" name="action" value="update" />
				<input type="hidden" name="rid" value="${recurit.rid}" /> 
					<input type="text" name="companyname"	value="${recurit.companyname}" readonly/>					
				
				
				<!--      <input type="hidden" name="cid"	value="${recruit.cid}"/>-->
				</td>
			</tr> 
			<tr>
				<td  align="center">单位地址：</td>
				<td>
				<input type="text" name="address"	value="${recurit.address}" readonly/>				
				</td>
			</tr>
			<tr>
				<td align="center" >邮政编码：</td>
				<td>
					<input type="text" name="postcode" value="${recurit.positiontype}"/>&nbsp;
				</td>
			</tr>
			<tr>
				<td align="center">招聘人数：</td>
				<td>
					<input type="text" name="recruitment" value="${recurit.recruitment}"/>
				</td>
			</tr>
			<tr>
				<td align="center">工作地点：</td>
				<td>				
					<input type="text" name="workingplace" value="${recurit.workingplace}"/>				
				</td>
			</tr>
			<tr>
				<td align="center">职位性质：</td>
				<td>				
				<input type="text" name="positiontype" value="${recurit.positiontype}"/>		
				</td>
			</tr>
			<tr>
				<td align="center">学历要求：</td>
				<td>
				   <input type="text" name="edurequire" value="${recurit.edurequire}"/>
				</td>
			</tr>
			<tr>
				<td align="center">职位描述及要求：</td>
				<td>					
					<textarea name="description">${recurit.description}</textarea>					
				</td>
			</tr>			
			<tr>
				<td align="center">使用部门：</td>
				<td>
					<input type="text" name="branch" value="${recurit.branch}"/>
				</td>
			</tr>
			<tr>
				<td align="center">联系人：</td>
				<td>
					<input type="text" name="linkman" value="${recurit.linkman}"/>&nbsp;
				</td>
			</tr>			
			<tr>
				<td align="center">联系电话：</td>
				<td>
					<input type="text" name="telephone" value="${recurit.telephone}" />&nbsp;
				</td>
			</tr>			
			<tr>
				<td align="center">单位主页：</td>
				<td>
					<input type="text" name="hostpage" value="${recurit.hostpage}" readonly/>
				</td>
			</tr>	
			
			<tr>
				<td align="center">邮箱：</td>
				<td>
					<input type="text" name="email" value="${recurit.email}" />
				</td>
			</tr>		
			<tr>
			<td>
			<input type="submit" value="修改"/>
			</td></tr>	
		</table>     
</form>
  </body>
</html>