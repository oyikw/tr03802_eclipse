<%@page import="java.util.Random"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response返回文本</title>
</head>
<body>

	<%!
        private String rndString(){
            Random rnd = new Random();
            String x = "";
            for(int i = 0;i < 4;i++){
                x += rnd.nextInt(10);
            }
            return x;
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
        g.setColor(Color.white);	
        g.fillRect(0, 0, 100, 40);
        //设置字体颜色为黑色
        g.setColor(Color.black);
        //设置字体
        g.setFont(new Font("黑体",Font.BOLD,16));
        //画文字
        g.drawString(rndString(), 20, 25);
        //输出到浏览器
        ImageIO.write(bi, "png", response.getOutputStream());
        //释放资源
        g.dispose();
        out.clear();
        out = pageContext.pushBody();
    %>
</body>
</html>
