package JSTL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public List<User> queryAll(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tr03802?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			String sql = "SELECT * FROM users";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4));
				list.add(user);
			}
			rs.close();
			stmt.close();
			conn.close();
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(new UserDAO().queryAll());
	}
}