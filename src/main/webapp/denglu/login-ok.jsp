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
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
		String sql = "select * from user_ where name_=? and pwd_=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, request.getParameter("name"));
		stmt.setString(2, request.getParameter("pwd"));
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			response.sendRedirect("select.jsp");
			session.setAttribute("name", request.getParameter("name"));
		}else{
			out.print("登陆失败，请重新<a href='login.jsp'>登陆</a>！");
		}
		rs.close();
		stmt.close();
		conn.close();
	%>
</body>
</html>