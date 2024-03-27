<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>
	*{
		font-size:14px;
	}
	.tab{
		border-collapse:collapse;
		width:850px;
		margin-top:25px;
		margin-bottom:10px;
	}
	.tab tr td{
		width:162.5px;
		padding:10px;
	}
	.tab tr td:first-child {
		text-align:center;
		width:50px;
	}
	.tab tr td:nth-child(2) {
		text-align:center;
	}
	.tab tr td:nth-child(3) {
		text-align:center;
	}
	.tab tr td:nth-child(4) {
		text-align:center;
	}
</style>
<meta charset="UTF-8">
<title>留言列表</title>
</head>
<body>
	<h1>所有留言</h1>
	<a href="insert.jsp">添加新留言</a>
	<form action="delete" method="post">
		<input type="submit" value="删除留言">
		<c:forEach items="${list }" var="s">
			<table class="tab" border="1">
				<tr>
					<td rowspan="2"><input type="checkbox" value="${s.sid }" name="sid"></td>
					<td>留言人</td>
					<td>${s.suser }</td>
					<td>留言时间</td>
					<td><fmt:formatDate value="${s.stime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<td>留言内容</td>	
					<td colspan="3">${s.scontent}</td>
				</tr>
			</table>
		</c:forEach>
	</form>
</body>
</html>
