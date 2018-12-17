<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>企业信息管理</title>    
	<style type="text/css">
	   body{
	     background-color:#e6e6fa;
	   }
	   *{
	     font-size:12px;
	   }               
	   
	</style>
  </head>  
  <body>
     <form action="/xyjygl/companyManage" method="post">
        <c:set var="dopage" value="${doPage}" />
        <c:set var="list"  value="${dopage.list }"></c:set>	
        <table width="80%" border="1">
           <tr bgcolor="#DCDCDC">
              <th width="20%" height="30px">公司名称</th>
              <th width="20%" height="30px">单位性质</th>
              <th width="20%" height="30px">营业执照号</th>
              <th width="20%" height="30px">所属行业</th>
              <th width="20%" height="30px">操作</th>              
           </tr>           
           <c:forEach var="company" items="${list}">
            <tr>
              <td align="center" height="26px">
                <c:out value="${company.companyname}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${company.unitproperty}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${company.licensenumber}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${company.industry}"></c:out>
              </td>
              <td align="center" height="26px">
                <a href="/xyjygl/companyManage?action=show&cid=${company.cid}">查看</a>|
                <a href="/xyjygl/companyManage?action=delete&cid=${company.cid}">删除</a>|
                <a href="/xyjygl/companyManage?action=choose&cid=${company.cid}">发布招聘</a>
              </td>
            </tr>
           </c:forEach>
           <tr>
				<td colspan="5" align="right">
					<a href="/xyjygl/companyManage?action=companylist&page=1&sql=${dopage.sql}">首页</a>
					&nbsp;&nbsp;
					<c:if test="${dopage.nowPage-1>0}">
						<SPAN class=Unable><a
							href="/xyjygl/companyManage?action=companylist&page=${dopage.nowPage-1}&sql=${dopage.sql}">上一页
						</a> </SPAN>
					</c:if>
					&nbsp;&nbsp;
					<c:if test="${dopage.nowPage+1<=dopage.totalPage}">
            &nbsp;&nbsp;&nbsp;
              <a  href="/xyjygl/companyManage?action=companylist&page=${dopage.nowPage+1}&sql=${dopage.sql}">下一页</a>
					</c:if>
					&nbsp;&nbsp;
					<a 	href="/xyjygl/companyManage?action=companylist&page=${dopage.totalPage}&sql=${dopage.sql}">末页</a>
					&nbsp;&nbsp;共${dopage.totalPage}页
				</td>
				
			</tr>
           <tr>
            <td colspan="5" height="26px">按公司名模糊搜索
                <input type="hidden" name="action" value="companylist"/>
				<input type="text" name="sql"/>
				<input type="submit" value="搜索"/></td>           
           </tr>
        </table>
     </form>
  </body>
</html>
