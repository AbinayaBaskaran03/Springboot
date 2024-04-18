package com.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.entity.Address;
import com.onetomany.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	public AddressRepository addressRepository;

	public void saveAddress(Address address) {
		addressRepository.save(address);
		
	}

}
