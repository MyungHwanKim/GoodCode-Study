package com.example.goodcodestudy.creational.factory;

public enum EngineType {
    ELECTRIC,
    DIESEL,
    HYDROGEN;

    public boolean isElectric() {
        return this == ELECTRIC;
    }

    public boolean isHydrogen() {
        return this == HYDROGEN;
    }

    public boolean isDiesel() {
        return this == DIESEL;
    }
}
