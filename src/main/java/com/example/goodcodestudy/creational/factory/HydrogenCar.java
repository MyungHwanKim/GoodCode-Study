package com.example.goodcodestudy.creational.factory;

public class HydrogenCar implements Car {
    @Override
    public void whatIsCar() {
        System.out.println(getClass().getSimpleName());
    }
}
