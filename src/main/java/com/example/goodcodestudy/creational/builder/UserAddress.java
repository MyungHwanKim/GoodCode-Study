package com.example.goodcodestudy.creational.builder;

import lombok.Getter;

@Getter
public class UserAddress {
    private String city;
    private String citySubName;
    private String countryName;

    public String mergedAddress() {
        return city + citySubName + countryName;
    }
}
