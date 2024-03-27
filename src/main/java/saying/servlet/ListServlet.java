package saying.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;

/**
 * Servlet implementation class listServlet
 */
@WebServlet("/saying/ListServlet")
public class ListServlet extends HttpServlet {
	
	private SayingDAO sayingDAO = new SayingDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", sayingDAO.query());
		request.getRequestDispatcher("list-page.jsp").forward(request, response);
	}

}
