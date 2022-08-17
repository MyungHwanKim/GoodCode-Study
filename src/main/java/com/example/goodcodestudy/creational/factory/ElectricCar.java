package com.example.goodcodestudy.creational.factory;

public class ElectricCar implements Car {
    @Override
    public void whatIsCar() {
        System.out.println(getClass().getSimpleName());
    }
}
