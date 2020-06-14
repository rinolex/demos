package com.HRManagementSystem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Unit Tests for the REST Controller API
 * 
 * @author Roman Nikolov
 *
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RestServiceControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private RestServiceController restServiceController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(restServiceController)
				.build();
	}

	/**
	 * Tests the add employee API
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRestAddEmployee() throws Exception {
		mockMvc
			.perform(post("/restAddEmployee")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	/**
	 * Tests the get employee by id API
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRestGetEmployee() throws Exception {
		mockMvc
			.perform(get("/restGetEmployee/{id}")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	/**
	 * Tests update employee by Id API
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRestUpdateEmployee() throws Exception {
		mockMvc
			.perform(put("/restUpdateEmployee/{id}")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	/**
	 * Tests delete employee by Id API
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRestDeleteEmployee() throws Exception {
		mockMvc
			.perform(delete("/restDeleteEmployee/{id}")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().is(200));
	}
}
