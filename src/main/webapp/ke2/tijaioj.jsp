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
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String ah = request.getParameter("ah");
		String xueli = request.getParameter("xueli");
		String zwjs = request.getParameter("zwjs");
	%>
	<h1>注册结果</h1>
	<p>
		用户名：
		<%= name %></p>
	<p>
		密码：
		<%= pwd %></p>
	<p>
		性别：
		<%= sex %></p>
	<p>
		爱好：
		<%= ah %></p>
	<p>
		学历：
		<%= xueli %></p>
	<p>
		自我介绍：
		<%= zwjs %></p>
</body>
</html>