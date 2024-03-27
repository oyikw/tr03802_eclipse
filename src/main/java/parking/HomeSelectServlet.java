package parking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parking.dao.quanxianDAO;
import parking.dao.shiyouDAO;
import parking.util.quanxian;
import parking.util.shiyou;

public class HomeSelectServlet extends HttpServlet {	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //事由
	    List<shiyou> shiyouList = new ArrayList<>();
	    shiyouDAO dao = new shiyouDAO();
	    shiyouList = dao.getAllshiyou();
	    //权限
	    List<quanxian> qxlist = new ArrayList<quanxian>();
	    quanxianDAO qdao = new quanxianDAO();
	    qxlist = qdao.getAllquanxian();

	    req.setAttribute("shiyouList", shiyouList);
	    req.setAttribute("qxlist", qxlist);

	    req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
