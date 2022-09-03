package com.example.goodcodestudy.structural.decorator;

public class Water implements Beverage {
    @Override
    public String getName() {
        return "물";
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
