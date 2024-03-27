<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="pjf" value="0" />
	<c:set var="nn" value="0"/>
	<table border="1">
		<tr>
			<td>姓名</td>
			<td>班级</td>
			<td>年龄</td>
			<td>成绩</td>
		</tr>
		<c:forEach items="${list}" var="v">
	    <tr>
	        <td>${v.name}</td>
	        <td>${v.clas}</td>
	        <td>${v.age}</td>
	        <td>
	        	<c:choose>
		        	<c:when test="${v.cj lt 60}">
		                <p style="color:red">${v.cj}</p>
		        	</c:when>
		        	<c:otherwise>
		        		<p>${v.cj }</p>
		        	</c:otherwise>
	            </c:choose>
	        </td>
	    </tr>
	    <c:set var="pjf" value="${pjf + v.cj }" />
	    <c:set var="nn" value="${nn + v.age }" />
	</c:forEach>
	</table>
	<p>平均分: ${pjf div fn:length(list)}</p>
	<p>平均年龄: ${nn div fn:length(list)}</p>
</body>
</html>