package JSTL;


public class Student {
	private String name;
	private String clas;
	private Integer age;
	private Integer cj;
	
	public Student(String name, String clas, Integer age, Integer cj) {
		super();
		this.name = name;
		this.clas = clas;
		this.age = age;
		this.cj = cj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getCj() {
		return cj;
	}

	public void setCj(Integer cj) {
		this.cj = cj;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
