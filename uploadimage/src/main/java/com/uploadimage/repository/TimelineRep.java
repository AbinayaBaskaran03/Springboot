package com.uploadimage.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uploadimage.entity.TimeLine;

@Repository
public interface TimelineRep extends JpaRepository<TimeLine, UUID> {








}
