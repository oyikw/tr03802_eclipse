package el;

public class Product {
    private int pid;
    private String pname;
    private String image;
    private double price;
    private String addres;
    private String color;
    private String gg;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String pname, String image, double price, String addres, String color, String gg) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.image = image;
		this.price = price;
		this.addres = addres;
		this.color = color;
		this.gg = gg;
	}

    // 构造方法
   
}
