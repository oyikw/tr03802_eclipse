package shangchuanfile.util;

public class usera {
	private Integer uid;
	private String uname;
	private String upwd;
	private String utel;
	private String uaddres;
	private String utx;
	public usera() {
		super();
		// TODO Auto-generated constructor stub
	}
	public usera(Integer uid, String uname, String upwd, String utel, String uaddres, String utx) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.utel = utel;
		this.uaddres = uaddres;
		this.utx = utx;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
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
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getUaddres() {
		return uaddres;
	}
	public void setUaddres(String uaddres) {
		this.uaddres = uaddres;
	}
	public String getUtx() {
		return utx;
	}
	public void setUtx(String utx) {
		this.utx = utx;
	}
}
