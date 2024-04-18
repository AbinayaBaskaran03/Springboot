package com.onetomany.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.entity.Book1;

@Repository
public interface Book1Repository extends JpaRepository<Book1,UUID>{

}
