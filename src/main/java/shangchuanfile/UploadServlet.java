package shangchuanfile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = "/shangchuanfile/sc")
@MultipartConfig
public class UploadServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("photo");
		//获取文件名
		String dis = part.getHeader("content-disposition");
		String filename = dis.split(";")[2].split("=")[1].replaceAll("\"", "");
		//获取扩展名
		int pos = filename.lastIndexOf('.');
		String ext = filename.substring(pos);
		//随机生成一个文件名，扩展名不变
		String rndName = UUID.randomUUID().toString().toUpperCase();
	
		//获取发布后的根目录
		String root = this.getServletContext().getRealPath("");
		
		//创建image子文件夹
		File images = new File(root,"images");
		if(!images.exists()) {
			images.mkdirs();
		}
		
		//根目录+子目录+随机名字+后缀名
		String photo = root + "/images/" + rndName + ext;
		part.write(photo);
		
		req.setAttribute("photo",rndName + ext);
		req.getRequestDispatcher("file.jsp").forward(req, resp);
	}
}
