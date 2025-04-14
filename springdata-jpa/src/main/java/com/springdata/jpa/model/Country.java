package com.springdata.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String code;
	private String name;

	public Country() {
		super();
	}

	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

}
