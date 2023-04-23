package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{
	
};
