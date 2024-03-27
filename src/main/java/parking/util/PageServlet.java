//package parking.util;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
//* @Description: 
//* @author: 惠
//* @date 2024年2月5日 下午6:12:02
//*/
//@WebServlet(urlPatterns = "/parking/fangke")
//public class PageServlet extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//
//		String curpageParam = request.getParameter("curpage");
//		String pagesizeParam = request.getParameter("pagesize");
//		String where = request.getParameter("where");
//
//		if (where==null) {
//			where = "";
//		}
//		int curpage;
//		int pagesize;
//		if (curpageParam == null || curpageParam.isEmpty()) {
//			curpage = 1;
//		} else {
//			curpage = Integer.valueOf(curpageParam);
//		}
//
//		if (pagesizeParam == null || pagesizeParam.isEmpty()) {
//			pagesize = 5;
//		} else {
//			pagesize = Integer.valueOf(pagesizeParam);
//		}
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/parking?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8",
//					"root", "123456");
//			String sql = "SELECT * FROM visits WHERE cars_number LIKE ? LIMIT ?,?";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, "%" + where + "%");
//			stmt.setInt(2, (curpage - 1) * pagesize);
//			stmt.setInt(3, pagesize);
//			ResultSet rs = stmt.executeQuery();
//
//			// 转换成user的list集合
//			List<Visits> list = new ArrayList();
//			while (rs.next()) {
//				list.add(new Visits(rs.getInt("visit_id"),
//						rs.getString("cars_number"),
//						rs.getString("visit_phone"),
//						rs.getTimestamp("reg_time"),
//						rs.getTimestamp("start_time"), 
//						rs.getTimestamp("end_time"), 
//						rs.getString("state"),
//						rs.getString("reason_text"), 
//						rs.getString("permission_text"), 
//						rs.getString("notes")));
//				
//			}
//
//			// 获得表中所有记录的条数
//			sql = "select count(*) from visits where cars_number LIKE ? ";
//			PreparedStatement stmt2=conn.prepareStatement(sql);
//			stmt2.setString(1, "%" + where + "%");
//			ResultSet rs2 = stmt2.executeQuery();
//			rs2.next();
//			int total = rs2.getInt(1); // 总记录数
//
//			// 将数据保存到request中以便转发jsp显示
//			System.out.println(list);
//			request.setAttribute("total", total);
//			request.setAttribute("list", list);
//			request.setAttribute("where", where);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 转发到jsp
//		request.getRequestDispatcher("apply").forward(request, response);
//	}
//}
