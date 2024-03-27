<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="stu" method="post">
		<input type="submit" value="提交">
	</form>
	<p>Name: ${stu['13812345678'].name}</p>
    <p>ID: ${stu['13812345678'].uid}</p>
    <p>Phone: ${stu['13812345678'].tel}</p>
    <p>Idcard: ${stu['13812345678'].idcard}</p>
    <p>Age: ${stu['13812345678'].age}</p>
    <p>Image: <img src="${stu['13812345678'].tx}" style="width:130px"></p>
    
</body>
</html>