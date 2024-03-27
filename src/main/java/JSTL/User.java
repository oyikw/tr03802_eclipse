package JSTL;

import java.util.Date;

public class User {
	private int u_id;
	private String u_name;
	private String u_pwd;
	private Date u_time;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int u_id, String u_name, String u_pwd, Date u_time) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pwd = u_pwd;
		this.u_time = u_time;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public Date getU_time() {
		return u_time;
	}
	public void setU_time(Date u_time) {
		this.u_time = u_time;
	}
}
