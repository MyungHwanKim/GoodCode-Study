package com.example.goodcodestudy.structural.decorator;

public interface Beverage {
    String getName();

    int getPrice();

    default void printPrice() {
        System.out.println(getName() + " 가격은 " + getPrice() + "원입니다.");
    }
}
