package yaoping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/yaoping/all")
public class SelectAllSeverLet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		Integer uid = (int)session.getAttribute("uid");
		TimeZone timeZone = TimeZone.getTimeZone("GMT"); // 或者替换为数据库中存储的时区
		TimeZone.setDefault(timeZone);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/yaoping?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
            // 查询用户信息
            String selectUser = "SELECT * FROM yao_jilu WHERE uid=?";
            PreparedStatement st = conn.prepareStatement(selectUser);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            List<Yao_jilu> list = new ArrayList<Yao_jilu>();
            if (rs.next()) {
                do {
                    Yao_jilu y = new Yao_jilu(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getString(4));
                    list.add(y);
                } while (rs.next());
            }else {
                req.setAttribute("tishi", "没有用药记录");
                req.getRequestDispatcher("all.jsp").forward(req, resp);
            }
            req.setAttribute("list", list);
            req.getRequestDispatcher("all.jsp").forward(req, resp);

			rs.close();
			st.close();
			conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
