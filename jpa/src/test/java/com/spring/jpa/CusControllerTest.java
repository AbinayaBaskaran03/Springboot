package com.spring.jpa;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.jpa.controller.CustomerController;
import com.spring.jpa.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class CusControllerTest {
    
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerController customerController;

	
	
}
