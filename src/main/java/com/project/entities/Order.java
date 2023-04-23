package com.project.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "t_orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long orderId;
    
	@NotNull(message = "orderStripQty can't be blank")
	@Column(length = 50)
	private Integer orderStripQty;
	
	@NotNull(message = "purchasePricePerStrip can't be blank")
	@Column(length = 50)
	private Double purchasePricePerStrip;
	
	@NotNull(message = "countPerStrip can't be blank")
	@Column(length = 50)
	private Integer countPerStrip;
	
	@NotNull(message = "orderTime can't be blank")
	@Column(name = "order_time")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate orderTime;
	
	
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="p_user_id", nullable = false)
	private  User pUserId;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="d_user_id", nullable = false)
	private  User dUserId;
	
	
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name = "prod_detail_id", nullable = false)
	private ProductDetail prodDetailsId;



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



	public User getpUserId() {
		return pUserId;
	}



	public void setpUserId(User pUserId) {
		this.pUserId = pUserId;
	}



	public User getdUserId() {
		return dUserId;
	}



	public void setdUserId(User dUserId) {
		this.dUserId = dUserId;
	}



	public ProductDetail getProdDetailsId() {
		return prodDetailsId;
	}



	public void setProdDetailsId(ProductDetail prodDetailsId) {
		this.prodDetailsId = prodDetailsId;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStripQty=" + orderStripQty + ", purchasePricePerStrip="
				+ purchasePricePerStrip + ", countPerStrip=" + countPerStrip + ", orderTime=" + orderTime + ", pUserId="
				+ pUserId + ", dUserId=" + dUserId + ", prodDetailsId=" + prodDetailsId + "]";
	}
	
	


	

  
    
    
    
}

