package com.spring.jpa.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.jpa.entity.Cus;
import com.spring.jpa.entity.CusAddress;
import com.spring.jpa.entity.CusOrder;
import com.spring.jpa.entity.CusOrderItem;
import com.spring.jpa.repository.AddressRepository;
import com.spring.jpa.repository.CustomerRepository;
import com.spring.jpa.repository.OrderItemRepository;
import com.spring.jpa.repository.OrderRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	public void saveCustomer(Cus customer) {
		customerRepository.save(customer);
	}

	public List<Cus> getAll() {
		return (List<Cus>) customerRepository.findAll();
	}

	public void saveAddress(CusAddress address) {
		addressRepository.save(address);

	}

	public List<CusAddress> getAllAddress() {
		return (List<CusAddress>) addressRepository.findAll();
	}

	public void saveOrder(CusOrder order) {
		orderRepository.save(order);

	}

	public List<CusOrder> getAllOrder() {
		return (List<CusOrder>) orderRepository.findAll();
	}

	public void saveOrderItem(CusOrderItem orderitem) {
		orderItemRepository.save(orderitem);

	}

	public List<CusOrderItem> getAllOrderItem() {
		return (List<CusOrderItem>) orderItemRepository.findAll();
	}

//Update
	public void updateCustomer(Cus customer) {
		customerRepository.save(customer);
	}

//select	
	public Cus getByname(String name) {
		return customerRepository.findByName(name);
	}
//Delete

	public void deletecus(UUID id) {
		customerRepository.deleteById(id);
	}

	public void deleteAddres(UUID id) {
		addressRepository.deleteById(id);
	}

}
