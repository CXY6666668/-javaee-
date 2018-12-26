<%@ page language="java" import="java.util.*"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>查看投简历具体情况</title>
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
<form action="/xyjygl/recruitresumeManage" method="post">
<c:set var="dopage" value="${doPage}" />
        <c:set var="list"  value="${dopage.list }"></c:set>	
<table width="80%" border="1">
<tr bgcolor="#dcdcdc">
<th width="20%" height="30px">姓名</th>
<th width="20%" height="30px">性别</th>
<th width="20%" height="30px">毕业院校</th>
<th width="20%" height="30px">专业</th>
<th width="20%" height="30px">操作</th>
</tr>

<c:forEach var="resume" items="${resumelist}">
<tr>
<td align="center" height="26px">
<c:out value="${resume.sname }"></c:out>
</td>
<td align="center" height="26px">
<c:out value="${resume.gender }"></c:out>
</td>
<td align="center" height="26px">
<c:out value="${resume.school }"></c:out>
</td>
<td align="center" height="26px">
<c:out value="${resume.major }"></c:out>
</td>
<td align="center" height="26px">
 <a href="/xyjygl/resumeManage?action=show&sid=${resume.sid}">查看简历</a> 
</td>
</tr>
</c:forEach> 
<!-- 
<tr> 
<td colspan="5" align="right">
					<a href="/xyjygl/studentManage?action=studentlist&page=1&sql=${dopage.sql}">首页</a>
					&nbsp;&nbsp;
					<c:if test="${dopage.nowPage-1>0}">
						<SPAN class=Unable><a
							href="/xyjygl/studentManage?action=studentlist&page=${dopage.nowPage-1}&sql=${dopage.sql}">上一页
						</a> </SPAN>
					</c:if>
					&nbsp;&nbsp;
					<c:if test="${dopage.nowPage+1<=dopage.totalPage}">
            &nbsp;&nbsp;&nbsp;
              <a  href="/xyjygl/studentManage?action=studentlist&page=${dopage.nowPage+1}&sql=${dopage.sql}">下一页</a>
					</c:if>
					&nbsp;&nbsp;
					<a 	href="/xyjygl/studentManage?action=studentlist&page=${dopage.totalPage}&sql=${dopage.sql}">末页</a>
					&nbsp;&nbsp;共${dopage.totalPage}页
				</td>
				
			</tr>
           <tr>
            <td colspan="5" height="26px">按姓名模糊搜索
                <input type="hidden" name="action" value="studentlist"/>
				<input type="text" name="sql"/>
				<input type="submit" value="搜索"/></td>           
           </tr> -->
        </table>
     </form>
  </body>
</html>
