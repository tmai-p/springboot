package com.spring.mybatis.mapper;

import com.spring.mybatis.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {
    @Select("select * from city where countryCode = #{countryCode}")
    List<City> findByCountryCode(@Param("countryCode") String countryCode);
}
