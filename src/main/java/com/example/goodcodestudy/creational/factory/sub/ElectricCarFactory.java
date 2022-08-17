package com.example.goodcodestudy.creational.factory.sub;

import com.example.goodcodestudy.creational.factory.Car;
import com.example.goodcodestudy.creational.factory.ElectricCar;

public class ElectricCarFactory extends AbstractCarFactory{
    @Override
    public Car createCar() {
        return new ElectricCar();
    }
}
