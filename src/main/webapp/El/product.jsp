<%@page import="el.Product"%>
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
		Product p = new Product(1, "iPhone 13", "2.png", 6999.00, "China", "Blue", "128GB");
		request.setAttribute("pro", p);
	%>
	
	<p>pid:${pro.pid }</p>
	<p>pname:${pro.pname }</p>
	<p>image:<img src="${pro.image }"></p>
	<p>price:${pro.price }</p>
	<p>addres:${pro.addres }</p>
	<p>color:${pro.color }</p>
	<p>guige:${pro.gg }</p>
</body>
</html>