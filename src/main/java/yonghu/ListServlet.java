package yonghu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;

@WebServlet("/yonghu/ylist")
public class ListServlet extends HttpServlet{
	private YonghuDAO dao = new YonghuDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Yonghu> list = dao.query();
		String array = JSONArray.toJSONString(list);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(array);
	}
}
