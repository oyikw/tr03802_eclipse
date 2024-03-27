<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注册</h1>
	<form action="zhuce" method="post" enctype="multipart/form-data">
		用户名：<input id="name" name="name"><br>
		 密码：<input	type="password" id="pwd" name="pwd"><br>
		 电话：<input name="tel"><br>
		 地址：<input name="addres"><br>
		 头像：<input name="photo" type="file">
		 <input type="submit" value="注册">
	</form>
</body>
</html>