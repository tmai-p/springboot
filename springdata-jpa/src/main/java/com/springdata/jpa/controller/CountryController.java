package com.springdata.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdata.jpa.model.Country;
import com.springdata.jpa.repo.CountryRepo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("api")
public class CountryController {

	private final CountryRepo countryRepo;

    public CountryController(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @GetMapping("/home")
	public ResponseEntity<String> displayHome() {
		return new ResponseEntity<>("Spring data JPA home", HttpStatus.OK);
	}
	
	@GetMapping("/country-list")
	public ResponseEntity<List<Country>> listOfCountry() {

		log.info("Retrieving list of country");
		try {
			List<Country> country = countryRepo.findAll();
			return new ResponseEntity<>(country, HttpStatus.OK);
		}
		catch (Exception e) {
			log.error("Error: ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/country-code")
	public ResponseEntity<Country> getCountryByCode(@RequestHeader("code") String code) {
		log.info("Get country by code [{}]", code);
		Country c = countryRepo.findCountryByCode(code);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@GetMapping("/filter-continent")
	public ResponseEntity<List<Country>> getCountryByContinent(@RequestHeader("continent") String continent) {
		log.info("Get list of country by continent [{}]", continent);
		List<Country> list = countryRepo.findCountryByContinent(continent);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
