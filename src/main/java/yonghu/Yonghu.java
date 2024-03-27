package yonghu;

public class Yonghu {
	private Integer yid;
	private String yname;
	public Integer getYid() {
		return yid;
	}
	public void setYid(Integer yid) {
		this.yid = yid;
	}
	public String getYname() {
		return yname;
	}
	public void setYname(String yname) {
		this.yname = yname;
	}
	public Yonghu(Integer yid, String yname) {
		super();
		this.yid = yid;
		this.yname = yname;
	}
	public Yonghu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
