package com.example.goodcodestudy.structural.facade;

public class Mainboard {
    public ReadOnlyMemory supply(Power power) {
        return new ReadOnlyMemory();
    }
}
