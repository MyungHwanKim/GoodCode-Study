package com.example.goodcodestudy.creational.factory.sub;

import com.example.goodcodestudy.creational.factory.Car;
import com.example.goodcodestudy.creational.factory.DieselCar;

public class DieselCarFactory extends AbstractCarFactory {
    @Override
    public Car createCar() {
        return new DieselCar();
    }
}
