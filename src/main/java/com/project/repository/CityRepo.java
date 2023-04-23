package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.City;

public interface CityRepo extends JpaRepository<City, Long>{
	
};
