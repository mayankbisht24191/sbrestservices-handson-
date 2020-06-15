package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	public Country getCountry(String code) throws CountryNotFoundException{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = (ArrayList) context.getBean("countryList", ArrayList.class);
		Country country=null;
		for (Country country1 : countries) {
			if(country1.getCode().equalsIgnoreCase(code)) {
				country=country1;
			}
		}
		if(country==null) {
			throw new CountryNotFoundException();
		}
		return country;
		
	}

}
