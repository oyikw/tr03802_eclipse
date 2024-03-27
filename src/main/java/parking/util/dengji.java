package parking.util;

import java.sql.Timestamp;

public class dengji {
	public dengji(Timestamp entry_time, Timestamp exit_time, String dtel, String car_number) {
		super();
		this.entry_time = entry_time;
		this.exit_time = exit_time;
		this.dtel = dtel;
		this.car_number = car_number;
	}
	public dengji(Timestamp entry_time, Timestamp exit_time, String dtel, String car_number, String bz) {
		super();
		this.entry_time = entry_time;
		this.exit_time = exit_time;
		this.dtel = dtel;
		this.car_number = car_number;
		this.bz = bz;
	}
	private Integer did;
	private Integer sid;
	private Integer qid;
	private Timestamp entry_time;
	private Timestamp exit_time;
	private String dtel;
	private String car_number;
	private String bz;
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public Timestamp getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Timestamp entry_time) {
		this.entry_time = entry_time;
	}
	public Timestamp getExit_time() {
		return exit_time;
	}
	public void setExit_time(Timestamp exit_time) {
		this.exit_time = exit_time;
	}
	public String getDtel() {
		return dtel;
	}
	public void setDtel(String dtel) {
		this.dtel = dtel;
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	
	public dengji(Integer did, Integer sid, Integer qid, Timestamp entry_time, Timestamp exit_time, String dtel,
			String car_number, String bz) {
		super();
		this.did = did;
		this.sid = sid;
		this.qid = qid;
		this.entry_time = entry_time;
		this.exit_time = exit_time;
		this.dtel = dtel;
		this.car_number = car_number;
		this.bz = bz;
	}
	public dengji() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
