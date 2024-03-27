package saying.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;

/**
 * Servlet implementation class ListPageServlet
 */
@WebServlet("/saying/ListpageServlet")
public class ListpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO sayingDAO = new SayingDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得请求参数
		int curpage = Integer.parseInt(request.getParameter("curpage"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		
		//2、调用dao
		Map<String, Object> map = sayingDAO.queryByPage(curpage, pagesize);
		request.setAttribute("map", map);
		
		//3、跳转
		request.getRequestDispatcher("list-page.jsp")
			.forward(request, response);
	}

}








