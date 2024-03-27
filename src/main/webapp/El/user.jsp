<%@page import="el.User"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User u = new User(1,"张三",Date.valueOf("2001-1-1"));
		request.setAttribute("u", u);
	%>
	
	${u.uid}
	${u.name}
	${u.birthday}
</body>
</html>