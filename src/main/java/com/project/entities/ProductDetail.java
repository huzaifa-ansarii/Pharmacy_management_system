package com.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "T_product_details")
public class ProductDetail {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pdid")
	private Long productDetailId;
	
	@Column(name = "pname")
	private String productName;
	
	@Column(name = "pcontent")
	private String productContent;
	
	@Column(name = "cname")
	private String companyName;
	
	
	private String dose;
	
	
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="prod_category_id", nullable = false)
	private ProdCategory prod_category_id;



	public Long getProductDetailId() {
		return productDetailId;
	}



	public void setProductDetailId(Long productDetailId) {
		this.productDetailId = productDetailId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductContent() {
		return productContent;
	}



	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getDose() {
		return dose;
	}



	public void setDose(String dose) {
		this.dose = dose;
	}



	



	public ProdCategory getProd_category_id() {
		return prod_category_id;
	}



	public void setProd_category_id(ProdCategory prod_category_id) {
		this.prod_category_id = prod_category_id;
	}



	@Override
	public String toString() {
		return "ProductDetail [productDetailId=" + productDetailId + ", productName=" + productName
				+ ", productContent=" + productContent + ", companyName=" + companyName + ", dose=" + dose + "]";
	}


		
	
}
