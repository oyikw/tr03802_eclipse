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

/**
 * Servlet implementation class loginSeverLet
 */
@WebServlet("/yaoping/dl")
public class loginSeverLet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/yaoping?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
            
            // 查询用户信息
            String selectUser = "SELECT * FROM user WHERE uname=? AND upwd=?";
            PreparedStatement st = conn.prepareStatement(selectUser);
            st.setString(1, name);
            st.setString(2, pwd);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                Integer uid = rs.getInt("uid"); // 获取用户的uid
                HttpSession session = req.getSession();
                session.setAttribute("uid", uid);
                resp.sendRedirect("home.jsp");
            } else {
                req.setAttribute("tishi", "账号或密码错误，请重新登录");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

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
