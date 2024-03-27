<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置时间</title>
</head>
<body>
	<h1>设置用药时间提醒</h1>
	<form action="lock" method="post">
		<label>用药时间：</label>
		选择用药时间：<input type="datetime-local" name="ytime" required><br><br>
		<input type="submit" value="添加">
	</form>
		<p>${tis }</p>
	<a href="home.jsp">返回</a>
</body>
</html>