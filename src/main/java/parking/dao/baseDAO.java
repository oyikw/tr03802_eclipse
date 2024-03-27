package parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 1、三个对象和四个字符串
 * 2、一个静态块
 * 3、获取连接对象
 * 4、关闭资源
 * **/
public class baseDAO {
	//①连接对象
	protected Connection conn;
	//②预编译对象
	protected PreparedStatement stmt;
	//③结果集对象
	protected ResultSet rs;
	//第一个字符串：mysql驱动包的全类名
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	//第二个字符串：mysql服务器的链接地址
	private final String url="jdbc:mysql://127.0.0.1:3306/parking?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8";
	//第三个字符串：mysql服务器的用户名
	private final String user="root";
	//第四个字符串：mysql服务器的密码
	private final String pwd="123456";
	static {
		//利用静态块加载驱动（自动执行且只会执行一次，类和对象创建之前）
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}
	/*
	 * 获取连接对象
	 * */
	public Connection getConn() throws SQLException {
		if(conn==null || conn.isClosed()) {
			conn=DriverManager.getConnection(url, user, pwd);
		}
		return conn;
	}
	/*
	 * 关闭连接,释放资源
	 * */
	public void closeAll() {
		//先创建的后关闭
		//独立的try catch 结构 ：可以保证任何一个对象关闭报错都不会影响其它对象的关闭
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("结果集已被关闭...");
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("结果集已被关闭...");
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("结果集已被关闭...");
				e.printStackTrace();
			}
		}
	}
}
