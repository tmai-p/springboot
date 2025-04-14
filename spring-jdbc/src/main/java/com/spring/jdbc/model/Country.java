package com.spring.jdbc.model;

import lombok.Data;

@Data
public class Country {
	private String code;
	private String name;
	private String continent;
	private String region;
	private float surfaceArea;
	private int indepYear;
	private int population;
	private float lifeExpectancy;
	private float gnp;
	private float gnpOld;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private int capital;
	private String code2;
	
	public Country(String code, String name, String continent, String region, float surfaceArea, int indepYear,
			int population, float lifeExpectancy, float gnp, float gnpOld, String localName, String governmentForm,
			String headOfState, int capital, String code2) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surfaceArea = surfaceArea;
		this.indepYear = indepYear;
		this.population = population;
		this.lifeExpectancy = lifeExpectancy;
		this.gnp = gnp;
		this.gnpOld = gnpOld;
		this.localName = localName;
		this.governmentForm = governmentForm;
		this.headOfState = headOfState;
		this.capital = capital;
		this.code2 = code2;
	}
	
	
}
