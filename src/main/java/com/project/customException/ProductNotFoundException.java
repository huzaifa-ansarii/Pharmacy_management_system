package com.project.customException;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(String message) {
        super(message);
}

	public ProductNotFoundException(Long id) {
		// TODO Auto-generated constructor stub
		
	}
}