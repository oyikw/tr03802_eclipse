package list;

public class Product {
	private int pid;
	private String name;
	private double prive;
	private int count;
	private double total;
	public Product(int pid, String name, double prive, int count, double total) {
		super();
		this.pid = pid;
		this.name = name;
		this.prive = prive;
		this.count = count;
		this.total = total;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Product(int pid, String name, double prive, int count) {
		super();
		this.pid = pid;
		this.name = name;
		this.prive = prive;
		this.count = count;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", prive=" + prive + ", count=" + count + ", total=" + total
				+ "]";
	}
	
}
