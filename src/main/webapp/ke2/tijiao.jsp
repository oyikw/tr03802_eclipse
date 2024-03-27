<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="tijaioj.jsp" method="post">
		用户名：<input name="name" /><br> 密码：<input type="password"
			name="pwd" /><br> 性别：男：<input type="radio" value="男" name="sex" />女：<input
			type="radio" value="女" name="sex" /><br> 爱好：<input
			type="checkbox" name="ah" value="运动" />运动 <input type="checkbox"
			name="ah" value="音乐" />音乐 <input type="checkbox" name="ah" value="上网" />上网
		<input type="checkbox" name="ah" value="购物" />购物 <input
			type="checkbox" name="ah" value="旅游" />旅游<br> 学历：<input
			name="xueli" /><br> 自我介绍：<input name="zwjs" /><br> <input
			type="submit" value="提交">
	</form>
</body>
</html>