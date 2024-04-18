package com.spring.jpa.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.spring.jpa.entity.CusAddress;


@Repository
public interface AddressRepository extends CrudRepository<CusAddress , UUID> {

}
