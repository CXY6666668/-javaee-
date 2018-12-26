<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理招聘信息</title>
<style type="text/css">
body {
	background-color: #e6e6fa;
}

* {
	font-size: 12px;
}
</style>
</head>
<body>
	<form action="/xyjygl/recruitManage" method="post">
		<c:set var="dopage" value="${doPage}" />
		<c:set var="list" value="${dopage.list }"></c:set>
		<table width="90%" border="1">
			<tr bgcolor="#dcdcdc">
				<th width="15%" height="30px">公司名称</th>
				<th width="15%" height="30px">招聘人数</th>
				<th width="15%" height="30px">工作地点</th>
				<th width="15%" height="30px">职位性质</th>
				<th width="15%" height="30px">学历要求</th>
				<th width="15%" height="30px">操作</th>
			</tr>

			<c:forEach var="recurit" items="${list }">
				<tr>
					<td align="center" height="26px"><c:out
							value="${recurit.companyname }"></c:out></td>
					<td align="center" height="26px"><c:out
							value="${recurit.recruitment }"></c:out></td>
					<td align="center" height="26px"><c:out
							value="${recurit.workingplace }"></c:out></td>
					<td align="center" height="26px"><c:out
							value="${recurit.positiontype }"></c:out></td>
					<td align="center" height="26px"><c:out
							value="${recurit.edurequire }"></c:out></td>
					<td align="center" height="26px"><c:choose>
							<c:when test="${user.usertypes=='student'}">
								<a
									href="/xyjygl/recruitresumeManage?action=tou&rid=${recurit.rid}&cid=${recurit.cid}&sid=${user.id}">投递简历</a>
							</c:when>
							<c:otherwise>
								<a href="/xyjygl/recruitManage?action=delete&rid=${recurit.rid}">删除</a>|
                <a
									href="/xyjygl/recruitManage?action=edit&rid=${recurit.rid}">修改</a>
							</c:otherwise>
						</c:choose> <a href="/xyjygl/recruitManage?action=show&rid=${recurit.rid}">查看</a>|

					</td>
				</tr>
			</c:forEach>

			<tr>

				<td colspan="5" align="right"><a
					href="/xyjygl/recruitManage?action=recruitlist&page=1&sql=${dopage.sql}">首页</a>
					&nbsp;&nbsp; <c:if test="${dopage.nowPage-1>0}">
						<SPAN class=Unable><a
							href="/xyjygl/recruitManage?action=recruitlist&page=${dopage.nowPage-1}&sql=${dopage.sql}">上一页
						</a> </SPAN>
					</c:if> &nbsp;&nbsp; <c:if test="${dopage.nowPage+1<=dopage.totalPage}">
            &nbsp;&nbsp;&nbsp;
              <a
							href="/xyjygl/recruitManage?action=recruitlist&page=${dopage.nowPage+1}&sql=${dopage.sql}">下一页</a>
					</c:if> &nbsp;&nbsp; <a
					href="/xyjygl/recruitManage?action=recruitlist&page=${dopage.totalPage}&sql=${dopage.sql}">末页</a>
					&nbsp;&nbsp;共${dopage.totalPage}页</td>

			</tr>
			<tr>
				<td colspan="5" height="26px">按公司名模糊搜索 <input type="hidden"
					name="action" value="recruitlist" /> <input type="text" name="sql" />
					<input type="submit" value="搜索" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
