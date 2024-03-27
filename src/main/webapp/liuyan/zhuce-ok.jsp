<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.mysql.cj.xdevapi.PreparableStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.prefs.Preferences"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
		String checkSql = "SELECT * FROM user_ WHERE name_ = ?";
		PreparedStatement checkStmt = conn.prepareStatement(checkSql);
		checkStmt.setString(1, name);
		ResultSet rs = checkStmt.executeQuery();
		
		if(rs.next()) {
			out.print("用户名已经存在,请重新<a href='zhuce.jsp'>注册</a>");
		} else {
			// 执行插入操作
			String insertSql = "INSERT INTO user_(name_, pwd_, time_) VALUES (?, ?, now())";
			PreparedStatement stmt = conn.prepareStatement(insertSql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			stmt.executeUpdate();
			stmt.close();
			

			response.sendRedirect("login.jsp");
		}
		
		rs.close();
		checkStmt.close();
		conn.close();

	%>
</body>
</html>