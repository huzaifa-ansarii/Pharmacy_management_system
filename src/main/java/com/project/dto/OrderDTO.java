package com.project.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;



public class OrderDTO {
	private Long orderId;
    

	private Integer orderStripQty;
	

	private Double purchasePricePerStrip;

	private Integer countPerStrip;
	
   @DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate orderTime;
	
	

	private  Long pUserId;
	private  Long dUserId;
	

	private Long prodDetails;
	
	


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Integer getOrderStripQty() {
		return orderStripQty;
	}


	public void setOrderStripQty(Integer orderStripQty) {
		this.orderStripQty = orderStripQty;
	}


	public Double getPurchasePricePerStrip() {
		return purchasePricePerStrip;
	}


	public void setPurchasePricePerStrip(Double purchasePricePerStrip) {
		this.purchasePricePerStrip = purchasePricePerStrip;
	}


	public Integer getCountPerStrip() {
		return countPerStrip;
	}


	public void setCountPerStrip(Integer countPerStrip) {
		this.countPerStrip = countPerStrip;
	}

    



	public LocalDate getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(LocalDate orderTime) {
		this.orderTime = orderTime;
	}




	public Long getpUserId() {
		return pUserId;
	}


	public void setpUserId(Long pUserId) {
		this.pUserId = pUserId;
	}


	public Long getdUserId() {
		return dUserId;
	}


	public void setdUserId(Long dUserId) {
		this.dUserId = dUserId;
	}


	public Long getProdDetails() {
		return prodDetails;
	}


	public void setProdDetails(Long prodDetails) {
		this.prodDetails = prodDetails;
	}
	
	
	
	

	
}
