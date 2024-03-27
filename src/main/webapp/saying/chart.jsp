<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图表统计</title>
<style type="text/css">
	.c{
		height: 20px;
		background: red;
		margin: 10px 0px;
		color: white;
	}
</style>
</head>
<body>
	<h1>统计每天的留言数</h1>
	
	<c:forEach items="${list }" var="a">
		<div style="width:${400*a.count/total}px;" class="c">
			${a.date}(${a.count}条)
		</div>
	</c:forEach>
</body>
</html>