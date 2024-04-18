//package com.UnitTest;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.UnitTest.Entity.Cus;
//import com.UnitTest.Repository.CusRepository;
//import com.UnitTest.controller.CusController;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//
//
//@RunWith(MockitoJUnitRunner.class)
//
//public class CustomerTest {
//
//	private MockMvc mockMvc;
//
//	ObjectMapper objMapper = new ObjectMapper();
//
//	ObjectWriter objWriter = objMapper.writer();
//
//	@Mock
//	private CusRepository cusRepository;
//
//	@InjectMocks
//	private CusController cusController;
//
//	Cus cus1 = new Cus("abinaya", "101", "abi@gmail.com", "06384162548", "abi", "06384162478", "active", LocalDate.of(2023, 10, 5), "ADMIN", LocalDate.of(2023, 12, 10), "ADMIN");
//	Cus cus2 = new Cus("indhra", "102", "abi@gmail.com", "06384162548", "abi", "06384162478", "active", LocalDate.of(2023, 10, 5), "ADMIN", LocalDate.of(2023, 12, 10), "ADMIN");
//	Cus cus3 = new Cus("kalai", "103", "abi@gmail.com", "06384162548", "abi", "06384162478", "active", LocalDate.of(2023, 10, 5), "ADMIN", LocalDate.of(2023, 12, 10), "ADMIN");
//
//
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		this.mockMvc = MockMvcBuilders.standaloneSetup(cusController).build();
//
//	}
//
//	@Test
//	public void getAllrecords() throws Exception {
//		List<Cus> cusObj = new ArrayList<>(Arrays.asList(cus1, cus2, cus3));
//
//		Mockito.when(cusRepository.findAll()).thenReturn(cusObj);
//
//		mockMvc.perform(MockMvcRequestBuilders.get("/OnetoMany/get")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
//				.andExpect(jsonPath("$[2].name", is("kalai")));
//
//
//	}
//
//}
