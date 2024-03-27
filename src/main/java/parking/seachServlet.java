package parking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parking.util.Visits;

@WebServlet(urlPatterns = "/parking/fangke")
public class seachServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cp = req.getParameter("cph");
        List<Visits> list = new ArrayList<>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8",
	                    "root", "123456");
	            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM parking WHERE cars_number = ?");
	            stmt.setString(1, cp);
	            ResultSet rs = stmt.executeQuery();
	            if (!rs.next()) {
	                System.out.println("没有查到相关记录");
	            } else {
	                do {
	                	Visits visits = new Visits(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getDate(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
	    				list.add(visits);
	                } while (rs.next());
	            }
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 req.setAttribute("cp", list);
		 req.getRequestDispatcher("home.jsp").forward(req, resp);
		 
	}
}
