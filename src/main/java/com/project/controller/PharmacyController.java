package com.project.controller;





import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.OrderDTO;

import com.project.entities.Order;
import com.project.entities.ProductDetail;
import com.project.entities.User;
import com.project.repository.OrderRepo;
import com.project.repository.PharmacyRepo;
import com.project.repository.ProductRepo;
import com.project.repository.UserRepo;



@RequestMapping("/pharmacy")
@RestController
public class PharmacyController {
	
	@Autowired
	private PharmacyRepo pharmaRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	
	
	@PostMapping("/placeorder")
	public ResponseEntity<?> placeOrder(@RequestBody OrderDTO orderDto )
	{
//		(Long orderId, @NotNull(message = "orderStripQty can't be blank") Integer orderStripQty,
//				@NotNull(message = "purchasePricePerStrip can't be blank") Double purchasePricePerStrip,
//				@NotNull(message = "countPerStrip can't be blank") Integer countPerStrip,
//				@NotNull(message = "orderTime can't be blank") LocalDateTime orderTime, User userId,
//				ProductDetail prodDetails)
		
		Order order = new Order();
		order.setOrderId(orderDto.getOrderId());
		order.setOrderStripQty(orderDto.getOrderStripQty());
		order.setOrderTime(orderDto.getOrderTime());
		order.setCountPerStrip(orderDto.getCountPerStrip());
		order.setPurchasePricePerStrip(orderDto.getPurchasePricePerStrip());
		Optional<User> dUser = userRepo.findById(orderDto.getdUserId());
		Optional<User> pUser = userRepo.findById(orderDto.getpUserId());
		Optional<ProductDetail> prod = productRepo.findById(orderDto.getProdDetails());
	    order.setdUserId(dUser.get());
		order.setpUserId(pUser.get());
		order.setProdDetailsId(prod.get());
		return new ResponseEntity<>(orderRepo.save(order),HttpStatus.OK);
	}

}
