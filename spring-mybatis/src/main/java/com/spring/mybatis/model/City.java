package com.spring.mybatis.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class City implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;
}
