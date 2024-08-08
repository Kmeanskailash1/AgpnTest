package com.spring.mvc.model;

public class DummyStudent {
	private Integer sid;
	private String sname;
	private String fname;
	private Double fees;
	public DummyStudent(Integer sid, String sname, String fname, Double fees) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.fname = fname;
		this.fees = fees;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Double getFees() {
		return fees;
	}
	public void setFees(Double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", fname=" + fname + ", fees=" + fees + "]";
	}
	

}
