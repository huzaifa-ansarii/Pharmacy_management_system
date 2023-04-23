package com.project.entities;

import java.time.LocalDate;

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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_pharmacy_inventory")
@NoArgsConstructor
@AllArgsConstructor
public class PharmacyStocks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_prod_id")
	private Long pProdId;
	
	@Column(name = "qty")
	private String availbleStripQty;
	
	@Column(name = "mfg_time")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate mfgTime;
	
	@Column(name = "expiry_time")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate expiryTime;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="user_id", nullable = false)
	private User userId;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="prod_detail_id", nullable = false)
	private ProductDetail prodDetailId;

	public Long getpProdId() {
		return pProdId;
	}

	public void setpProdId(Long pProdId) {
		this.pProdId = pProdId;
	}

	public String getAvailbleStripQty() {
		return availbleStripQty;
	}

	public void setAvailbleStripQty(String availbleStripQty) {
		this.availbleStripQty = availbleStripQty;
	}

	public LocalDate getMfgTime() {
		return mfgTime;
	}

	public void setMfgTime(LocalDate mfgTime) {
		this.mfgTime = mfgTime;
	}

	public LocalDate getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalDate expiryTime) {
		this.expiryTime = expiryTime;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public ProductDetail getProdDetailId() {
		return prodDetailId;
	}

	public void setProdDetailId(ProductDetail prodDetailId) {
		this.prodDetailId = prodDetailId;
	}

	@Override
	public String toString() {
		return "PharmacyStocks [pProdId=" + pProdId + ", availbleStripQty=" + availbleStripQty + ", mfgTime=" + mfgTime
				+ ", expiryTime=" + expiryTime + "]";
	}
	
	
	
	
	

}
