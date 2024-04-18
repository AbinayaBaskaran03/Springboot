package com.onetomany.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,UUID>{

}
