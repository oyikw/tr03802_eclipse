<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="list.Store"%>
<%@page import="list.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看</title>
</head>
<body>
	<h1><%=session.getAttribute("name") == null ? "游客" : session.getAttribute("name") %>，欢迎购物！</h1>
	<%
		String sql = "SELECT * FROM products ORDER BY pid  DESC";
		//加载数据库驱动 
		Class.forName("com.mysql.cj.jdbc.Driver");
		//获取连接字符串
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
	 %>	
		<div><%=rs.getString("pname") %></div>
		<div>价格￥:<%=rs.getDouble("price") %></div>
		<div><a href="add.jsp?pid=<%=rs.getInt("pid")%>">添加至购物车</a><hr></div>
	<%
		}
	%>
</body>
</html>