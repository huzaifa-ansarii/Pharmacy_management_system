package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.PharmacyStocks;

public interface PharmacyRepo extends JpaRepository<PharmacyStocks, Long> {

}
