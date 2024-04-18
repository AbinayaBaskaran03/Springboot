package com.spring.jpa.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Cus;

@Repository
public interface CustomerRepository extends CrudRepository<Cus , UUID>{
	
	public Cus findByName(String name);
	
	
}
