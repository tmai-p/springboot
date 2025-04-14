package com.spring.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jdbc.model.Country;
import com.spring.jdbc.repo.CountryRepo;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/api")
public class CountryController {

	@Autowired
	CountryRepo countryRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/country-list")
	public ResponseEntity<List<Country>> listOfCountry() {
		
		List<Country> country = new ArrayList<>();
		
		log.info("Retrieving a list of country");
		try {
			country = countryRepo.getAllCountry();
			if (country.isEmpty()) {
				log.debug("List of country is: {}", country);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(country, HttpStatus.OK);
			}
		}
		catch (Exception e) {
			log.error("Error retrieving a list of country: ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
