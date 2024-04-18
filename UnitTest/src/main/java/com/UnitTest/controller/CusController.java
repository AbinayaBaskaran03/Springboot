package com.UnitTest.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UnitTest.Entity.Cus;
import com.UnitTest.Entity.Item;
//import com.UnitTest.Repository.CusRepository;
import com.UnitTest.Service.CusService;

@RestController
@RequestMapping("/OnetoMany/getcus")
public class CusController {

	@Autowired
	public CusService cusService;
	
//	@Autowired
//	CusRepository cusRepository;


	@GetMapping
	public ResponseEntity<List<Cus>> getAllcustomer() {
		List<Cus> cus = cusService.getAllCus();
        return new ResponseEntity<>(cus, HttpStatus.OK);
	}
	
//	@GetMapping(value = "/getbyid/{id}")
//	public Cus getbyId(@PathVariable("id") UUID id) {
//	    return cusRepository.findById(id).orElse(null);
//	}
//
//
//	
//	@PostMapping(value = "/createcus")
//	public Cus createaddress(@RequestBody  Cus cusRecord) {
//		return cusRepository.save(cusRecord);
//	}
//   @PutMapping
//	public Cus updateCusRecord(@RequestBody Cus cusRecord)throws NotFoundException {
//	   if(cusRecord == null || cusRecord.getId()== null ) {
//		   throw new NotFoundException();
//	   }
//	   
//	   Optional<Cus> optionalCus = cusRepository.findById(cusRecord.getId());
//	   if(!optionalCus.isPresent()) {
//		   throw new NotFoundException( );
//	   }
//	return cusRecord;
//	   
//   }

////to delete the child data in order		
//	@DeleteMapping(value = "/deleteorder/{id}")
//	public String deleteCustomer(@PathVariable("id") UUID id) {
//		cusService.deleteorder(id);
//		return "deleted";
//	}
//
////to delete the child data in orderitem		
//	@DeleteMapping(value = "/deletecus/{id}")
//	public String deleteCus(@PathVariable("id") UUID id) {
//		cusService.deletecus(id);
//		return "deleted";
//	}
	
	

}
