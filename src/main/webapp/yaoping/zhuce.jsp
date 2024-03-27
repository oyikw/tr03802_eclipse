<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	<h1>注册用户</h1>
	<form action="zhuce" method="post">
		用户名：<input name="name" required><br><br>
		密码：<input type="password"  required name="pwd"><br><br>
		邮箱：<input name="email" required><br><br>
		电话号码：<input name="tel" required><br><br>
		 <input type="submit" value="注册">
	</form>
	<p>已有账号？请<a href="login.jsp">登录</a></p>
	<p>${tishi }</p>
</body>
</html>