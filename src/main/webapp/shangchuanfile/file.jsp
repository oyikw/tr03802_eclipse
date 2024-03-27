<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="sc" method="post" enctype="multipart/form-data">
		选择照片：<input name="photo" type="file"><br>
		图片描述：<input name="desc">
		<input type="submit" value="上传">
	</form>
	<img alt="" src="../images/${photo }">
</body>
</html>