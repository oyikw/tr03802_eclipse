package shangchuanfile.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shangchuanfile.dao.UseraDAO;
import shangchuanfile.util.usera;

@WebServlet(urlPatterns = "/shangchuanfile/dl")
public class LoginServlet extends HttpServlet{
	private UseraDAO dao = new UseraDAO();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		List<usera> userList = dao.select(name, pwd);
        if (userList != null && !userList.isEmpty()) {
            usera user = userList.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("uid", user.getUid());
            session.setAttribute("name", user.getUname());
            session.setAttribute("tel", user.getUtel());
            session.setAttribute("addres", user.getUaddres());
            session.setAttribute("photo", user.getUtx());
            req.getRequestDispatcher("UserMessage.jsp").forward(req, resp);
        } else {
            req.setAttribute("tishi", "用户不存在，请重新登录");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
	}
}
