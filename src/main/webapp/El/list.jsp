<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> list = new ArrayList();
		list.add("中国");
		list.add("美国");
		list.add("外国");
		list.add("地国");
		request.setAttribute("li", list);
		
		Map<String,Integer> map = new HashMap();
		map.put("a", 100);
		map.put("b", 200);
		map.put("c", 300);
		request.setAttribute("ma", map);
	%>
	${li}
	${li[1]}
	${ma }
	${ma.a }
	${ma['c'] }
	
	${not true }
	${5 ge 9 }
	
	${3 + 5 eq 8 }
	
	
	${param.name}
</body>
</html>