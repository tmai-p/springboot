package com.springdata.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata.jpa.model.Country;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 * JpaRepository will have all the functions of
 * CrudRepository and
 * PagingAndSortingRepository
 */
public interface CountryRepo extends JpaRepository<Country, String> {

    @Query(value="select * from country where code = ?1", nativeQuery = true)
    Country findCountryByCode(String code);

    @Query(value="select * from country where continent = ?1", nativeQuery = true)
    List<Country> findCountryByContinent(String continent);
}
