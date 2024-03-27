<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<style>
    button {
        width: 200px;
        height: 100px;
        background-color: black;
        font-size: 20px;
        transition: background-color 0.3s, color 0.3s;
    }
    
    a {
        text-decoration: none;
        color: white;
    }
    
    button:hover {
        background-color: white;
    }
    
    button:hover a {
        color: black;
    }
</style>
	
</head>
<body>
	<h1>选择操作</h1>
	<button><a href="weihu.jsp">个人信息维护</a></button>
	<button><a href="insertTime.jsp">记录用药时间</a></button>
	<button><a href="all">查看用药记录</a></button>
	<button><a href="zhiding.jsp">查看指定月份</a></button>
	<button><a href="lonck.jsp">设置提醒用药时间</a></button>
	
</body>
</html>