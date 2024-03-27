<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	<%= request.getAttribute("name") == null?" ":request.getAttribute("name") %>
	<h1>注册</h1>
	<form id="bd" action="reg" method="post" id="formm">
		账户：<input name="name"><br>
		昵称：<input name="nickname"><br>
		密码：<input type="password" name="pwd"><br>
		电话号码：<input name="tel"><br>
		<input type="submit" value="注册" id="tj">
		
		<a href="login.jsp">登录</a>
	</form>
</body>
<script src="./jquery.min.js"></script>
<script>
	$(function(){
		$("#tj").click(function(){
			var name = $("input").eq(0).val();
			var nick = $("input").eq(1).val();
			var pwd = $("input").eq(2).val();
			var tel = $("input").eq(3).val();
			if(name == null || nick == null || pwd == null || tel == null){
				alert("请填写表单");
				return false;
			}
			if(name.length != 6){
				alert("账户必须为6位");
				return false;
			}else if(nick.length != 6){
				alert("昵称必须为6位");
				return false;
			}else if(pwd.length != 6){
				alert("密码必须为6位");
				return false;
			}else if(tel.length != 11){
				alert("电话号码必须为11位");
				return false;
			}else{
				$("#formm").submit();
			}
		})
	})
</script>
</html>