package com.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_catagory")
public class ProdCategory {
	
	@Id
	@GeneratedValue
	(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	@NotNull
	@Column
	private String categoryName;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ProdCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
	

	
}
