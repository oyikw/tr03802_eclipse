<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言</title>
</head>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#f").submit(function(){
			if($(".content").val().trim().length > 0 && $(".user").val().trim().length > 0){
				return true;
			}else{
				alert("请输入留言内容和留言人姓名");
				return false;
			}
		})
	})	
</script>
<style>
	*{
		font-size:14px;
	}
	.content{
		width:400px;
		height:100px;
	}
</style>
<body>
	<h1>给网站留言</h1>
	<form action="insert" method="post" id="f">
		<div>
			内容:
		</div>
		<div>
			<textarea class="content" name="content"></textarea>
		</div>
		<div>
			留言人:<input name="user" class="user">
		</div>
		<div>
			<input type="submit" value="提交">
		</div>
	</form>
</body>
</html>