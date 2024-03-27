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

@WebServlet("/yaoping/pwd")
public class ChangepwdSeverLet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String newpwd = req.getParameter("newpwd");
		String old = req.getParameter("oldpwd");
		HttpSession session = req.getSession();
		Integer uid = (int)session.getAttribute("uid");
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/yaoping?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
    		String sele = "select * from user where upwd = ? and uid = ?";
            PreparedStatement stmt = conn.prepareStatement(sele);
            stmt.setString(1, old);
            stmt.setInt(2, uid);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
            	String sql = "UPDATE user SET upwd=? WHERE uid=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, newpwd);
                st.setInt(2, uid);
                st.executeUpdate();
            	req.setAttribute("change", "修改成功,请重新登录");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
            }else {
            	req.setAttribute("tishi", "旧密码错误");
				req.getRequestDispatcher("changepwd.jsp").forward(req, resp);
			}
            

			rs.close();
			stmt.close();
			conn.close();
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
