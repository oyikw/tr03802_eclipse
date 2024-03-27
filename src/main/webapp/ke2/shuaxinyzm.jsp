<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="yanzhengma.jsp?randomNum=<%= Math.random() %>">
	<a href="<%= request.getRequestURI() %>">刷新</a>
</body>
</html>