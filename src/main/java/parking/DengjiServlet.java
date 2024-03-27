package parking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parking.dao.dengjiDAO;

@WebServlet(urlPatterns = "/parking/dengji")
public class DengjiServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dengjiDAO dj = new dengjiDAO();
		req.setAttribute("list", dj.query());
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
