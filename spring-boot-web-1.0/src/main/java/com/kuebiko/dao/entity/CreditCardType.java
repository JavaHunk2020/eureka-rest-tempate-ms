package com.kuebiko.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credit_card_type")
public class CreditCardType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String ccode;
	private String benefit1;
	private String benefit2;
	private String benefit3;
	private String benefit4;
	private String joinFee;
	private String annualFee;
	private Timestamp doe;
	private Timestamp dom;
	@Column(columnDefinition = "longblob")
	private byte[] photo;
	
private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getBenefit1() {
		return benefit1;
	}

	public void setBenefit1(String benefit1) {
		this.benefit1 = benefit1;
	}

	public String getBenefit2() {
		return benefit2;
	}

	public void setBenefit2(String benefit2) {
		this.benefit2 = benefit2;
	}

	public String getBenefit3() {
		return benefit3;
	}

	public void setBenefit3(String benefit3) {
		this.benefit3 = benefit3;
	}

	public String getBenefit4() {
		return benefit4;
	}

	public void setBenefit4(String benefit4) {
		this.benefit4 = benefit4;
	}

	public String getJoinFee() {
		return joinFee;
	}

	public void setJoinFee(String joinFee) {
		this.joinFee = joinFee;
	}

	public String getAnnualFee() {
		return annualFee;
	}

	public void setAnnualFee(String annualFee) {
		this.annualFee = annualFee;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	public Timestamp getDom() {
		return dom;
	}

	public void setDom(Timestamp dom) {
		this.dom = dom;
	}

}
