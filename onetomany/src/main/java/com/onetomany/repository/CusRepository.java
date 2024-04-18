package com.onetomany.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.entity.Cus;

@Repository
public interface CusRepository extends JpaRepository<Cus, UUID> {

	List<Cus> findOneById(UUID cusId);

	List<Cus> findAllByCode(String code);

}

////to delete the child data in order
//public interface CusRepository extends JpaRepository<CusOrder, UUID> {
//	
//}

//to delete the child data in orderitem	
//   public interface CusRepository extends JpaRepository<CusOrderItem, UUID> {
//   }
