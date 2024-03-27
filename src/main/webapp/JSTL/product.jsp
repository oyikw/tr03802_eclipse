<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<style>
	li{
		float: left;
		width:300px;
		text-align:center;	
		list-style-type:none;
	}
	.name{
		font-size:20px;
		font-weight: bold;
	}
	.price{
		font-size:20px;
		color:red;
	}
	.pj{
		font-size:16px;
		color:gray;
	}
	#tp{
		width:300px;
	}
</style>
<body>	
	<ul>
		<c:forEach items="${list }" var="v">
			<li>
				<div><img id="tp" src="${v.img }"></div>
				<p class="name">${v.pname}</p>
				<p class="pj">${v.ms}</p>
				<p class="price">￥${v.price}</p>
				<p class="pj">${v.count}人评价&nbsp&nbsp&nbsp&nbsp&nbsp${v.like}% &nbsp好评</p>
			</li>
		</c:forEach>
	</ul>
</body>
</html>