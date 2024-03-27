<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
		String sql = "select * from users where u_name=? and u_pwd=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, request.getParameter("name"));
		stmt.setString(2, request.getParameter("pwd"));
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			session.setAttribute("name", request.getParameter("name"));
			response.sendRedirect("shoop.jsp");
		}else{
			out.print("登陆失败，请重新<a href='login.jsp'>登陆</a>！");
		}
		rs.close();
		stmt.close();
		conn.close();
	%>
</body>
</html>