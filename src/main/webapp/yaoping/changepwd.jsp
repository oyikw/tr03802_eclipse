<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
</head>
<body>
	<h1>修改密码</h1>
	<form action="pwd" method="post">
		旧密码:<input type="password" name="oldpwd">
		<br><br>
		新密码:<input type="password" name="newpwd">
		<br><br>
		<input type="submit">
	</form>
	<br><br>
	${tishi }
</body>
</html>