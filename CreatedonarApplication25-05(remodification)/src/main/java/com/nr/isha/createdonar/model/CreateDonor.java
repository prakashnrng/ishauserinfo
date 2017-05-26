package com.nr.isha.createdonar.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="createdonor") 
public class CreateDonor implements Serializable{
	
	@Id
	@Column(name="consumercode")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long consumerCode;
	
	
	 
	@NotEmpty
	@Column(name="donorfirstname")
	private String donorfirstname;
	 
	@NotEmpty
	@Column(name="donorlastname")
	private String donorlastname;
	
	@NotEmpty
	@Column(name="bankdetailsaccountholdername")
	private String  bankDetailsAccountHolderName;
	
	@NotEmpty
	@Column(name="bankdetailsbranchname")
	private String bankDetailsBranchName;
	
	@NotEmpty
	@Column(name="bankdetailsbankname")
	private String bankDetailsBankName;
	
	@NotEmpty
	@Column(name="bankdetailsaccountno")
	private String bankDetailsAccountNo;
	
	
	@Column(name="micr") 
 	private Double micr;
	
	@NotEmpty
	@Column(name="bankdetailsIFSCCode")
	private String bankDetailsIFSCCode;
	
	@NotEmpty
	@Email
	 @Column(name="donoremail")
	private String donoremail;
	
	
	
	@NotNull
	@Column(name="donormobile")
	 	private Long donormobile;
	
	@Column(name="paymentdetailsstartdate")
	Date paymentDetailsStartDate;
	
	@Column(name="paymentdetailsenddate")
	Date paymentDetailsEndDate;
	
	@NotNull
	@Column(name="paymentdetailsamountinrs")
	Double paymentDetailsAmountInRs;
	
	@NotNull
	@Column(name="paymentdetailsfrequency")
	String paymentDetailsFrequency;
	
	
	@NotEmpty
	@Column(name="donoraddress")
	private String donorAddress;
	
	@NotEmpty
	@Column(name="donorregion")
	private String donorRegion;
	
	@NotEmpty
	@Column(name="donorcity")
	private String donorCity;
	
	@NotEmpty
	@Column(name="donorstate")
	private String donorState;
	
	@NotEmpty
	@Column(name="donorcenter")
	private String donorCenter;

	 
	
	 
	 
	@NotEmpty
	@Column(name="bankdetailsaccounttype")
	private String bankDetailsAccountType;
	
	@NotEmpty
	@Column(name="comments")
	private String comments;
		
	
 
	public CreateDonor() {
		System.out.println("CreateDonar->D.C");
	}
	
	
	public CreateDonor(Long consumerCode) {
		super();
		this.consumerCode = consumerCode;
	}


	public CreateDonor(Long consumerCode, String donorfirstname, String donorlastname,
			String bankDetailsAccountHolderName, String bankDetailsBranchName, String bankDetailsBankName,
			String bankDetailsAccountNo, Double micr, String bankDetailsIFSCCode, String donoremail, Long donormobile,
			Date paymentDetailsStartDate, Date paymentDetailsEndDate, Double paymentDetailsAmountInRs,
			String paymentDetailsFrequency, String donorAddress, String donorRegion, String donorCity,
			String donorState, String donorCenter,   String bankDetailsAccountType,String comments) {
		super();
		this.consumerCode = consumerCode;
		this.donorfirstname = donorfirstname;
		this.donorlastname = donorlastname;
		this.bankDetailsAccountHolderName = bankDetailsAccountHolderName;
		this.bankDetailsBranchName = bankDetailsBranchName;
		this.bankDetailsBankName = bankDetailsBankName;
		this.bankDetailsAccountNo = bankDetailsAccountNo;
		this.micr = micr;
		this.bankDetailsIFSCCode = bankDetailsIFSCCode;
		this.donoremail = donoremail;
		this.donormobile = donormobile;
		this.paymentDetailsStartDate = paymentDetailsStartDate;
		this.paymentDetailsEndDate = paymentDetailsEndDate;
		this.paymentDetailsAmountInRs = paymentDetailsAmountInRs;
		this.paymentDetailsFrequency = paymentDetailsFrequency;
		this.donorAddress = donorAddress;
		this.donorRegion = donorRegion;
		this.donorCity = donorCity;
		this.donorState = donorState;
		this.donorCenter = donorCenter;	 
		this.bankDetailsAccountType = bankDetailsAccountType;
	}


	public CreateDonor(String donorfirstname, String donorlastname, String bankDetailsAccountHolderName,
			String bankDetailsBranchName, String bankDetailsBankName, String bankDetailsAccountNo, Double micr,
			String bankDetailsIFSCCode, String donoremail, Long donormobile, Date paymentDetailsStartDate,
			Date paymentDetailsEndDate, Double paymentDetailsAmountInRs, String paymentDetailsFrequency,
			String donorAddress, String donorRegion, String donorCity, String donorState, String donorCenter,
			  String bankDetailsAccountType,String comments) {
		super();
		this.donorfirstname = donorfirstname;
		this.donorlastname = donorlastname;
		this.bankDetailsAccountHolderName = bankDetailsAccountHolderName;
		this.bankDetailsBranchName = bankDetailsBranchName;
		this.bankDetailsBankName = bankDetailsBankName;
		this.bankDetailsAccountNo = bankDetailsAccountNo;
		this.micr = micr;
		this.bankDetailsIFSCCode = bankDetailsIFSCCode;
		this.donoremail = donoremail;
		this.donormobile = donormobile;
		this.paymentDetailsStartDate = paymentDetailsStartDate;
		this.paymentDetailsEndDate = paymentDetailsEndDate;
		this.paymentDetailsAmountInRs = paymentDetailsAmountInRs;
		this.paymentDetailsFrequency = paymentDetailsFrequency;
		this.donorAddress = donorAddress;
		this.donorRegion = donorRegion;
		this.donorCity = donorCity;
		this.donorState = donorState;
		this.donorCenter = donorCenter;
		 
		this.bankDetailsAccountType = bankDetailsAccountType;
	}


	public Long getConsumerCode() {
		return consumerCode;
	}


	public void setConsumerCode(Long consumerCode) {
		this.consumerCode = consumerCode;
	}


	public String getDonorfirstname() {
		return donorfirstname;
	}


	public void setDonorfirstname(String donorfirstname) {
		this.donorfirstname = donorfirstname;
	}


	public String getDonorlastname() {
		return donorlastname;
	}


	public void setDonorlastname(String donorlastname) {
		this.donorlastname = donorlastname;
	}


	public String getBankDetailsAccountHolderName() {
		return bankDetailsAccountHolderName;
	}


	public void setBankDetailsAccountHolderName(String bankDetailsAccountHolderName) {
		this.bankDetailsAccountHolderName = bankDetailsAccountHolderName;
	}


	public String getBankDetailsBranchName() {
		return bankDetailsBranchName;
	}


	public void setBankDetailsBranchName(String bankDetailsBranchName) {
		this.bankDetailsBranchName = bankDetailsBranchName;
	}


	public String getBankDetailsBankName() {
		return bankDetailsBankName;
	}


	public void setBankDetailsBankName(String bankDetailsBankName) {
		this.bankDetailsBankName = bankDetailsBankName;
	}


	public String getBankDetailsAccountNo() {
		return bankDetailsAccountNo;
	}


	public void setBankDetailsAccountNo(String bankDetailsAccountNo) {
		this.bankDetailsAccountNo = bankDetailsAccountNo;
	}


	 


	public Double getMicr() {
		return micr;
	}


	public void setMicr(Double micr) {
		this.micr = micr;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getBankDetailsIFSCCode() {
		return bankDetailsIFSCCode;
	}


	public void setBankDetailsIFSCCode(String bankDetailsIFSCCode) {
		this.bankDetailsIFSCCode = bankDetailsIFSCCode;
	}


	public String getDonoremail() {
		return donoremail;
	}


	public void setDonoremail(String donoremail) {
		this.donoremail = donoremail;
	}


	public Long getDonormobile() {
		return donormobile;
	}


	public void setDonormobile(Long donormobile) {
		this.donormobile = donormobile;
	}


	public Date getPaymentDetailsStartDate() {
		return paymentDetailsStartDate;
	}


	public void setPaymentDetailsStartDate(Date paymentDetailsStartDate) {
		this.paymentDetailsStartDate = paymentDetailsStartDate;
	}


	public Date getPaymentDetailsEndDate() {
		return paymentDetailsEndDate;
	}


	public void setPaymentDetailsEndDate(Date paymentDetailsEndDate) {
		this.paymentDetailsEndDate = paymentDetailsEndDate;
	}


	public Double getPaymentDetailsAmountInRs() {
		return paymentDetailsAmountInRs;
	}


	public void setPaymentDetailsAmountInRs(Double paymentDetailsAmountInRs) {
		this.paymentDetailsAmountInRs = paymentDetailsAmountInRs;
	}


	public String getPaymentDetailsFrequency() {
		return paymentDetailsFrequency;
	}


	public void setPaymentDetailsFrequency(String paymentDetailsFrequency) {
		this.paymentDetailsFrequency = paymentDetailsFrequency;
	}


	public String getDonorAddress() {
		return donorAddress;
	}


	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}


	public String getDonorRegion() {
		return donorRegion;
	}


	public void setDonorRegion(String donorRegion) {
		this.donorRegion = donorRegion;
	}


	public String getDonorCity() {
		return donorCity;
	}


	public void setDonorCity(String donorCity) {
		this.donorCity = donorCity;
	}


	public String getDonorState() {
		return donorState;
	}


	public void setDonorState(String donorState) {
		this.donorState = donorState;
	}


	public String getDonorCenter() {
		return donorCenter;
	}


	public void setDonorCenter(String donorCenter) {
		this.donorCenter = donorCenter;
	}


	 


	public String getBankDetailsAccountType() {
		return bankDetailsAccountType;
	}


	public void setBankDetailsAccountType(String bankDetailsAccountType) {
		this.bankDetailsAccountType = bankDetailsAccountType;
	}


	@Override
	public String toString() {
		return "CreateDonor [consumerCode=" + consumerCode + ", donorfirstname=" + donorfirstname + ", donorlastname="
				+ donorlastname + ", bankDetailsAccountHolderName=" + bankDetailsAccountHolderName
				+ ", bankDetailsBranchName=" + bankDetailsBranchName + ", bankDetailsBankName=" + bankDetailsBankName
				+ ", bankDetailsAccountNo=" + bankDetailsAccountNo + ", micr=" + micr + ", bankDetailsIFSCCode="
				+ bankDetailsIFSCCode + ", donoremail=" + donoremail + ", donormobile=" + donormobile
				+ ", paymentDetailsStartDate=" + paymentDetailsStartDate + ", paymentDetailsEndDate="
				+ paymentDetailsEndDate + ", paymentDetailsAmountInRs=" + paymentDetailsAmountInRs
				+ ", paymentDetailsFrequency=" + paymentDetailsFrequency + ", donorAddress=" + donorAddress
				+ ", donorRegion=" + donorRegion + ", donorCity=" + donorCity + ", donorState=" + donorState
				+ ", donorCenter=" + donorCenter + ", bankDetailsBranch=" +  
				  bankDetailsAccountType + ", comments=" + comments + "]";
	}


	
	
	
	
	 
	  
	
	
	
	
	 

 
	

}

