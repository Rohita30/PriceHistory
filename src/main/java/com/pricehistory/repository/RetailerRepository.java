package com.pricehistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pricehistory.entity.Retailer;

public interface RetailerRepository extends JpaRepository<Retailer, Long>{

}
