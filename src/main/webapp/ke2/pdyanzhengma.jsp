<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script>
		function refresh(){
			var img = document.querySelector("#imgc");
			
		}
	</script>
<body>
	<h1>登录</h1>
	<form action="panduan.jsp" method="post"
		onsubmit="return validateForm()">
		用户名：<input id="name" name="name"><br> 密码：<input
			type="password" id="pwd" name="pwd"><br> 验证码：<img
			src="yanzhengma.jsp" id="imgc" onclick="refresh()" /> <input
			type="submit" value="登录">
	</form>
	<%
    	request.setCharacterEncoding("utf-8");
    	String code = request.getParameter("code");
    	String rnd = (String)session.getAttribute("code");
    	if(!rnd.equals(code)){
    		out.print("验证码错误");
    	}else{
    		out.print("成功");
    	}
    %>
</body>
</html>