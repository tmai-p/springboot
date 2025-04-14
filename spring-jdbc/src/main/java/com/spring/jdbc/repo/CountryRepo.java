package com.spring.jdbc.repo;

import java.util.List;

import com.spring.jdbc.model.Country;

public interface CountryRepo {
	
	List<Country> getAllCountry();

}
