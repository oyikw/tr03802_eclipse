<%@page import="java.util.Scanner"%>
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
        public boolean suShu(int s){
            if(s <= 1){
                return false;
            }
            for(int i = 2;i <= s / 2;i++){ // 修改判断条件为 i <= s / 2
                if(s % i == 0){
                    return false;
                }
            }
            return true;
        }
    %>
	<%
        int num = 5;
        String output = suShu(num) ? (num + "是素数") : (num + "不是素数");
    %>

	<%= output %>
</body>
</html>
