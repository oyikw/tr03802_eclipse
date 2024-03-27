<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
<style>
	#top_hz{
		width:100%;
		height:100px;
	}
	#seacp {
	    width: 180px;
	    height: 30px;
	    border: 1px solid gray;
	    border-radius: 9px;
	    padding-left: 20px;
	    margin-left: 10px;
	}
	#seanav {
	    padding-top: 32px;
	    padding-left: 600px;
	}
	#seabut{
		width:100px;
		height:30px;
		margin-left:30px;
	}
	#seabotm{
		width:100%;
		margin-top:75px;
	}
	#tab_td td{
		text-align:center;
	}
	#sz_hz {
	    width: 600px;
	    height: 400px;
	    background-color: red;
	    margin-left: 524px;
	    margin-top: 200px;
	}
	#ewm {
		width:300px;
	    background-color:#EEEEEE;
		height:300px;
	    margin-top: 200px;
	    margin-left: 670px;
	}
	#fangke_ewm{
		background:white;
		display:none;
	}
	#xiaz {
	    width: 134px;
	    height: 57px;
	    font-size: 16px;
	    background: #EEEEEE;
	    margin-top: 150px;
	    margin-left: 1405px;
	    border-radius: 16px;
	    border: 2px solid black;
	}
</style>
</head>
<body>
	<div class="container">
		<div id="left_hz">
			<ul id="lul">
				<h1 style="color:white; margin-left:25px">停车系统</h1>
				<li><a href="#" onclick="showContent('apply')">访客登记</a></li>
				<li><a href="#" onclick="showContent('fangke_lb')">访客列表</a></li>
				<li><a href="#" onclick="showContent('fangke_sz')">访客设置</a></li>
				<li><a href="#" onclick="showContent('来访事由管理')">来访事由管理</a></li>
				<li><a href="#" onclick="showContent('审核')">审核</a></li>
				<li><a href="#" onclick="showContent('fangke_ewm')">访客二维码</a></li>
			</ul>
		</div>
		
		<div id="apply" class="content">
		  <div class="title">
		      访客申请
		  </div>
		  <form action="apply" method="post">
		      <div id="sq_form">
		          <nav class="na">车牌号<input name="cp" class="put" required"></nav>
		          <nav class="na">手机号<input name="tel" class="put" required></nav>
		          <nav class="na">开始时间<input name="sta_time" type="datetime-local" class="put" required style="margin-left:5px"></nav>
		          <nav class="na">结束时间<input name="stop_time" type="datetime-local" class="put" required style="margin-left:5px"></nav>
		          <nav class="na">来访事由 <select name="shiyou" class="put"style="margin-left:0px;text-align:center;padding-left:0px;width:312px">
							<c:forEach var="sname" items="${shiyouList}">
								<option value="${sname}">${sname.getSname()}</option>
							</c:forEach>
						</select>
					</nav>
		          <nav class="na">进出权限<select name="qx" class="put"style="margin-left:5px;text-align:center;padding-left:0px;width:312px">
							<c:forEach var="sname" items="${qxlist}">
								<option value="${sname}">${sname.getSname()}</option>
							</c:forEach>
						</select>
					</nav>
				   <nav class="na">备注<textarea class="put" name="bz" style="width:310px"></textarea></nav>
		        <input type="submit" class="sub" style="width: 100px; height: 40px; margin-left: 323px;margin-top: 42px;background-color:white;border:1px solid gray ">
		        </div>
		    </form>
		</div>

		
		<div id="fangke_lb" class="content">
			<div class="title">
				访客列表
			</div>
			<form action="fangke" method="post">
				<div id="top_hz">
					<nav id="seanav">
						车牌号<input type="text" required id="seacp" name="cph">
						<input type="submit" value="搜索" id="seabut">
					</nav>
					<nav id="seabotm">
						<div id="search">
							<table style="width:95%;border:1px black solid">
						    	<tr>
							    	<th><input type="checkbox"></th>
								    <th>车牌号</th>
								    <th>手机号</th>
								    <th>来访事由</th>
								    <th>申请时间</th>
								    <th>开始时间</th>
								    <th>结束时间</th>
								    <th>状态</th>
								    <th>备注</th>
								    <th>操作</th>
						    	</tr>
						    <c:forEach items="${list}" var="p">
						    	<form  id="form${p.visit_id}" method="post">
							        <tr id="tab_td">
							          <td><input class="row-checkbox" type="checkbox"></td>
							          <td>${p.cars_number}</td>
							          <td>${p.visit_phone}</td>
							          <td>${p.reason_text}</td>
							          <td>${p.reg_time}</td>
							          <td>${p.start_time}</td>
							          <td>${p.end_time}</td>
							          <td><span data-state="${p.state}" class="state">${p.state}</span></td>
							          <td>${p.notes}</td>
							          <td>
							            <input class="delete-button" type="button" value="删除" name="delete" onclick="getVisitId(${p.visit_id})">
							            <input class="audit-button" type="button" value="审核" name="shenhe">
							          </td> 
							        </tr>
						    	</form>
						    </c:forEach>
						  </table>
							<x:page controller="page" pagesize="5" total="${total}" curpage="${param.curpage}" where="${where}"></x:page>
						</div>
					</nav>
				</div>
				<hr>
			</form>
		</div>
		
		<div id="fangke_sz" class="content">
			<div class="title">
				访客设置
			</div>
			<form id="sz_hz" action="fangke_sz" method="post">
				认证业主<input>
			</form>
		</div>
		
		<div id="fangke_ewm" class="content">
			<div class="title">
				访客二维码
			</div>
			<form action="fangke_ewm" method="get">
				<div id="ewm" style="display: flex; justify-content: center; align-items: center;">
				    <img src="ewm" id="tp">
				</div>
				<input type="button" value="下载" id="xiaz">
			</form>
		</div>	
		
	</div>
</body>
<script>
function showContent(contentName) {
	  var contents = document.getElementsByClassName('content');
	  var contentToShow = document.getElementById(contentName);
	  for (var i = 0; i < contents.length; i++) {
	    if (contents[i] === contentToShow) {
	    	 contents[i].style.display = 'block';
	    } else {
	      	contents[i].style.display = 'none';
	    }
	  }
	}

</script>
</html>
