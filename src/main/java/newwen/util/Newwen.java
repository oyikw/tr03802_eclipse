package newwen.util;

import java.util.Date;

public class Newwen {
	private Integer nid;
	private String ntitle;
	private String nurl;
	private Date ntime;
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNurl() {
		return nurl;
	}
	public void setNurl(String nurl) {
		this.nurl = nurl;
	}
	public Date getNtime() {
		return ntime;
	}
	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}
	public Newwen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Newwen(Integer nid, String ntitle, String nurl, Date ntime) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.nurl = nurl;
		this.ntime = ntime;
	}
	
}
