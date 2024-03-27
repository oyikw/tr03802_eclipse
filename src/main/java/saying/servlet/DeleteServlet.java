package saying.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;


/**
 * Servlet implementation class DeleteBatchServlet
 */
@WebServlet("/saying/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SayingDAO sayingDAO = new SayingDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//?sid=1&sid=2&sid=3&sid=4
		String[] sids = request.getParameterValues("sid");
		sayingDAO.deleteBatch(sids);
		request.getRequestDispatcher("ListPageServlet?curpage=1&pagesize=3&")
			.forward(request, response);
	}


}