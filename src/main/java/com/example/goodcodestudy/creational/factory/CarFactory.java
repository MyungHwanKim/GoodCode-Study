package com.example.goodcodestudy.creational.factory;

public class CarFactory {
    public Car createCar(EngineType electric) {
        if (electric.isElectric()) {
            return new ElectricCar();
        }

        if (electric.isHydrogen()) {
            return new HydrogenCar();
        }

        if (electric.isDiesel()) {
            return new DieselCar();
        }

        throw new RuntimeException("엔진이 저으이되지 않음");
    }
}
