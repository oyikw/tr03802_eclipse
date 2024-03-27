package yaoping;

import java.sql.Timestamp;

public class Lonck {
	private Integer lid;
	private Integer uid;
	private Timestamp ltime;
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Timestamp getLtime() {
		return ltime;
	}
	public void setLtime(Timestamp ltime) {
		this.ltime = ltime;
	}
	public Lonck() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lonck(Integer lid, Integer uid, Timestamp ltime) {
		super();
		this.lid = lid;
		this.uid = uid;
		this.ltime = ltime;
	}
	
}
