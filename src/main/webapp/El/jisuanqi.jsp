<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="jisuanqi" method="post" id="formm">
		<input name="a" value="${a }" id="a">
			<select name="o">
				<option value="+" ${o eq '+' ? 'selected' : '' }>+</option>
				<option value="-" ${o eq '-' ? 'selected' : '' } >-</option>
				<option value="*" ${o eq '*' ? 'selected' : '' }>*</option>
				<option value="/" ${o eq '/' ? 'selected' : '' }>/</option>
				<option value="%" ${o eq '%' ? 'selected' : '' }>%</option>
			</select>
		<input name="b" value="${b }" id="b">
		<input type="submit" value="=" id="dj">
	</form>
</div>
<div>
	${r} 
</div>
</body>
<script src="./jquery.min.js"></script>
<script>
	$(function(){
		$("#dj").click(function(){	
			var a = $("#a").val();
			var b = $("#b").val();
			var pattern = /^\d+$/;
			if(pattern.test(a) && pattern.test(b)){
				$("#formm").submit();
			}else{
				alert("请输入数字");
				$("#a").val("");
				$("#b").val("");
				return false;
			}
		})
	})
</script>
</html>