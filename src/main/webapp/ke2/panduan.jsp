<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>处理登录</title>
</head>
<body>
	<%
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        if (name != null && pwd != null && name.equals("trkj")) {
            session.setAttribute("name", name);
            session.setAttribute("pwd", pwd);
            response.sendRedirect("OK.jsp?name=" + name + "&pwd=" + pwd);
        } else {
            response.sendRedirect("error.jsp?error=1");
        }
    %>
</body>
</html>
