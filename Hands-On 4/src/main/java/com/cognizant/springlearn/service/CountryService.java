package com.cognizant.springlearn.service;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	private static ArrayList<Country> countries;

	public CountryService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		countries = (ArrayList) context.getBean("countryList", ArrayList.class);
	}

	public Country getCountry(String code) throws CountryNotFoundException {
		Country country = null;
		for (Country country1 : countries) {
			if (country1.getCode().equalsIgnoreCase(code)) {
				country = country1;
			}
		}
		if (country == null) {
			throw new CountryNotFoundException();
		}
		return country;

	}

	public void modifyCountry(Country country) {
		for (Country country1 : countries) {
			if (country.getCode().equals(country1.getCode())) {
				country1.setName(country.getName());
				break;
			}
		}
	}

	public void deleteCountry(String code) {
		for (Country country : countries) {
			if (country.getCode().equals(code)) {
				countries.remove(country);
				break;
			}
		}
	}
}
