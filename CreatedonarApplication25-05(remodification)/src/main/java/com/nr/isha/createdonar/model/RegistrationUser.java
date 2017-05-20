package com.nr.isha.createdonar.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registrationuser")
public class RegistrationUser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="registrationuserid")
private Long registrationUserid;
	
	@Column(name="registrationfirstname")	
private String registrationFirstName;
	@Column(name="registrationlastname")
private String registrationLastName;
 
	@Column(name="registrationemail")
private String registrationEmail;
	@Column(name="registrationmobile")
private Long registrationMobile;
	@Column(name="registrationpasscode")
private String registrationPasscode;
	@Column(name="registrationconfirmpasscode")
private String registrationConfirmPasscode;
	@Column(name="registrationstatus")
private String registrationStatus="active";

public RegistrationUser() {
	System.out.println("RegistrationUser=>D.C");
	 
}



 



 



 



public RegistrationUser(String registrationFirstName, String registrationLastName, 
		String registrationEmail, Long registrationMobile, String registrationPasscode,
		String registrationConfirmPasscode, String registrationStatus) {
	super();
	this.registrationFirstName = registrationFirstName;
	this.registrationLastName = registrationLastName;
	 
	this.registrationEmail = registrationEmail;
	this.registrationMobile = registrationMobile;
	this.registrationPasscode = registrationPasscode;
	this.registrationConfirmPasscode = registrationConfirmPasscode;
	this.registrationStatus = registrationStatus;
}








public RegistrationUser(Long registrationUserid, String registrationFirstName, String registrationLastName,
		  String registrationEmail, Long registrationMobile, String registrationPasscode,
		String registrationConfirmPasscode, String registrationStatus) {
	super();
	this.registrationUserid = registrationUserid;
	this.registrationFirstName = registrationFirstName;
	this.registrationLastName = registrationLastName;
	 
	this.registrationEmail = registrationEmail;
	this.registrationMobile = registrationMobile;
	this.registrationPasscode = registrationPasscode;
	this.registrationConfirmPasscode = registrationConfirmPasscode;
	this.registrationStatus = registrationStatus;
}



public Long getRegistrationUserid() {
	return registrationUserid;
}



public void setRegistrationUserid(Long registrationUserid) {
	this.registrationUserid = registrationUserid;
}



public String getRegistrationStatus() {
	return registrationStatus;
}



public void setRegistrationStatus(String registrationStatus) {
	this.registrationStatus = registrationStatus;
}



public String getRegistrationFirstName() {
	return registrationFirstName;
}



public void setRegistrationFirstName(String registrationFirstName) {
	this.registrationFirstName = registrationFirstName;
}


 


public String getRegistrationEmail() {
	return registrationEmail;
}



public void setRegistrationEmail(String registrationEmail) {
	this.registrationEmail = registrationEmail;
}



 


public Long getRegistrationMobile() {
	return registrationMobile;
}



public void setRegistrationMobile(Long registrationMobile) {
	this.registrationMobile = registrationMobile;
}



public String getRegistrationPasscode() {
	return registrationPasscode;
}



public void setRegistrationPasscode(String registrationPasscode) {
	this.registrationPasscode = registrationPasscode;
}



public String getRegistrationConfirmPasscode() {
	return registrationConfirmPasscode;
}



public void setRegistrationConfirmPasscode(String registrationConfirmPasscode) {
	this.registrationConfirmPasscode = registrationConfirmPasscode;
}



public String getRegistrationLastName() {
	return registrationLastName;
}



public void setRegistrationLastName(String registrationLastName) {
	this.registrationLastName = registrationLastName;
}



@Override
public String toString() {
	return "RegistrationUser [registrationUserid=" + registrationUserid + ", registrationFirstName="
			+ registrationFirstName + ", registrationLastName=" + registrationLastName + ", registrationPassword="
			+  registrationEmail + ", registrationMobile="
			+ registrationMobile + ", registrationPasscode=" + registrationPasscode + ", registrationConfirmPasscode="
			+ registrationConfirmPasscode + ", registrationStatus=" + registrationStatus + "]";
}



 
 
}
