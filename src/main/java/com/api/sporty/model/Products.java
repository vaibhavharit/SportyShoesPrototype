package com.api.sporty.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Table - Product
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Products {
	
	@Id
	@GeneratedValue
	private int productId;
	private String productType;
	private int productQuantity;
	private String productName;
	
	public Products() {
		
	}
	
	public Products(String pType, int pQ, String pN) {
		super();
		this.productType = pType;
		this.productQuantity = pQ;
		this.productName = pN;
	}
	
	public Products(int productId, String pType, int pQ, String pN) {
		super();
		this.productId = productId;
		this.productType = pType;
		this.productQuantity = pQ;
		this.productName = pN;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int ProductId) {
		this.productId = ProductId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String ProductType) {
		this.productType = ProductType;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int ProductQuantity) {
		this.productQuantity = ProductQuantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String ProductName) {
		this.productName = ProductName;
	}
	
}
