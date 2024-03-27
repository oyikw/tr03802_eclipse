<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
</head>
<body>
	<h1>用户信息</h1>
    <p>姓名: ${name}</p>
    <p>电话号码: ${tel}</p>
    <p>地址: ${addres}</p>
    <img src="../images/${photo }" alt="User Photo">
    <p>修改头像</p>
    <form action="change" method="post" enctype="multipart/form-data">
		选择照片：<input name="photo" type="file"><br>
		<input type="submit" value="修改">
	</form>
</body>
</html>