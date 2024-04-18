package com.production.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.production.entity.Item2;
@Repository
public interface Item2Repository extends JpaRepository<Item2 , UUID> {





}
