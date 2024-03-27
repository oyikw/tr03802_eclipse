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
		//向客户端写入cookie
		Cookie cl = new Cookie("user","oyikw");
		cl.setMaxAge(100);
		response.addCookie(cl);
		
		Cookie c2 = new Cookie("addres","株洲");
		response.addCookie(c2);
		
		
		
	%>
</body>
</html>