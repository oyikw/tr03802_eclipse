<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>选择星座</title>
</head>
<body>
	<form method="post" action="xingzuo.jsp">
		<h1>请选择星座</h1>
		<input type="radio" name="sele" value="by">白羊座<br> <input
			type="radio" name="sele" value="jn">金牛座<br> <input
			type="radio" name="sele" value="sz">双子座<br> <input
			type="radio" name="sele" value="jx">巨蟹座<br> <input
			type="radio" name="sele" value="shz">狮子座<br> <input
			type="radio" name="sele" value="cn">处女座<br> <input
			type="radio" name="sele" value="tc">天秤座<br> <input
			type="radio" name="sele" value="tx">天蝎座<br> <input
			type="radio" name="sele" value="ss">射手座<br> <input
			type="radio" name="sele" value="mx">摩羯座<br> <input
			type="radio" name="sele" value="sp">水瓶座<br> <input
			type="radio" name="sele" value="sy">双鱼座<br> <input
			type="submit" value="提交">
	</form>

	<%
    String sele = request.getParameter("sele");
    if (sele != null && !sele.isEmpty()) {
        switch(sele){
            case "by":
                response.sendRedirect("by.jsp");
                break;
            case "jn":
                response.sendRedirect("jn.jsp");
                break;
            case "sz":
                response.sendRedirect("sz.jsp");
                break;
            default:
                response.sendRedirect("error.jsp");
                break;
        }
    }
    %>
</body>
</html>
