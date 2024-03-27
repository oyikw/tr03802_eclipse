package saying.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import saying.entity.Saying;
import saying.vo.ChartDCVO;

public class SsayingDAO extends BaseDAO{
	public int save(String user,String content) {
		String sql = "insert into saying(suser,scontent,stime) values(?,?,now()) ";
		return this.execute(sql, user,content);
	}
	
	public int update(int sid,String user,String content) {
		String sql = "update saying set suser=?,scontent=? where sid = ?";
		return this.execute(sql, user,content,sid);
	}
	
	public int delete(int sid) {
		String sql = "delete from saying where sid = ?";
		return this.execute(sql, sid);
	}
	
	public List<Saying> query(){
		String sql = "select * from saying order by sid desc";
		return this.executeQuery(sql, new Mapper<Saying>() {
			@Override
			public List<Saying> map(ResultSet rs) throws SQLException {
				List<Saying> list = new ArrayList<>();
				while(rs.next()) {
					Saying saying = new Saying(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getTimestamp(4));
					list.add(saying);
				}
				return list;
			}
		});
	}
	
	public List<ChartDCVO> chartDCVOs(){
		String sql = "select DATE_FORMAT(stime, '%Y-%m-%d') d, count(*) c from saying group by DATE_FORMAT(stime, '%Y-%m-%d')";
		return this.executeQuery(sql, new Mapper<E>() {

			@Override
			public List<Saying> map(ResultSet rs) {
				List<ChartDCVO> list = new ArrayList<>();
				while(rs.next()) {
					ChartDCVO vo = new ChartDCVO(
						rs.getDate("d"),
						rs.getInt("c")
					);
					list.add(vo);
				}
				return list;
			}
		});
	}
	
	public Map<String, Object> queryByPage(int curpage, int pagesize){
		String sql = "select * from saying order by sid desc "
				+ "limit ?,?";
		List<Saying> list = this.executeQuery(sql, new Mapper<Saying>() {
			@Override
			public List<Saying> map(ResultSet rs) throws SQLException {
				List<Saying> list = new ArrayList<>();
				while(rs.next()) {
					Saying saying = new Saying(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getTimestamp(4));
					list.add(saying);
				}
				return list;
			}
		}, (curpage - 1) * pagesize, pagesize);
		
		String sql2 = "select count(*) c from saying";
		Object obj = this.singleObject(sql2);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("total", obj);
		return map;
	}
	public static void main(String[] args) {
		SsayingDAO s = new SsayingDAO();
//		s.save("oy", "123123213");
//		s.delete(1);
	}
}
