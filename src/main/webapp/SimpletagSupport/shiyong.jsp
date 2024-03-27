<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="x" uri="http://www.trkj.com/tr03802/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<x:date pattern="yyyy-MM-dd HH:mm:ss">服务器时间：</x:date>
	<x:for>renji<br></x:for>
	
	<%
		List list = new ArrayList();
			list.add("xxxx");
			list.add("bbb");
			list.add("123");
			list.add("xxxfax");
			pageContext.setAttribute("list", list);
	%>
	<x:iterator collection="${list}" item="cur">
		${cur}
	</x:iterator>
		
</body>
</html>