package com.spring.mybatis.controller;

import com.spring.mybatis.impl.CityServiceImpl;
import com.spring.mybatis.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class CityController {

    @Autowired
    CityServiceImpl cityService;
    //CityMapper cityMapper;      uses MybatisConfig class

    @GetMapping("/city-list")
    public ResponseEntity<List<City>> getCity() {
        List<City> city = cityService.findByCountryCode("USA");
        return new ResponseEntity<List<City>>(city, HttpStatus.OK);
    }

}
