package com.api.sporty.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Table - PurchaseReport
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@ToString
public class PurchaseReport {
	
	@Id
	@GeneratedValue
	private int purchaseReportId;
	private String purchaseReportCategory;
	private String purchaseReportDate;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user; 
	@ManyToOne(fetch = FetchType.EAGER)
	private Products product; 
	
	public PurchaseReport() {
		
	}
	
	public PurchaseReport(String prc, String prd, User usr, Products pd) {
		super();
		this.purchaseReportCategory = prc;
		this.purchaseReportDate = prd;
		this.user = usr;
		this.product = pd;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	
	public long getPurchaseReportId() {
		return purchaseReportId;
	}
	public void setPurchaseReportId(int PurchaseReportId) {
		this.purchaseReportId = PurchaseReportId;
	}
	public String getPurchaseReportCategory() {
		return purchaseReportCategory;
	}
	public void setPurchaseReportCategory(String PurchaseReportCategory) {
		this.purchaseReportCategory = PurchaseReportCategory;
	}
	public String getPurchaseReportDate() {
		return purchaseReportDate;
	}
	public void setPurchaseReportDate(String PurchaseReportDate) {
		this.purchaseReportDate = PurchaseReportDate;
	}

}
