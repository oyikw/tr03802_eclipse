<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		/* $.get("ListServlet2",function(v){
			$("#result").html(v);
		}); */
		$("#say").click(function(){
			$.getJSON("ListServlet2",function(v){
				for(i = 0;i < v.length;i++){
					var div = $("<div>");
					$("#result").append(div);

					var span1 = $("<span>");
					span1.css("float","right");
					span1.html(v[i].stime);
					span1.appendTo(div);
					
					var span2 = $("<span>");
					span2.html(v[i].scontent);
					span2.appendTo(div);
				}
			});
		});
	});
</script>
</head>
<body>
	<%= new Date() %>
	
	<button id="say">获取留言</button>
	<div id="result"></div>
</body>
</html>