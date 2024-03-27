<%@page import="list.ShopCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>清空购物车</title>
</head>
<body>
	<%
		//从session中获取购物车对象
		ShopCart shopCart = (ShopCart)session.getAttribute("shopCart");
		//如果session中还没有购物车，则创建购物车
		if(shopCart == null){
			shopCart = new ShopCart();
		}
		
		//清空购物车
		shopCart.clear();
		
		//重定向到购物车
		response.sendRedirect("shopcat.jsp");
	%>
</body>
</html>