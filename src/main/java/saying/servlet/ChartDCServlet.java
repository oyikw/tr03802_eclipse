package saying.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;
import saying.vo.ChartDCVO;

@WebServlet("/saying/ChartDCServlet")
public class ChartDCServlet extends HttpServlet{
	private SayingDAO sayingDAO = new SayingDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ChartDCVO> list = sayingDAO.chartDc();
		
		//计算总数
		int total = 0;
		for(ChartDCVO vo: list) {
			total += vo.getCount();
		}
		request.setAttribute("total", total);
		request.setAttribute("list", list);
		request.getRequestDispatcher("chart.jsp")
			.forward(request, response);
	}
}
