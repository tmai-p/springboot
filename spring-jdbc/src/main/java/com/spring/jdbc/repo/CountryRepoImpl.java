package com.spring.jdbc.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.model.Country;

@Repository
public class CountryRepoImpl implements CountryRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Country> getAllCountry() {
		return jdbcTemplate.query("select * from country", 
                (rs, rowNum) -> new Country(
                		rs.getString("code"), 
                		rs.getString("name"),  
                		rs.getString("continent"),  
                		rs.getString("region"), 
                		rs.getFloat("surfaceArea"), 
                		rs.getInt("indepYear"), 
                		rs.getInt("population"), 
                		rs.getFloat("lifeExpectancy"), 
                		rs.getFloat("gnp"), 
                		rs.getFloat("gnpOld"), 
                		rs.getString("localName"), 
                		rs.getString("governmentForm"), 
                		rs.getString("headOfState"), 
                		rs.getInt("capital"), 
                		rs.getString("code2"))
                );
	}

}
