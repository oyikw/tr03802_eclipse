package JSTL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSTL/stu")
public class StudentSeverLet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("鲳鱼","tr03802",18,50));
		list.add(new Student("树莱","tr03802",18,20));
		list.add(new Student("马根","tr03802",18,90));
		list.add(new Student("鸡","tr03802",18,60));
		list.add(new Student("奥特曼","tr03802",18,70));
		request.setAttribute("list", list);
		request.getRequestDispatcher("student.jsp").forward(request, response);
	}
}
