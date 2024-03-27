package shangchuanfile.Servlet;

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

import shangchuanfile.dao.UseraDAO;


@WebServlet(urlPatterns = "/shangchuanfile/change")
@MultipartConfig
public class PhotoServlet extends HttpServlet{
	private UseraDAO dao = new UseraDAO();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("photo");
		String dis = part.getHeader("content-disposition");
		String filename = dis.split(";")[2].split("=")[1].replaceAll("\"", "");
		int pos = filename.lastIndexOf('.');
		String ext  = filename.substring(pos);
		String rndName = UUID.randomUUID().toString().toUpperCase();
		String root = this.getServletContext().getRealPath("");
		File images = new File(root,"images");
		if(!images.exists()) {
			images.mkdirs();
		}
		
		String photo = root + "/images/" + rndName + ext;
		part.write(photo);
		
		req.setAttribute("photo",rndName + ext);
		
        String name = (String) req.getSession().getAttribute("name");
        String tel = (String) req.getSession().getAttribute("tel");
        String addres = (String) req.getSession().getAttribute("addres");
		
        Integer userId = (Integer) req.getSession().getAttribute("uid");
        dao.updateUser(photo,userId);
        
		req.setAttribute("name", name);
		req.setAttribute("tel", tel);
		req.setAttribute("addres", addres);
		req.setAttribute("photo", photo);
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
