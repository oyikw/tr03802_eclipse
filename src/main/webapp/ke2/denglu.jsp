<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<h1>登录</h1>
	<form action="panduan.jsp" method="post"
		onsubmit="return validateForm()">
		用户名：<input id="name" name="name"><br> 密码：<input
			type="password" id="pwd" name="pwd"><br> <input
			type="submit" value="登录">
	</form>

	<script>
        function validateForm() {
            var name = document.getElementById("name").value;
            var pwd = document.getElementById("pwd").value;

            if (name.trim().length === 0 || pwd.trim().length === 0) {
                alert("请输入用户名和密码！");
                return false; // 阻止表单提交
            }

            return true; // 允许表单提交
        }
    </script>
</body>
</html>
