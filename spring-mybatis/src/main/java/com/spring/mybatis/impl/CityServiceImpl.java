package com.spring.mybatis.impl;

import com.spring.mybatis.mapper.CityMapper;
import com.spring.mybatis.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityMapper {
    private final CityMapper cityMapper;

    /*
     * Injecting mapper
     */
    public CityServiceImpl(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public List<City> findByCountryCode(String countryCode) {
        return this.cityMapper.findByCountryCode(countryCode);
    }
}
