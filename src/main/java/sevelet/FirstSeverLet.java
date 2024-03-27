package sevelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//2.0定义方法，需要写配置
public class FirstSeverLet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		
		//将数据保存到request中
		req.setAttribute("name", name);
		//转到jsp
		req.getRequestDispatcher("setvlet/r.jsp").forward(req, resp);
		
		
//		resp.setContentType("text/html;charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		out.print(name+",你好");
//		out.close();
	}
}
