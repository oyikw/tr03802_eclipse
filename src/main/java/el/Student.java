package el;

import java.sql.Date;

public class Student {
	private int uid;
	private String name;
	private String idcard;
	private String tel;
	private Integer age;
	private String tx;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTx() {
		return tx;
	}
	public void setTx(String tx) {
		this.tx = tx;
	}
	public Student(int uid, String name, String idcard, String tel, Integer age, String tx) {
		super();
		this.uid = uid;
		this.name = name;
		this.idcard = idcard;
		this.tel = tel;
		this.age = age;
		this.tx = tx;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
