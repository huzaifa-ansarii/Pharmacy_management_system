package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.ProductDetail;
import com.project.repository.ProductRepo;
import com.project.service.ProductService;



@RequestMapping("/product")
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepo productRepo;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> saveProduct(@RequestBody ProductDetail product ) {
	     return  new ResponseEntity<>(productRepo.save(product),HttpStatus.OK);
	}
	
	@GetMapping("/getAllProduct/{categoryId}")
	public ResponseEntity<?> getAll(@PathVariable Integer categoryId){
           List<ProductDetail> products = productRepo.findAll();
              
		 return new ResponseEntity<>(products.stream().filter(p -> p.getProd_category_id().getCategoryId().equals(categoryId)),HttpStatus.OK);
	}
}
