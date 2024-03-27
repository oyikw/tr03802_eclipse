<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl</title>
</head>
<body>
	<div>
		<c:if test="${param.age ge 18}" var="v">
			你是成年人
		</c:if>
		<c:if test="${not v }">
			你是未成年人
		</c:if>	
	</div>
	<div>
		<c:choose>
			<c:when test="${param.age le 12 }">你是儿童</c:when>
			<c:when test="${param.age lt 18 }">你是少年</c:when>
			<c:when test="${param.age ge 18 }">你是成年</c:when>
			<c:otherwise>
				你是老年
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<c:forEach begin="1" end="10" step="1" var="x" >
			${x }
		</c:forEach>
	</div>
	
	<%
		List<String> list = new ArrayList();
		list.add("周围");
		list.add("少龙");
		list.add("九十");
		pageContext.setAttribute("list",list);
	%>
	<div>
		<c:forEach items="${list }" var="x" varStatus="vs">
			${x }/${vs.index }/${vs.count }<br>
		</c:forEach>
	</div>
	<div>
		<c:forTokens items="abc,as,sa,da,ads,fd" delims="," var="x">
			${x }<br>
		</c:forTokens>
	</div>
	<br>
	<div>
		<c:url var="u" value="http//:www.baidu.com">
				<c:param name="id" value="4"></c:param>
				<c:param name="name" value="join"></c:param>
		</c:url> 
		${u }
	</div>
	
	<%-- <c:redirect url="http://www.baidu.com"/> --%>
	

</body>
</html>