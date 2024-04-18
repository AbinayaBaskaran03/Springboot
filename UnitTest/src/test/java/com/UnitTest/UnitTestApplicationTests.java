package com.UnitTest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.UnitTest.Entity.Item;
import com.UnitTest.Service.ItemService;
import com.UnitTest.controller.ItemController;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
class UnitTestApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemService itemService;

	@Test
	public void testGetAllItems() throws Exception {
		List<Item> items = Arrays.asList(
				new Item("item1", 10),
				new Item("item2", 20), 
				new Item("item3", 30));

		Mockito.when(itemService.getAllItems()).thenReturn(items);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/items")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].name", is("item1")))
				.andExpect(jsonPath("$[1].price", is(20)))
				.andExpect(jsonPath("$[2].name", is("ite3")));
	}

}
