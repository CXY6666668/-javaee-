<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
 <head>		
	<title>企业基本信息修改</title>
    <link href="/xyjygl/css/stucss.css" rel="stylesheet" type="text/css">
   
 </head>
 <body>		
	<form  method="post" action="/xyjygl/companyManage" style="margin:0pt;">
	  <table class="regtable" width="600" align="center" border="0" cellpadding="0"	cellspacing="0">		
		<tr>
          <td></td>
        </tr>
		<tr>
		    <td colspan="2" class="tdinfo" height="25">&nbsp;		    
			<span style="font-weight: bold;">公司基本信息</span>
		    </td>
		</tr>
		<tr>
		    <td width="150" align="right" height="30">
				公司名称：
			</td>
			<td height="30">
				<input type="hidden" name="action" value="update" />
				<input type="hidden" name="cid" value="${company.cid}" /> 
				<input type="text" name="companyname" size="50" value="${company.companyname}"  />				
			</td>
		</tr>	
		<tr>
			<td align="right" height="30">单位性质：</td>
			<td height="30">
			    <input type="text" name="unitproperty" size="50" value="${company.unitproperty}"  />
			</td>
		</tr>
		<tr>
			<td align="right" height="30">营业执照号：</td>
			<td height="30">
			    <input type="text" name="licensenumber" size="50" value="${company.licensenumber}"  />
			</td>
		</tr>
		<tr>
			<td align="right" height="30">
				所属行业：
			</td>
			<td height="30">
			    <input type="text" name="industry" size="50" value="${company.industry}" />
			</td>
		</tr>
		<tr>
			<td align="right" height="30">
				单位规模：
			</td>
			<td height="30">
			    <input type="text" name="unitscale" size="50" value="${company.unitscale}" />
			</td>
		</tr>
		<tr>
			<td align="right" height="30">
				公司地址：
			</td>
			<td height="30">
			    <input type="text" name="address" size="50" value="${company.address}" />
			</td>
		</tr>	
	    <tr>
			<td align="right" height="30">
				公司网址：
			</td>
			<td height="30">
			    <input type="text" name="webaddress" size="50" value="${company.webaddress}" />
			</td>
		</tr>
	     <tr>
			<td align="right" height="30">
				联系人：
			</td>
			<td height="30">
			    <input type="text" name="linkman" size="50" value="${company.linkman}" />
			</td>
		</tr>
	    <tr>
			<td align="right" height="30">
				电话：
			</td>
			<td height="30">
			    <input type="text" name="telephone" size="50" value="${company.telephone}" />
			    <br>
			(格式：010-88888888 或者 13912345678 ，多个电话请用,隔开)
			</td>
		</tr>
	    <tr>
			<td align="right" height="30">
				邮箱：
			</td>
			<td height="30">
			    <input type="text" name="email" size="50" value="${company.companyname}" />
			</td>
		</tr>
 	    <tr>
			<td align="right" height="30">
				邮编：
			</td>
			<td height="30">
			    <input type="text" name="postcode" size="50" value="${company.postcode}" />
			</td>
		</tr>		
		<tr>
			<td colspan="2" align="center" height="30">
				<input type="submit"  value="修改" />
			</td>
		</tr>								
	  </table>
    </form>							
  </body>
</html> 
