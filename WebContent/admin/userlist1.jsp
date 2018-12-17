<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>用户管理</title>  
    <style type="text/css">
	  .ulist{
	      font-size:12px;
	      font-weight:bold;	    
	      line-height:20px;
	  }
	  .btnverify{
	     margin-top:12px;
	  }
	  .btnverify input{
	      border-color:#4169E1;
	      border-width:1;
	      width:50px;
	      background-color:#B0E0E6;	      
	      line-height:20px;
	  }
	  .t1{
	     font-size:12px;
	     margin-top:15px;
	  }
	  .t1 tr{
	      line-height:30px;
	      font-weight:bold;
	  }
	  .t1 td{
	      text-align:center;
	  }
	  .btnverify{
	      float:left;
	  }
	  .pagediv{
	      font-size:12px;
	      float:right;
	      margin-right:180px;
	  }
	</style>
	<script type="text/javascript">	   
	   function sub() {	   
	    var eleaction=document.getElementById("action");
	    eleaction.value="list";	   
	    var opvalue=document.getElementById("userselected").value;
	    document.getElementById("sql").value=opvalue;	   
		document.flist.submit();
	   }
	</script>
  </head>  
  <body>
    <form action="/jygl/userManage" name="flist" method="post"> 
        <input type="hidden" name="action" id="action" value="">       
        <input type="hidden" name="sql" id="sql" value="">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
                 <td valign="top" background="/jygl/images/mail_leftbg.gif" width="17">
                     <img alt="1" src="/jygl/images/left-top-right.gif" width="17">
                 </td>   
                 <td valign="middle" background="/jygl/images/content-bg.gif" >
                     <table width="100%" border=0 cellspacing=0 cellpadding=0>
                          <tr>
                             <td>
                                 <div class="ulist">用户列表</div>
                             </td>
                          </tr>
                     </table>
                 </td>
                 <td width="16" background="/jygl/images/mail_rightbg.gif">
                    <img alt="1" src="/jygl/images/nav-right-bg.gif">
                 </td>              
            </tr> 
            <tr>
              <td valign="top" background="/jygl/images/mail_leftbg.gif" width="17">&nbsp;     
              </td>
              <td>
                <div>
                  <!-- 定义变量名dopage,值为请求中封装的属性名为doPage的属性值 -->                 
                  <c:set var="dopage" value="${doPage }" />
                  <span class="ulist"><strong>用户管理</strong>（共${dopage.count}个用户）</span>
                </div>
                <div class="btnverify">                   
                   <select class="sec" name="userselected" id="userselected" onchange="sub()">
                     <option value="">审核状态</option>                     
                     <option value="1">未审核</option>
                     <option value="2">已审核</option>
                     <option value="3">审核未通过</option>
                   </select>
                </div>
                <div class="usertable">
                   <table class="t1" border="0" cellpadding="0" cellspacing="0" width="100%">
                     <tr>
                       <th width="20"></th>                       
                       <th width="100">编号</th>
                       <th width="150">用户名</th>
                       <th width="200">密码</th>
                       <th width="150">用户类型</th>
                       <th>操作</th>
                     </tr>
                     <!-- 定义变量名userlist，值是变量dopage的属性list的值,类型是List，成员是User对象 -->
                     <c:set var="userlist" value="${dopage.list }"/>
                     <!-- 定义变量名u,值为session中封装的属性名为user的属性的值，类型是User --,u是当前登录用户-->
                     <c:set var="u" value="${user }"/>
                     <!-- 定义循环变量名字为list,每次循环，list的值为userlist的一个元素 ,list是一个User对象-->
                     <c:forEach var="list" items="${userlist }">
                       <c:if test="${list.id != u.id }">
                         <tr>
                           <td></td>                           
                           <td><c:out value="${list.id}"></c:out></td>
                           <td><c:out value="${list.username}"></c:out></td>
                           <td><c:out value="${list.password}"></c:out></td>
                           <td><c:out value="${list.usertypes}"></c:out></td>
                           <td>
                           <span>
                             <c:if test="${list.verify=='1'}">
                               <a href="/jygl/userManage?action=active&id=${list.id}">审核通过</a>
                               <a href="/jygl/userManage?action=invalid&id=${list.id}">审核未通过</a>
                             </c:if>
                             <c:if test="${list.verify=='2'}">
                              <a href="/jygl/userManage?action=disable&id=${list.id}">禁用</a>
                             </c:if>
                             <c:if test="${list.verify!='3'}">
                             |<a href="/jygl/admin/editUser.jsp?id=${list.id}">修改密码</a>|
                             </c:if>
                             
                             <a href="/jygl/userManage?action=delete&id=${list.id}">删除</a>
                           </span>
                           </td>
                         </tr>
                       </c:if>
                     </c:forEach>
                   </table>
                </div>      
                
                <div class="pagediv">
                  <span>
                    <a href="/jygl/userManage?action=list&page=1&sql=${dopage.sql}">首页</a>
                    &nbsp;&nbsp;
                    <c:if test="${dopage.nowPage-1>0}">
                      <a href="/jygl/userManage?action=list&page=${dopage.nowPage-1}&sql=${dopage.sql}">上一页</a>
                      &nbsp;&nbsp;
                    </c:if>
                    <c:if test="${dopage.nowPage<dopage.totalPage}">
                     <a href="/jygl/userManage?action=list&page=${dopage.nowPage+1}&sql=${dopage.sql}">下一页</a>
                     &nbsp;&nbsp;
                    </c:if>
                    <a href="/jygl/userManage?action=list&page=${dopage.totalPage}&sql=${dopage.sql}">末页</a>
                     &nbsp;&nbsp;
                                               共有${dopage.totalPage}页 
                  </span>
                </div>
              </td>
              <td width="16" background="/jygl/images/mail_rightbg.gif">&nbsp;</td>
            </tr>
            <tr>
                <td width="17" background="/jygl/images/mail_leftbg.gif">
                   <img alt="1" src="/jygl/images/buttom_left2.gif">
                </td>
                <td background="/jygl/images/buttom_bgs.gif ">
                   <img alt="1" src="/jygl/images/buttom_bgs.gif">
                </td>
                <td  background="/jygl/images/mail_rightbg.gif">
                   <img alt="1" src="/jygl/images/buttom_right2.gif">
                </td>
            </tr>
        </table>
    </form>
  </body>
</html>
