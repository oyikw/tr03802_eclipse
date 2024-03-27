<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<h1>登录</h1>
	<form action="dl" method="post">
		用户名：<input name="name" required><br><br>
		密码：<input type="password" required name="pwd"><br><br>
		 <input type="submit" value="登录">
	</form>
	<p>没有账号？请<a href="zhuce.jsp">注册</a></p>
	<p>${tishi }</p>
	<h3>${change }</h3>
</body>
</html>