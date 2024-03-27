<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP负责输出结果</title>
</head>
<body>
	JSP负责输出结果，【${name}，你好！】
	[<%= request.getAttribute("name") %>,你好！]
</body>
</html>	