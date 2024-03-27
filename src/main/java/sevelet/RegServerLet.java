package sevelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/setvlet/reg")
public class RegServerLet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String nickname = req.getParameter("nickname");
		String pwd = req.getParameter("pwd");
		String tel = req.getParameter("tel");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tr03802?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			String sl = "select * from user where u_name = ?";
			PreparedStatement stmt = conn.prepareStatement(sl);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			 if (rs.next()) {
			        // 用户名已存在，设置提示信息并转发到 reg.jsp 页面
				 	req.setAttribute("name", "账户已经存在，请重新注册");
			        req.getRequestDispatcher("reg.jsp").forward(req, resp);
			    }else {
					 String sql = "insert into user(u_nickname,u_name,u_pwd,u_tel) values(?,?,?,?)";
					 PreparedStatement st = conn.prepareStatement(sql);
					 st.setString(1, nickname);
					 st.setString(2, name);
					 st.setString(3, pwd);
					 st.setString(4, tel);
					 st.executeUpdate();
					 req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
