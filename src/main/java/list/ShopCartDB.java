package list;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShopCartDB extends ShopCart{
	public Product getProduct(int pid) {
		String sql = "select * from products where pid = ?";
		try {
			//加载数据库驱动 
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接字符串
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pid);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setName(rs.getString("pname"));
				p.setCount(1);
				p.setPrive(rs.getDouble("price"));
				return p;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
}
