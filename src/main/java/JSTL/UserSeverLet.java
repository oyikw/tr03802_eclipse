package JSTL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSTL/user")
public class UserSeverLet extends HttpServlet{
	private UserDAO dao = new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list = dao.queryAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("user.jsp").forward(req, resp);;
	}
}
