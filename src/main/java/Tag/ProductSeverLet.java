package Tag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/SimpletagSupport/page")
public class ProductSeverLet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			String sea = req.getParameter("sea");
			String curpageStr = req.getParameter("curpage");
			String pagesizeStr = req.getParameter("pagesize");
			int curpage;
			int pagesize;

			if (curpageStr == null || curpageStr.isEmpty()) {
			    curpage = 1;
			} else {
			    curpage = Integer.parseInt(curpageStr);
			}

			if (pagesizeStr == null || pagesizeStr.isEmpty()) {
			    pagesize = 10;
			} else {
			    pagesize = Integer.parseInt(pagesizeStr);
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tr03802?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			String sql = "";
			if(sea == null || sea.isEmpty()) {
				sql = "select * from products limit ?,?";
			}else {
				sql = "SELECT * FROM products WHERE pname LIKE '%"+sea+"%' LIMIT ?, ?";
			}
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (curpage - 1) * pagesize);
			stmt.setInt(2, pagesize);
			ResultSet rs = stmt.executeQuery();
			List<Products> list = new ArrayList<Products>();
			while(rs.next()) {
				list.add(new Products(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}          
			if(sea == null || sea.isEmpty()) {
				sql = "select count(*) from products";
			}else {
				sql = "select count(*) from products where pname like '%"+sea+"%'";
			}
			ResultSet rs2 = stmt.executeQuery(sql);
			rs2.next();
			int total = rs2.getInt(1);//总条数
			
			//将数据保存到request中
			req.setAttribute("list", list);//当前数据
			req.setAttribute("total", total);
			req.setAttribute("sea", sea);
			
			rs2.close();
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("page.jsp").forward(req, resp);
	}
}
