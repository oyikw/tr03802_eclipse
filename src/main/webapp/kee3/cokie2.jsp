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
		//向客户端写入cookie
			Cookie[] cs = request.getCookies();
			if(cs != null){
				for(Cookie x:cs){
					out.print(x.getName() + "=" + x.getValue());
					out.print("<br>");
				}
			}
	%>
</body>
</html>
