package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.Order;
import com.project.entities.ProductDetail;
import com.project.repository.OrderRepo;
import com.project.service.OrderService;

@RestController
@RequestMapping("/vieworder")
public class ViewOrderController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/orders/{puserid}")
    public ResponseEntity<?> viewOrders(@PathVariable Long pUserId) 
    {
           List<Order> order =orderRepo.findAll();
           System.out.println(order);
            return new  ResponseEntity<>(order.stream()
                        .filter(o ->  o.getpUserId().getUser_id()==(pUserId)),HttpStatus.OK);
       
    }
//    @GetMapping("/getAllProduct/{categoryId}")
//	public ResponseEntity<?> getAll(@PathVariable Integer categoryId){
//           List<ProductDetail> products = productRepo.findAll();
//              
//		 return new ResponseEntity<>(products.stream().filter(p -> p.getProd_category_id().getCategoryId().equals(categoryId)),HttpStatus.OK);
//	}
    
}


