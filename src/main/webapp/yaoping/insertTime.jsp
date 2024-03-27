<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>记录用药</title>
</head>
<body>
	<h1>记录本次用药时间</h1>
	<form action="jltime" method="post">
	 <input type="hidden" name="uid" value="${uid}">
		<label>用药时间：</label>
		<!-- required 必填 -->
		<input type="datetime-local" name="ytime" required><br><br>
		药物名称：<input name="ytype" required><br><br>
		<input type="submit" value="添加记录">
	</form>
		<p>${tis }</p>
	<a href="home.jsp">返回</a>
</body>
</html>