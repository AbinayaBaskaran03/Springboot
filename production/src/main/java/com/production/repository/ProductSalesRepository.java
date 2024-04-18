package com.production.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.production.entity.ProductSales;

@Repository
public interface ProductSalesRepository extends JpaRepository <ProductSales , UUID>{

}
