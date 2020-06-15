package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.GlobalExceptionHandler;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	@Autowired
	CountryService countryservice;
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	@GetMapping("/countries")
	public ArrayList<Country> getAllCountries() {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = (ArrayList) context.getBean("countryList", ArrayList.class);
		return countries;
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("Start");
		return countryservice.getCountry(code);
	}

	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.debug("Start");
		return country;
	}
	@PutMapping("/countries")
	public void modifyCountry(@RequestBody Country country) {
		countryservice.modifyCountry(country);
	}
	@DeleteMapping("/countries/{code}")
	public void deleteCountry(@PathVariable String code)
	{
		countryservice.deleteCountry(code);
	}
	
}