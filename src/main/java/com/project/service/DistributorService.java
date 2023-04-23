package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.customException.ResourceNotFoundException;
import com.project.dto.DistributorDTO;
import com.project.entities.Distributor;
import com.project.entities.ProductDetail;


import com.project.repository.ProductRepo;


@Service
public class DistributorService {

    @Autowired
    private ProductRepo productRepo;

   

    public List<ProductDetail> getAllProducts() {
        return productRepo.findAll();
    }

    public ProductDetail addProduct(ProductDetail product) {
        return productRepo.save(product);
    }

  

   
   

   

   

	public DistributorService getDistributorById(Object distributorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
