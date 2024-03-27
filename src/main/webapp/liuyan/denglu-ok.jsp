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
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
        String sql = "select uid_, name_ from user_ where name_=? and pwd_=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, pwd);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            int uid = rs.getInt("uid_");
            session.setAttribute("uid_", uid);
            response.sendRedirect("fabiao.jsp");
            session.setAttribute("name", name);
        } else {
        	out.print("账号或密码错误，请重新<a href='login.jsp'>登陆</a>！");
        }
        stmt.close();
        conn.close();
    %>
</body>
</html>
