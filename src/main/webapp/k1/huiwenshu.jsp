<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		public boolean mnl(String a){
			if(a == null || a.length() == 0){
				return true;
			}
			int sta = 0,last = a.length()-1;
			while(sta < last){
				if(a.charAt(sta) != a.charAt(last)){
					return false;
				}
				sta++;
				last--;
			}
			return true;
		}
	%>
	判断是否为回文数
	<table border=1 width=300 height=200 cellspacing=0>
		<tr>
			<td>字符串</td>
			<td>是否回文</td>
		</tr>
		<tr>
			<td>12321</td>
			<td><%= mnl("12321")?"是":"否" %></td>
		</tr>
		<tr>
			<td>abac</td>
			<td><%= mnl("abac")?"是":"否" %></td>
		</tr>
		<tr>
			<td>testest</td>
			<td><%= mnl("testest")?"是":"否" %></td>
		</tr>
		<tr>
			<td>qwerrwq</td>
			<td><%= mnl("qwerrwq")?"是":"否" %></td>
		</tr>
	</table>
</body>
</html>