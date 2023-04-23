package com.project.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.customException.ProductNotFoundException;
import com.project.customException.ResourceNotFoundException;
import com.project.dto.OrderDTO;
import com.project.entities.ProductDetail;
import com.project.entities.User;
import com.project.repository.ProductRepo;
import com.project.repository.UserRepo;
import com.project.service.DistributorService;
import com.project.service.OrderService;
import com.project.service.ProductService;

@RestController
@RequestMapping("/pms/distributor")
public class DistributorController {

    @Autowired
    private ProductService productService;
    @Autowired
	private DistributorService distributorService;
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private ProductRepo prodRepo;
    
    @Autowired
    private UserRepo userRepo;
	
	
	

	
	
	

    

	// endpoint for adding a new product
  
    // endpoint for updating an existing product
  
   

    // endpoint for retrieving all products
    @GetMapping("/viewproducts")
    public ResponseEntity<?> getAllProducts() {
        List<ProductDetail> products =prodRepo.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // endpoint for retrieving a specific product by id
//    @GetMapping("/product/{id}")
//    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long productId) {
//        ProductDTO product = productService.getProductById(productId);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }

   

  

  
    




    
    @PostMapping("/updateusers")
    public ResponseEntity<?> updateUserProfile( @RequestBody User userDetails)
                                               		   throws ResourceNotFoundException 
    {
    	System.out.println("before1");
    	User user= new User();
         user = userRepo.findByEmail(userDetails.getEmail());
           
          System.out.println(user);
        user.setMobile_no(userDetails.getMobile_no());
        System.out.println("beforeafter");
        user.setAddress(userDetails.getAddress());
        System.out.println("after");
                return new ResponseEntity<>(userRepo.save(user),HttpStatus.OK);
    }

}
