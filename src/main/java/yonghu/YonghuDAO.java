package yonghu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import newwen.dao.BaseDAO;
import newwen.dao.Mapper;

public class YonghuDAO extends BaseDAO{
	public List<Yonghu> query(){
		String sql = "select * from yonghu";
		return this.executeQuery(sql, new Mapper<Yonghu>() {

			@Override
			public List<Yonghu> map(ResultSet rs) throws SQLException {
				List<Yonghu> list = new ArrayList<Yonghu>();
				while(rs.next()) {
					Yonghu yonghu = new Yonghu(rs.getInt(1), rs.getString(2));
					list.add(yonghu);
				}
				return list;
			}
			
		});
	}
	
	public int delete(int id) {
		String sql = "DELETE FROM yonghu WHERE yid = ?";
		return this.execute(sql,id);
	}
}
