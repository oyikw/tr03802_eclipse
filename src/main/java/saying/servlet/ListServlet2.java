package saying.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;

import saying.dao.SayingDAO;
import saying.entity.Saying;

/**
 * Servlet implementation class listServlet
 */
@WebServlet("/saying/ListServlet2")
public class ListServlet2 extends HttpServlet {
	
	private SayingDAO sayingDAO = new SayingDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Saying> list = sayingDAO.query();
		//转换成JSON数组
		String array = JSONArray.toJSONString(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(array);
	}

}
