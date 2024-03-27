package yaoping;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

/**
 * Servlet implementation class ZhuceSeverLet
 */
@WebServlet("/yaoping/zhuce")
public class ZhuceSeverLet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/yaoping?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			String selectname = "select * from user where uname=?";
			PreparedStatement st = conn.prepareStatement(selectname);
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				req.setAttribute("tishi", "用户名已存在，请重新注册");
				req.getRequestDispatcher("zhuce.jsp").forward(req, resp);
				resp.sendRedirect("zhuce.jsp");
			}else {
				String sql = "insert into user(uname,upwd,uemail,utel) values(?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, pwd);
				stmt.setString(3, email);
				stmt.setString(4, tel);
				stmt.executeUpdate();
				resp.sendRedirect("login.jsp");
			}
			rs.close();
			st.close();
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
