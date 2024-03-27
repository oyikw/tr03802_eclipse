<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: <%= rndColor() %>;">
	<%!
			public String rndColor(){
				int a = (int)(Math.random()*255);
				int b = (int)(Math.random()*255);
				int c = (int)(Math.random()*255);
				//反回对应的十六进制字符串Integer.toHexString()
		        String color = "#" + Integer.toHexString(a) + Integer.toHexString(b) + Integer.toHexString(c);
				return color;
			}
		%>
</body>
</html>