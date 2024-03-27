package newwen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import newwen.util.Newwen;

public class NewwenDAO extends BaseDAO{
	public int insert(String ntitle,String nurl) {
		String sql = "insert into newwen(ntitle,nurl,ntime) values(?,?,now())";
		return this.execute(sql, ntitle,nurl);
	}
	
	public Map<String, Object> queryByPage(int curpage,int pagesize){
		String sql = "select * from newwen order by nid desc "
				+ "limit ?,?";
		List<Newwen> list = this.executeQuery(sql, new Mapper<Newwen>() {

			@Override
			public List<Newwen> map(ResultSet rs) throws SQLException {
				List<Newwen> list = new ArrayList<>();
				while(rs.next()) {
					Newwen newwen = new Newwen(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
					list.add(newwen);
				}
				return list;
			}
		}, (curpage - 1) * pagesize,pagesize);
		
		String sql2 = "select count(*) c from saying";
		Object obj = this.singleObject(sql2);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("total", obj);
		return map;
	}
	
	public List<Newwen> select(){
		String sql = "select * from newwen order by nid desc";
		return this.executeQuery(sql,new Mapper<Newwen>(){

			@Override
			public List<Newwen> map(ResultSet rs) throws SQLException {
				List<Newwen> list = new ArrayList<Newwen>();
				while(rs.next()) {
					Newwen newwen = new Newwen(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
					list.add(newwen);
				}
				return list;
			}
		});
	}
	
	public int delete() {
		String sql = "DELETE FROM newwen WHERE ntime < DATE_SUB(NOW(), INTERVAL 1 MONTH);";
		return this.execute(sql);
	}
	public static void main(String[] args) {
		NewwenDAO n = new NewwenDAO();
//		n.insert("偶烧笼", "现在时间是2024年3月5日11:14:33");

//		Map<String, Object> map = n.queryByPage(1, 2);
//		System.out.println(map.get("list"));
//		System.out.println(map.get("total"));
		
//		System.out.println(n.select());
		
		n.delete();
	}
}
