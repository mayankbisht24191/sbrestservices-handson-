package com.cognizant.springlearn;


import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import com.cognizant.springlearn.controller.CountryController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc 
public class SpringLearnApplicationTests {
	
	@Autowired
	private CountryController countryController;
	
	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNotNull(countryController);
	}
	@Test
	public void testGetCountry() throws Exception {
	ResultActions actions = mvc.perform(get("/country"));
	actions.andExpect(status().isOk());
	actions.andExpect(jsonPath("$.code").exists());
	actions.andExpect(jsonPath("$.code").value("IN"));
	}
	@Test
	public void testGetCountryException() throws Exception{
		ResultActions actions = mvc.perform(get("/countries/ll"));
		actions.andExpect(status().isBadRequest());
		actions.andExpect(status().reason("Country not found"));
	}
	@Test
	public void testGetEmployeeException() throws Exception{
		ResultActions actions = mvc.perform(get("/employees/6"));
		actions.andExpect(status().reason("Employee not found"));
	}
}