<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="me" uri="http://www.trkj.com/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言列表(分页)</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#db").click(function(){
			if(confirm("真的要删除吗？")){
				//拼参数：?sid=1&sid=2&sid=3&sid=4&
				var p = "?";
				$(":checkbox[name=sid]:checked").each(function(idx,v){
					p += "sid=" + $(v).val() + "&";
				});
				//alert(p);
				location = "DeleteBatchServlet" + p;
			}
		});
	});
</script>

<style type="text/css">
	*{
		font-size: 14px;
	}
	
	.tab{
		border-collapse: collapse;
		width: 700px;
		margin-bottom: 10px;
		margin-top: 10px;
	}
	
	.tab tr td{
		width: 150px;
		padding: 5px;
	}
	
	.tab tr td:first-child{
		text-align: center;
	}
	
	.tab tr td:nth-child(3){
		text-align: center;
	}
	
</style>

</head>
<body>
	<h1>留言</h1>
	<a href="insert.jsp">新留言</a>
	<a href="javascript:void(0)" id="db">批量删除</a>
	<c:forEach items="${map.list}" var="s">
		<table class="tab" border="1">
			<tr>
				<td style="width:100px;" rowspan="2">
					<input name="sid" type="checkbox" value="${s.sid }">
				</td>
				<td>留言人</td>
				<td>${s.suser}</td>
				<td>时间</td>
				<td><fmt:formatDate value="${s.stime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>
			<tr>
				<td>留言内容</td>
				<td colspan="3">${s.scontent}</td>
			</tr>
		</table>
	</c:forEach>
	
	<me:page controller="ListPageServlet" 
		pagesize="${param.pagesize}" 
		total="${map.total}" curpage="${param.curpage}"/>
</body>
</html>