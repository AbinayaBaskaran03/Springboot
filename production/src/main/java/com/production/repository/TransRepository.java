package com.production.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.production.entity.Transaction;

@Repository
public interface TransRepository extends JpaRepository<Transaction , UUID>{

}
