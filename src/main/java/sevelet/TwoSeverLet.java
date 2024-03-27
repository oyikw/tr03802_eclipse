package sevelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//3.0定义方法
@WebServlet(urlPatterns = "/TwoSeverLet")
public class TwoSeverLet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		
		
		//request
		//response	
		HttpSession session = req.getSession();
		ServletContext application = this.getServletContext();
		
		
		PrintWriter out = resp.getWriter();
		out.print("Hellow");
		out.close();
	}
}
