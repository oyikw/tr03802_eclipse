<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Random"%>
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
		Random rnd = new Random();
		String rndString() {
		    String x = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		    String sj = "";
		    for (int i = 0; i < 4; i++) {
			    int index = rnd.nextInt(x.length());
		        sj += x.charAt(index);
		    }
		    return sj;
		}
	%>

	<%
		//设置响应类型为图片
	    response.setContentType("image/png");
	    //创建一张空白的图片
	    BufferedImage bi = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
	    //获取画笔
	    Graphics g = bi.getGraphics();
	    //设置背景颜色为灰色
	    g.setColor(Color.PINK);	
	    g.fillRect(0, 0, 100, 40);
	    //设置字体颜色为黑色
	    g.setColor(Color.black);
	    //设置字体
	    g.setFont(new Font("黑体",Font.BOLD,20));
	    //画文字
	    String rnd = rndString();
	    session.setAttribute("code", rnd);
	    g.drawString(rnd, 20, 25);
	    //输出到浏览器
	    ImageIO.write(bi, "png", response.getOutputStream());
	    //释放资源
	    g.dispose();
	    out.clear();
	    out = pageContext.pushBody();
	%>

</body>
</html>
