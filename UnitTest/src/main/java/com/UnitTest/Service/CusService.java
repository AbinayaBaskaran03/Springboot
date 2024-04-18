package com.UnitTest.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.UnitTest.Entity.Cus;

@Service
public class CusService {

//	@Autowired
//	public CusRepository cusRepository;

//	public void saveCus(Cus cus) {
//		cusRepository.save(cus);
//	}
//
//	public List<Cus> getAll() {
//		return cusRepository.findAll();
//	}
//
////to delete the child data in order
//	public void deleteorder(UUID id) {
//		cusRepository.deleteById(id);
//
//	}
//
////to delete the child data in orderitem
//	public void deletecus(UUID id) {
//		cusRepository.deleteById(id);
//
//	}

	public List<Cus> getAllCus() {
		return Arrays.asList(
				new Cus("abinaya", "101", "abi@gmail.com", "06384162548", "abi", "06384162478", "active",
						LocalDate.of(2023, 10, 5), "ADMIN", LocalDate.of(2023, 12, 10), "ADMIN"),
				new Cus("indhra", "102", "abi@gmail.com", "06384162548", "abi", "06384162478", "active",
						LocalDate.of(2023, 10, 5), "ADMIN", LocalDate.of(2023, 12, 10), "ADMIN"),
				new Cus("kalai", "103", "abi@gmail.com", "06384162548", "abi", "06384162478", "active",
						LocalDate.of(2023, 10, 5), "ADMIN", LocalDate.of(2023, 12, 10), "ADMIN")
				);
	}

	
}
