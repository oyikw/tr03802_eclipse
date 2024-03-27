package saying.entity;

import java.util.Date;

public class Saying {
	private Integer sid;
	private String suser;
	private String scontent;
	private Date stime;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSuser() {
		return suser;
	}
	public void setSuser(String suser) {
		this.suser = suser;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Saying(Integer sid, String suser, String scontent, Date stime) {
		super();
		this.sid = sid;
		this.suser = suser;
		this.scontent = scontent;
		this.stime = stime;
	}
	public Saying() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Saying [sid=" + sid + ", suser=" + suser + ", scontent=" + scontent + ", stime=" + stime + "]";
	}
	
}
