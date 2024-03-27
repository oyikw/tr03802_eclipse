package el;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/El/stu")
public class StuSeverLet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Student> map = new HashMap<>();
		Student stu = new Student(1, "月月鸟", "430111200110150075", "13812345678", 18, "tp.png");
		map.put(stu.getTel(), stu);	
		request.setAttribute("stu", map);
		request.getRequestDispatcher("student.jsp").forward(request, response);
	}
}
