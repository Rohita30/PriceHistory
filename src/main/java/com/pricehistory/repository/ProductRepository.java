package com.pricehistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pricehistory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
