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
	application.setAttribute("d",40);
		pageContext.setAttribute("a",10);
		request.setAttribute("b",20);
		session.setAttribute("c",30);
		session.setAttribute("a",30);
		int e = 50;
	%>
	
	<%-- <%=
		pageContext.getAttribute("a")
	%> --%>
	${a}, ${b}, ${c}, ${d}
	${requestScope.a}, ${applicationScope.b}, ${pageContextScope.c}, ${sessionScope.d}
</body>
</html>