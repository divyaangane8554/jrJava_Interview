package com.xangars.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Product")
public class Policy implements Serializable {

private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "custid")
	private Integer custId;
	
	@Column(name="custname")
	private String custName;
	
	/*@Basic
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name="custdob")
	private java.time.LocalDate custDob;*/
	
	@Column(name="custemail")
	private String custEmail;
	
	@Column(name="insurancename")
	private String insuranceName;
	
	@Column(name="custmobnumber")
	private long custMobNumber;
	
	@Column(name="premiummode")
	private String premiumMode;
	
	@Column(name="policystatus")
	private String policyStatus;
	
	@Column(name="custpancard")
	private String custPanCard;
	
	/*@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name = "policy_date", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private java.time.LocalDate policyInsuranceDate;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date contLastUpdated;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date emailLastUpdated;*/
	
	@Column(name="bankaccounnumber")
	private String bankAccountNumber;
	
	private String whatsAppOptInStatus;
	
	private Long outstandingPayout;
	
	private Long unclaimedAmount;
	
	private boolean NEFTregistered;
	
	private boolean lastPremiumPaid;
	
	@JoinColumn(name = "prod_id", referencedColumnName = "empid")
	private Product prod_id;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public long getCustMobNumber() {
		return custMobNumber;
	}

	public void setCustMobNumber(long custMobNumber) {
		this.custMobNumber = custMobNumber;
	}

	public String getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(String premiumMode) {
		this.premiumMode = premiumMode;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getCustPanCard() {
		return custPanCard;
	}

	public void setCustPanCard(String custPanCard) {
		this.custPanCard = custPanCard;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getWhatsAppOptInStatus() {
		return whatsAppOptInStatus;
	}

	public void setWhatsAppOptInStatus(String whatsAppOptInStatus) {
		this.whatsAppOptInStatus = whatsAppOptInStatus;
	}

	public Long getOutstandingPayout() {
		return outstandingPayout;
	}

	public void setOutstandingPayout(Long outstandingPayout) {
		this.outstandingPayout = outstandingPayout;
	}

	public Long getUnclaimedAmount() {
		return unclaimedAmount;
	}

	public void setUnclaimedAmount(Long unclaimedAmount) {
		this.unclaimedAmount = unclaimedAmount;
	}

	public boolean isNEFTregistered() {
		return NEFTregistered;
	}

	public void setNEFTregistered(boolean nEFTregistered) {
		NEFTregistered = nEFTregistered;
	}

	public boolean isLastPremiumPaid() {
		return lastPremiumPaid;
	}

	public void setLastPremiumPaid(boolean lastPremiumPaid) {
		this.lastPremiumPaid = lastPremiumPaid;
	}

	public Product getProd_id() {
		return prod_id;
	}

	public void setProd_id(Product prod_id) {
		this.prod_id = prod_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
