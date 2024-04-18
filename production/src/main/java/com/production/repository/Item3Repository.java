package com.production.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.production.entity.Item3;
@Repository
public interface Item3Repository  extends JpaRepository<Item3 , UUID>{





}
