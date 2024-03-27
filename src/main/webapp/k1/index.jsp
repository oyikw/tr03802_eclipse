<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		private int x = 100;
		
		public int mnl(int a,int b){
			return a + b;
		}
	%>
	<%= mnl(10,20) %>
	现在时间：<%= new Date().toLocaleString() %>
	<br>
	<%
		int a = 10;
		int b = 20;
		int c = a + b;
		out.println(c);
		
	%>
	<!-- HTML注释 -->
	<%-- jsp注释 --%>
</body>
</html>