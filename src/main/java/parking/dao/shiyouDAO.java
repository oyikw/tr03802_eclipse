package parking.dao;
	
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parking.util.shiyou;


public class shiyouDAO extends baseDAO {
    public List<shiyou> getAllshiyou() {
        List<shiyou> list = new ArrayList<>();
        String sql = "select * from shiyou";
        try {
            stmt = getConn().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                shiyou sy = new shiyou();
                sy.setSid(rs.getInt("sid"));
                sy.setSname(rs.getString("sname"));
                list.add(sy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        	return list;
    	}
    }