package parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parking.util.Visits;
import parking.util.dengji;
import saying.entity.Saying;

public class dengjiDAO extends baseDAO{
	public Integer doInsert(dengji dj) {
	    String sql;
	    if (dj.getBz() != null && !dj.getBz().isEmpty()) {
	        sql = "insert into dengji(entry_time, exit_time, dtel, car_number, bz) values(?,?,?,?,?)";
	    } else {
	        sql = "insert into dengji(entry_time, exit_time, dtel, car_number) values(?,?,?,?)";
	    }
	    
	    try {
	        conn = super.getConn();
	        stmt = conn.prepareStatement(sql);
	        stmt.setObject(1, dj.getEntry_time());
	        stmt.setObject(2, dj.getExit_time());
	        stmt.setObject(3, dj.getDtel());
	        stmt.setObject(4, dj.getCar_number());
	        
	        if (sql.contains("bz")) {
	            stmt.setObject(5, dj.getBz());
	        }
	        
	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        super.closeAll();
	    }
	    return -1;
	}
	
	
	public List<Visits> query(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parking?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root" ,"123456" );
			String sql = "select * from visits";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Visits> list = new ArrayList<Visits>();
			while(rs.next()) {
				Visits visits = new Visits(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getDate(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				list.add(visits);
			}
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
	
	
	
}
