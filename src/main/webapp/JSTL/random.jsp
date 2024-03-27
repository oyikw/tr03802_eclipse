<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>随机数</title>
</head>
<body>
	<%
		int rnd = (int)(Math.random() * 10000);
		request.setAttribute("rnd", rnd);
	%>
    <c:set var="rnd" value="${rnd}"/>
        <c:choose>
            <c:when test="${rnd % 8 == 0}">一等奖</c:when>
            <c:when test="${rnd % 6 == 0}">二等奖</c:when>
            <c:when test="${rnd % 4 == 0}">三等奖</c:when>
            <c:otherwise>
                谢谢惠顾
            </c:otherwise>
        </c:choose>
</body>
</html>
