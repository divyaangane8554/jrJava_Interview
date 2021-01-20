package com.xangars.bean;

import java.util.Date;

public class ProductBean {
	private Integer pid;
	private String pname;
	private Date plaunchdate;
	private Date penddate;
	private String pdetails;
	
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
	public Date getPlaunchdate() {
		return plaunchdate;
	}
	public void setPlaunchdate(Date plaunchdate) {
		this.plaunchdate = plaunchdate;
	}
	public Date getPenddate() {
		return penddate;
	}
	public void setPenddate(Date penddate) {
		this.penddate = penddate;
	}
	public String getPdetails() {
		return pdetails;
	}
	public void setPdetails(String pdetails) {
		this.pdetails = pdetails;
	}
	
	
}
	
