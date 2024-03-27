package Tag;

public class Products {
	private int pid;
	private String pname;
	private double prive;
	private int count;
	private int total;
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
	public double getPrive() {
		return prive;
	}
	public void setPrive(double prive) {
		this.prive = prive;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Products(int pid, String pname, double prive) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.prive = prive;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
