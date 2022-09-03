package com.example.goodcodestudy.structural.decorator;

public class Espresso implements Beverage {

    @Override
    public String getName() {
        return "에소프레소";
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
