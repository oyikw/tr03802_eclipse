<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	我喜欢的明星有:
	<%
		request.setCharacterEncoding("utf-8");
		String[] stars = request.getParameterValues("star");
		for(String x:stars){
			out.write(x);
		}
	%>
</body>
</html>