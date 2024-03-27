package saying.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;

@WebServlet(urlPatterns = "/saying/insert2")
public class InsertSayingServlet2 extends HttpServlet{
	private SayingDAO sayingDAO = new SayingDAO();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获得用户输入的留言
		String user = request.getParameter("user");
		String content = request.getParameter("content");
		//保存留言
		sayingDAO.insert(user, content);
		//跳转到留言列表
		response.sendRedirect("ListServlet");
	}
}
