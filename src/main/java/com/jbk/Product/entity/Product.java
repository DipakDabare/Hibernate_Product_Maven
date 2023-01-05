package com.jbk.Product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int id;
	private String prodcuctName;
	private int productPrice;
	private String productMfg;
	private String productCategory;
	
	public Product(int id, String prodcuctName, int productPrice, String productMfg, String productCategory) {
		super();
		this.id = id;
		this.prodcuctName = prodcuctName;
		this.productPrice = productPrice;
		this.productMfg = productMfg;
		this.productCategory = productCategory;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", prodcuctName=" + prodcuctName + ", productPrice=" + productPrice
				+ ", productMfg=" + productMfg + ", productCategory=" + productCategory + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdcuctName() {
		return prodcuctName;
	}
	public void setProdcuctName(String prodcuctName) {
		this.prodcuctName = prodcuctName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductMfg() {
		return productMfg;
	}
	public void setProductMfg(String productMfg) {
		this.productMfg = productMfg;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	
	
	
	
	
}
