<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>请登录留言</h1>
	<form action="denglu-ok.jsp" method="post">
		用户名：<input id="name" name="name"><br> 密码：<input
			type="password" id="pwd" name="pwd"><br> <input
			type="submit" value="登录">
	</form>
	<br> 如果没有账号，请点击：
	<a href='zhuce.jsp'>注册</a>
</body>
</html>