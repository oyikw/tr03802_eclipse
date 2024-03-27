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
		String name = (String)session.getAttribute("name");
		if(name == null){
			out.print("对不起，请先<a href='login.jsp'>登陆</a>！");
		}else{
	%>
			<h1>这是Manger页面</h1>
	<%
		}
	%>
</body>
</html>