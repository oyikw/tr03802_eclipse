<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>指定月份</title>
</head>
<style>
	tr{
		height:40px;
		text-align:center;
	}
	td{
		width:200px;
	}
</style>
<body>
	<h1>指定月份记录</h1>
	<form action="zhid" method="post">
		请输入查询月份：<input name="zhi" type="number" required>
		<input type="submit">
	</form>
	<br>
	<table border="1" cellspacing="0">
	    <tr style="text-align:center">
	        <th>用药时间</th>
	        <th>药物名称</th>
	    </tr>
	    <c:forEach items="${list}" var="v">
	        <tr>
	            <fmt:formatDate value="${v.ytime}" pattern="yyyy-MM-dd HH:mm:ss" var="formattedDate" />
	            <td>${formattedDate}</td>
	            <td>${v.ytype}</td>
	        </tr>
	    </c:forEach>
	</table>
	<br>
	<br><br>
	<a href="home.jsp">返回</a>
</body>
</html>