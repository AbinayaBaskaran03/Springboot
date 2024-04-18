package com.onetomany.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.entity.Book2;

@Repository
public interface Book2Repository extends JpaRepository<Book2,UUID>{

}
