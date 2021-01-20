package com.xangars.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Product")
public class Product implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "prodid")
	private Integer prodId;
	
	@Column(name="prodname")
	private String prodName;
	
	@Column(name="proddetails")
	private String prodDetails;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name="prodenddate")
	private Date prodEndDate;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name="prodlaunchdate")
	private Date prodLaunchDate;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDetails() {
		return prodDetails;
	}

	public void setProdDetails(String prodDetails) {
		this.prodDetails = prodDetails;
	}

	public Date getProdEndDate() {
		return prodEndDate;
	}

	public void setProdEndDate(Date prodEndDate) {
		this.prodEndDate = prodEndDate;
	}

	public Date getProdLaunchDate() {
		return prodLaunchDate;
	}

	public void setProdLaunchDate(Date prodLaunchDate) {
		this.prodLaunchDate = prodLaunchDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
