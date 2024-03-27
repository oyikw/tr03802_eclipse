package JSTL;

public class Product {
	private Integer pid;
	private String pname;
	private Double price;
	private String img;
	private String ms;
	private Integer count;
	private Double like;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getLike() {
		return like;
	}
	public void setLike(double like) {
		this.like = like;
	}
	public Product(Integer pid, String pname, double price, String img, String ms, Integer count, double like) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.img = img;
		this.ms = ms;
		this.count = count;
		this.like = like;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
