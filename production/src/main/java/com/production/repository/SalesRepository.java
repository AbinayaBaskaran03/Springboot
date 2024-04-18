package com.production.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.production.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, UUID> {

	List<Sales> findByCusId(Integer cusId);

	List<Sales> findAllBySalesDate(Date salesDate);

}
