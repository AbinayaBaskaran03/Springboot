package com.onetomany.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.entity.Cus;
import com.onetomany.repository.CusRepository;

@Service
public class CusService {

	@Autowired
	public CusRepository cusRepository;

	public void saveCus(Cus cus) {
		cusRepository.save(cus);
	}

//	public List<Cus> getAll() {
//		return cusRepository.findAll();
//	}

//to delete the child data in order
	public void deleteorder(UUID id) {
		cusRepository.deleteById(id);

	}

//to delete the child data in orderitem
	public void deletecus(UUID id) {
		cusRepository.deleteById(id);

	}

//namedQuery
	public List<Cus> getAllCus(String code) {
		List<Cus> cuslist = new ArrayList<>();
		if (code == null) {
			cusRepository.findAll().forEach(cus->cuslist.add(cus));;
		} else {
			return	cusRepository.findAllByCode(code);
		}
		return cuslist;
	}

//namedQuery
	public List<Cus> getcusById(UUID cusId) {
		return cusRepository.findOneById(cusId);
	}

}
