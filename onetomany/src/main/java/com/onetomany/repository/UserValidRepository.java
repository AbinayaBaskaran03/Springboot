package com.onetomany.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.entity.UserValidation;

@Repository
public interface UserValidRepository extends CrudRepository<UserValidation, UUID> {

	public UserValidation findByUserName(String user_name);

	public UserValidation findByFirstName(String first_name);

	public UserValidation findByLastName(String last_name);

	public UserValidation findByEmail(String email);

	public UserValidation findByMobileNo(String mobileno);

	public UserValidation findByAddress(String address);

	public UserValidation findByPinCode(String pincode);

}
