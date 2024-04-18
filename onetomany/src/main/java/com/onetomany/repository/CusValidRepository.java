package com.onetomany.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.entity.CusValidation;

@Repository
public interface CusValidRepository extends JpaRepository<CusValidation, UUID> {

	public CusValidation findByEmail(String email);

	public CusValidation findByPhone(String phone);

}
