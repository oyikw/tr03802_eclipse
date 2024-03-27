package yaoping;

import java.util.Date;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private String uemail;
	private String utel;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public User(int uid, String uname, String upwd, String uemail, String utel) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.uemail = uemail;
		this.utel = utel;
	}
	
}
