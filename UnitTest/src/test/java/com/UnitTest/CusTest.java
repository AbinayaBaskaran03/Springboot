package com.UnitTest;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.UnitTest.Entity.Cus;
import com.UnitTest.Service.CusService;
import com.UnitTest.controller.CusController;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CusController.class)
class CusTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CusService cusService;

	@Test
	public void getAllrecords() throws Exception {
	    List<Cus> cus = Arrays.asList(
	            new Cus("abinaya", "101", "abi@gmail.com", "06384162548", "abi", "06384162478", "active",
	                    LocalDate.of(2023, 10, 5), "ADMIN", LocalDate.of(2023, 12, 10), "ADMIN"),
	            new Cus("indhra", "102", "abi@gmail.com", "06384162548", "abi", "06384162478", "active",
	                    LocalDate.of(2023, 10, 5), "ADMIN", LocalDate.of(2023, 12, 10), "ADMIN"),
	            new Cus("kalai", "103", "abi@gmail.com", "06384162548", "abi", "06384162478", "active",
	                    LocalDate.of(2023, 10, 5), "ADMIN", LocalDate.of(2023, 12, 10), "ADMIN")
	    );

	    Mockito.when(cusService.getAllCus()).thenReturn(cus);

	    mockMvc.perform(MockMvcRequestBuilders.get("/OnetoMany/getcus")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
	            .andExpect(jsonPath("$[0].name", is("abinaya")))
	            .andExpect(jsonPath("$[2].name", is("kalai")));
	}

}
