package parking.util;

import com.alibaba.fastjson2.annotation.JSONField;

public class shiyou {
	private int sid;
	@JSONField(name = "n",format = "yyyy-MM-dd")
	private String sname;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public shiyou(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	public shiyou() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
