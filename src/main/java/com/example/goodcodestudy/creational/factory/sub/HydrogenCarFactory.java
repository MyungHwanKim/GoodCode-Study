package com.example.goodcodestudy.creational.factory.sub;

import com.example.goodcodestudy.creational.factory.Car;
import com.example.goodcodestudy.creational.factory.HydrogenCar;

public class HydrogenCarFactory extends AbstractCarFactory {
    @Override
    public Car createCar() {
        return new HydrogenCar();
    }
}
