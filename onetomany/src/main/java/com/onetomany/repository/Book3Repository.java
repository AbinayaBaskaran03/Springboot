package com.onetomany.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.entity.Book3;

@Repository

public interface Book3Repository extends JpaRepository<Book3,UUID>{

}
