package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {
	@NotNull
	@Size(min=2, max=2, message="Country code should be 2 characters")
	private String code;
	private String name;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public Country() {
		LOGGER.debug("Inside Country Constructor.");
	}

	public String getCode() {
		LOGGER.debug("Inside code's getter.");
		return code;
	}

	public void setCode(String code) {
		LOGGER.debug("Inside code's setter.");
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("Inside name's getter.");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside name's setter.");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
}