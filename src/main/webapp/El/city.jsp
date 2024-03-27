<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="city" method="post">
		<input type="submit" value="提交">
	</form>
	<c:forEach items="${list }" var="item">
		<p>${item }</p>
	</c:forEach>
</body>
</html>