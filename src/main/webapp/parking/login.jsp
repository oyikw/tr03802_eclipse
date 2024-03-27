<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	body{
		background-image:url("image/nv.png");
		background-repeat:no-repeat;
		background-size:cover;
	}
	#login_hz {
	    width: 500px;
	    height: 500px;
	   	background-color:white;
	    border:none;
	    margin-left: 65%;
	    margin-top: 18%;
	    border-radius:5px;
	}
	.kk {
	    background-repeat: no-repeat;
	    background-position: 10px center;
	    padding-left: 50px;
	    width: 334px;
	    height: 40px;
	    border-radius: 8px;
	    background-size: 20px;
	    border: 1px solid gray;
	    background-color: rgb(232,240,253);
		margin-top:5%;
		margin-left:12%;
	    font-size: 18px;
	}
	#name{
	    background-image: url("image/用户.png");
	    margin-top:40%;
	}
	#pwd{
	    background-image: url("image/密码.png");
	}
	#but{
	    width: 384px;
	    height:40px;
	    background-color:rgb(64,158,254);
	    border:none;
	    color:white;
	    border-radius:5px;
	    cursor: pointer;
	    position:relative;
	    transition: background-color 0.3s ease;
		margin-top:8%;
		margin-left:12%;
	}

	#but:hover {
	    background-color: black;
	}
	#tc{
	    color: white;
	    font-size: 53px;
	    top: 100px;
	    margin-left: 38%;
	    position: relative;
	}
	#ts {
	    position: relative;
	    top: 202px;
	    left: 62px;
	    color: red;
	    font-size: 18px;
	}
</style>
<body>
	<p id="tc">登录---停车系统</p>
	<div id="login_hz">
		<form  action="log" method="post">
			<p id="ts">${tishi }</p>
			<input name="name" required id="name" class="kk">
			<input type="password" required name="pwd" id="pwd" class="kk">
			<br>
		 	<input type="submit" value="登录" id="but">
		</form>
	</div>
</body>
</html>