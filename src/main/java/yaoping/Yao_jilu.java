package yaoping;

import java.sql.Timestamp;

public class Yao_jilu {
	private int yid;
	private int uid;
	private Timestamp ytime;
	private String ytype;
	public int getYid() {
		return yid;
	}
	public void setYid(int yid) {
		this.yid = yid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Timestamp getYtime() {
		return ytime;
	}
	public void setYtime(Timestamp ytime) {
		this.ytime = ytime;
	}
	public String getYtype() {
		return ytype;
	}
	public void setYtype(String ytype) {
		this.ytype = ytype;
	}
	public Yao_jilu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Yao_jilu(int yid, int uid, Timestamp ytime, String ytype) {
		super();
		this.yid = yid;
		this.uid = uid;
		this.ytime = ytime;
		this.ytype = ytype;
	}
	
}
