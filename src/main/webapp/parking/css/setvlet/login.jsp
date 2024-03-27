<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<%= request.getAttribute("name") == null?" ":request.getAttribute("name") %>
	<h1>登录</h1>
	<form action="login" method="post">
		用户名：<input name="name"><br>
		密码：<input type="password" name="pwd"><br>
		<input type="submit" value="登录" id="tj">
	</form>
	<a href="reg.jsp">注册</a>
	
</body>
<script src="./jquery.min.js"></script>
<script>
	$(function(){
		$("#tj").click(function(){
			var name = $("input").eq(0).val();
			var pwd = $("input").eq(1).val();
			if(name == null || pwd == null){
				alert("请填写表单");
				return false;
			}
			if(name.length != 6){
				alert("账户必须为6位");
				return false;
			}else if(pwd.length != 6){
				alert("密码必须为6位");
				return false;
			}else{
				$("#formm").submit();
			}
		})
	})
</script>
</html>