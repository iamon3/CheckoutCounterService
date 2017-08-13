package com.freeorg.checkoutCounter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freeorg.checkoutCounter.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
