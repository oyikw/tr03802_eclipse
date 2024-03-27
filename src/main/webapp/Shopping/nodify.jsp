<%@page import="list.ShopCart"%>
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
		int pid = Integer.parseInt(request.getParameter("pid"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		//从session中获取购物车对象
		ShopCart shopCart = (ShopCart)session.getAttribute("shopCart");
		//如果session中还没有购物车，则创建购物车
		if(shopCart == null){
			shopCart = new ShopCart();
		}
		
		shopCart.modify(pid, cnt);
		
		response.sendRedirect("shopcat.jsp");
	%>
</body>
</html>