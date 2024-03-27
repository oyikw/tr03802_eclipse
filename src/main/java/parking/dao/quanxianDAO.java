package parking.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parking.util.quanxian;
import parking.util.shiyou;

public class quanxianDAO extends baseDAO{
	public List<quanxian> getAllquanxian() {
        List<quanxian> list = new ArrayList<>();
        String sql = "select * from quanxian";
        try {
            stmt = getConn().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
            	quanxian sy = new quanxian();
                sy.setQid(rs.getInt("qid"));
                sy.setSname(rs.getString("sname"));
                list.add(sy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           super.closeAll();
        }
        	return list;
    	}
}
