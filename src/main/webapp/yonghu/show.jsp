<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery.min.js"></script>
<style>
	.he{
		height:30px;
	}
</style>
<script type="text/javascript">
	$(function(){
		$("#say").click(function(){
			$.getJSON("ylist",function(v){
				sele(v);
			});
		});
		$(document).on('click','.btn',function(){
			var id = $(this).prop("name");
			var val = {"id":id};
			$.getJSON("dele",val,function(v){
				sele(v);
			}); 
		});
		
		function sele(v){
			$("#result").empty();
			for(i = 0; i < v.length; i++){
				var div = $("<div>");
				$("#result").append(div);
				div.addClass("he");
				
				
				var span2 = $("<span>");
				span2.html(v[i].yname);
				span2.appendTo(div);
				
				var btn = $("<button>");
				btn.text("删除");
				btn.css("float","right");
				btn.prop("name",v[i].yid);
				btn.appendTo(div);
				btn.addClass("btn");
			}
		}
	});
</script>
</head>
<body>
	<button id="say">获取留言</button>
	<div id="result"></div>
</body>
</html>
