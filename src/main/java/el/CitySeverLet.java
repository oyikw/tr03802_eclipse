package el;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/El/city")
public class CitySeverLet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		list.add("株洲");
		list.add("长沙");
		list.add("河南");
		list.add("珠江");
		list.add("湖北");
		request.setAttribute("list", list);
		request.getRequestDispatcher("city.jsp").forward(request, response);
	}
}
