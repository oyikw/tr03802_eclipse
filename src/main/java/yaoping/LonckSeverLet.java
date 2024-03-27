package yaoping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/yaoping/lock")
public class LonckSeverLet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TimeZone timeZone = TimeZone.getTimeZone("GMT"); // 或者替换为数据库中存储的时区
		TimeZone.setDefault(timeZone);
		HttpSession session = req.getSession();
        String time = req.getParameter("ytime");
        Integer uid = (int)session.getAttribute("uid");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/yaoping?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8", "root", "123456");
            
            // 插入新用药记录
            String insertSql = "insert into lonck(uid, ltime) values(?,?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setInt(1, uid);
            insertStmt.setString(2, time);
            insertStmt.executeUpdate();
            req.setAttribute("tis","添加成功");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
            resp.sendRedirect("home.jsp");

			insertStmt.close();
			conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
