<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>留言板</title>
    <style type="text/css">	  	 
	  .t1{
	     font-size:12px;
	     margin-top:15px;
	  }
	  .t1 tr{
	      line-height:30px;	    
	  }
	  .t1 th{
	       font-size:12px;
	       line-height:30px;
	       font-weight:bold;
	       text-align:left;
	  }
	  .t1 td{
	    font-size:12px;
	      text-align:left;
	  }	  
	  .pagediv{
	      font-size:12px;
	      float:right;
	      margin-right:180px;
	  }
	</style>
  </head>  
  <body>                   
     <table class="t1" border="0" cellpadding="0" cellspacing="0" width="80%" align="center">                    
        <c:set var="dopage"  value="${doPage}" />
	    <c:set var="msglist" value="${dopage.list}" />	
		<c:forEach var="msg" items="${msglist}">
		<tr>
		   <td>
			  <table bgcolor="#F7F8F9" width="100%" frame="box" bordercolor="pink"/>
			  	<tr>
				    <td width="20%">
					   <strong> 留言用户：</strong><c:out value="${msg.username}" />
					</td>
					<td bgcolor="#F7F8F9" width="50%">
					   <strong>留言标题：</strong><c:out value="${msg.title}" />
					</td>					        
					<td width="30%">
						<strong>留言时间：</strong> <c:out value="${msg.msgtime}" />
					</td>
				 </tr>
				 <tr>
					<td colspan="3"><strong>留言内容：</strong></td>
				 </tr>
				 <tr>
				    <td colspan="3">					
						<c:out value="${msg.content}" escapeXml="false" />											      
					</td>
				 </tr> 
				 <tr>
					<td colspan="3"><strong>留言回复：</strong></td>
				 </tr>
				 <tr>
				   <td colspan="3">					 
						<c:out value="${msg.reply}" escapeXml="false" />					 
					</td>
				 </tr> 
				 <c:if test="${user.usertypes eq 'admin'}">
				 <tr>
					 <td colspan="3">
					  <a  href="/xyjygl/messageManage?action=reply&mid=<c:out value="${msg.mid}"/>">回复留言</a>
					  <a  href="/xyjygl/messageManage?action=delete&mid=<c:out value="${msg.mid}"/>">删除留言</a>
					</td>
				 </tr>
				 </c:if>								
			    </table>
			</td>
		 </tr>  
	     </c:forEach>
	     <tr>
	     <td>		                         
		 <div class="pagediv">
             <span>
			 <a href="/xyjygl/messageManage?action=list&page=1">首页</a> &nbsp;&nbsp;
			 <c:if test="${dopage.nowPage-1>0}">
			   <a href="/xyjygl/messageManage?action=list&page=${dopage.nowPage-1}">上一页
				</a>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${dopage.nowPage+1<=q.totalPage}">
               &nbsp;&nbsp;&nbsp;
               <a	href="/xyjygl/messageManage?action=list&page=${dopage.nowPage+1}">下一页</a>
			</c:if>
			   &nbsp;&nbsp;
			     <a href="/xyjygl/messageManage?action=list&page=${dopage.totalPage}">末页</a>
				&nbsp;&nbsp;
				共${dopage.totalPage }页
		  </span>		  
        </div>
        </td>
        </tr>
      </table>           
  </body>
</html>
