package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entities.ProdCategory;
import com.project.entities.ProductDetail;
import com.project.repository.ProductRepo;

@Service

public class ProductImpl implements ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	
	@Override
	public ProductDetail saveProduct(ProductDetail product) {
	
	
	
	
	return productRepo.save(product);
	}
	
 
}
