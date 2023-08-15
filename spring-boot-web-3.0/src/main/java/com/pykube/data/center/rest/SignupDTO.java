package com.pykube.data.center.rest;

import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SignupDTO {
	
	private int sid;
	private String name;
	private String password;
	private String email;
	private String gender;
	private String passportFlag;
	private String creditCardFlag;
	private String cardStatus;
	private String photo;
	private int hid;
	private String role;
	private String applicationId;
	private String cardName;
	private Date applyDate;
	@JsonIgnore(true)
	private byte[] pphoto;
	
	
	public byte[] getPphoto() {
		return pphoto;
	}

	public void setPphoto(byte[] pphoto) {
		this.pphoto = pphoto;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getCreditCardFlag() {
		return creditCardFlag;
	}

	public void setCreditCardFlag(String creditCardFlag) {
		this.creditCardFlag = creditCardFlag;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPassportFlag() {
		return passportFlag;
	}

	public void setPassportFlag(String passportFlag) {
		this.passportFlag = passportFlag;
	}

	public SignupDTO() {
		
	}
	
	public SignupDTO(int sid, String name, String email, String gender) {
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "SignupDTO [sid=" + sid + ", name=" + name + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", passportFlag=" + passportFlag + ", creditCardFlag=" + creditCardFlag + ", cardStatus="
				+ cardStatus + ", photo=" + photo + ", hid=" + hid + ", role=" + role + ", applicationId="
				+ applicationId + ", cardName=" + cardName + ", applyDate=" + applyDate + ", pphoto="
				+ Arrays.toString(pphoto) + "]";
	}
	
	

}