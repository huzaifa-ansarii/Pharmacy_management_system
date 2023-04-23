package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.ProductDetail;

@Repository
public interface ProductRepo extends JpaRepository<ProductDetail, Long> {



}
