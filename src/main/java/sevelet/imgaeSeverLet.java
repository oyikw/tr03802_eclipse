package sevelet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/image")
public class imgaeSeverLet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1、读取图片
		//获取工程路径
		ServletContext application = this.getServletContext();
		String img = application.getRealPath("/image/tp.png");
		
		//将图片文件加载到内存
		Image image = ImageIO.read(new File(img));
		//获得图片的宽度和高度
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		
		
		//2、加水印
		//创建内存图
		BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics g = buf.getGraphics();
		//画图片
		g.drawImage(image, 0, 0, width, height, null);
		//画文字
		String text = req.getParameter("text");
		//指定颜色
		g.setColor(Color.black);
		g.setFont(new Font("楷体",Font.BOLD,40));
		g.drawString(text, 10, 50);
		
		//3、将带水印图片显示到浏览器
		resp.setContentType("image/png");
		ImageIO.write(buf, "png", resp.getOutputStream());
		
		
	}
}
