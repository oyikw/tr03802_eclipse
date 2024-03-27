package shangchuanfile.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import newwen.dao.BaseDAO;
import newwen.dao.Mapper;
import shangchuanfile.util.usera;

public class UseraDAO extends BaseDAO{
	public int insert(String name,String pwd,String tel,String addres,String tx) {
		String sql = "insert into usera(uname,upwd,utel,uaddres,utx) values (?,?,?,?,?)";
		return this.execute(sql, name,pwd,tel,addres,tx);
	}
	
	public List<usera> select(String name,String pwd){
		String sql = "select * from usera where uname = ? and upwd = ?";
		
		List<usera> list = this.executeQuery(sql, new Mapper<usera>() {

			@Override
			public List<usera> map(ResultSet rs) throws SQLException {
				List<usera> list = new ArrayList<usera>();
				while(rs.next()) {
					usera user = new usera(rs.getInt(1),  rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					list.add(user);
				}
				return list;
			}
			
		}, name,pwd);
		return list;
	}
    public int updateUser(String photo,Integer uid) {
        String sql = "update usera set utx = ? where uid = ?";
        return this.execute(sql, photo,uid);
    }

}
