package sevelet;

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

@WebServlet(urlPatterns = "/img")
public class HebingImageSeverLet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ServletContext application = this.getServletContext();
		
		String img1 = application.getRealPath("/image/tp.png");
		String img2 = application.getRealPath("/image/tp2.png");
		System.out.println(img1);
		
		Image tp1 = ImageIO.read(new File(img1));
		Image tp2 = ImageIO.read(new File(img2));

		int width1 = tp1.getWidth(null);
		int height1 = tp1.getHeight(null);
		int width2 = tp2.getWidth(null);
		int height2 = tp2.getHeight(null);

		String val = req.getParameter("tp");
		BufferedImage buf = null;
		if(val.equals("sp")) {
			buf = new BufferedImage(width1, height1 + height2, BufferedImage.TYPE_INT_RGB);
			Graphics g = buf.getGraphics();
			g.drawImage(tp1, 0, 0, width1, height1, null);
			g.drawImage(tp2, 0, height1, width1, height2, null);
		}else {
			buf = new BufferedImage(width1+width2, height1, BufferedImage.TYPE_INT_RGB);
			Graphics g = buf.getGraphics();
			g.drawImage(tp1, 0, 0, width1, height1,  null);
			g.drawImage(tp2, width1, 0, width2, height1,  null);
		}
		resp.setContentType("image/png");
		ImageIO.write(buf, "png", resp.getOutputStream());
	}
}
