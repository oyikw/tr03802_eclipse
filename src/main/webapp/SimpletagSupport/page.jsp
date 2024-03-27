<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="x" uri="tolo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.lzh_p a{
		text-decoration:none;
		margin:5px 8px;
		padding:3px 5px;
		border:1px solid black;
		color:black;
	}
	table tr td{
		 width:130px;
		 text-align:center;
	}
	table tr{
		height:40px;
	}
	table{
		margin-bottom:30px;
	}
	select{
		width:50px;
	}
</style>
<body>
	<form action="page" method="get">
		<input type="search" name="sea">
		<input type="hidden" name="curpage" value="1">
		<input type="hidden" name="pagesize" value="2">
		<input type="submit" value="查询"> 
	</form>
	<br><br>
	
	<table border="1px" cellspacing="0px" >
		<tr>
			<th>id</th>
			<th>产品名称</th>
			<th>单价</th>
		</tr>
		<c:forEach items="${list }" var="p">
			<tr>
				<td>${p.pid }</td>
				<td>${p.pname }</td>
				<td>${p.prive }</td>
			</tr>
		</c:forEach>
	</table>
	
	<x:page controller="page" pagesize="2" total="${total}" curpage="${param.curpage}" where="sea=${sea}"/>
	
	
</body>
</html>

