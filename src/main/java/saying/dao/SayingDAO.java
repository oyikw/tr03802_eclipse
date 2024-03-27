package saying.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import saying.entity.Saying;
import saying.vo.ChartDCVO;

public class SayingDAO {
	/*
	 * 留言
	 * user用户名
	 * content留言内容
	 * */
	public void insert(String user,String content) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tr03802?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root" ,"123456" );
			String sql = "insert into saying(suser,scontent,stime) values(?,?,now()) ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, content);
			stmt.executeUpdate();
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
	
	/*
	 * 所有查询考虑分页
	 * */
	public List<Saying> query(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tr03802?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root" ,"123456" );
			String sql = "select * from saying order by sid desc";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Saying> list = this.map(rs);
			rs.close();
			stmt.close();
			conn.close();
			
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void dele(Integer sid){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tr03802?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root" ,"123456" );
			String sql = "delete from saying where sid = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, sid);
			stmt.executeUpdate();
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
	
	private List<Saying> map(ResultSet rs) throws SQLException{
		List<Saying> list = new ArrayList<>();
		while(rs.next()) {
			Saying saying = new Saying(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4));
			list.add(saying);
		}
		return list;
	}
	
	
	public Map<String, Object> queryByPage(int curpage,int pagesize){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tr03802?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root" ,"123456" );
			String sql = "select * from saying order by sid desc limit ?,?";//起始位置，长度
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (curpage - 1) * pagesize);//当前页-1*页大小
			stmt.setInt(2, pagesize);
			ResultSet rs = stmt.executeQuery();
			List<Saying> list = this.map(rs);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list",list);
			//计算总记录数
			sql = "select count(*) from saying";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			int total = rs.getInt(1);
			map.put("total", total);
			
			rs.close();
			stmt.close();
			conn.close();
			
			return map;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteBatch(String[] sids) {
		if(sids == null) {
			
		}else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tr03802?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root" ,"123456" );
				String sql = "delete from saying where sid = ?";
				PreparedStatement stmt = null;
				for(String s :sids) {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, s);
					stmt.executeUpdate();
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
	
	public List<ChartDCVO> chartDc(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql = "select DATE_FORMAT(stime, '%Y-%m-%d') d, count(*) c from saying group by DATE_FORMAT(stime, '%Y-%m-%d')";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<ChartDCVO> list = new ArrayList<>();
			while(rs.next()) {
				ChartDCVO vo = new ChartDCVO(
					rs.getDate("d"),
					rs.getInt("c")
				);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			conn.close();
			
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
