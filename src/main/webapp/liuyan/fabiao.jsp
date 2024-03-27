<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>选择发表或者查看留言</h1>
	<%
		if(session.getAttribute("name") == null){
			out.print("对不起，请先<a href='login.jsp'>登陆</a>！");
		}else{
	%>
	<form action="fabiao-ok.jsp" method="post">
		留言：<input name="text"> <input type="submit" value="提交">
	</form>

	<!-- 跳转到显示所有用户留言的页面 -->
	<form action="select.jsp" method="get">
		<input type="submit" value="显示所有用户留言">
	</form>

	<!-- 跳转到只显示当前用户留言的页面 -->
	<form action="dangq.jsp" method="get">
		<input type="submit" value="只显示当前用户留言">
	</form>
	<% } %>
</body>
</html>
