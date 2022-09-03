package com.example.goodcodestudy.structural.decorator;

public class CaffeMocha implements Beverage {
    Beverage caffeLatte;
    int syrupPrice;
    public CaffeMocha(Beverage caffeLatte, int syrupPrice) {
        this.caffeLatte = caffeLatte;
        this.syrupPrice = syrupPrice;
    }

    @Override
    public String getName() {
        return "모카";
    }

    @Override
    public int getPrice() {
        return caffeLatte.getPrice() + syrupPrice;
    }
}
