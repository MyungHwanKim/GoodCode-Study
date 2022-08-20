package com.example.goodcodestudy.structural.facade;

public class ReadOnlyMemory {
    public Bios getBios() {
        return new Bios();
    }
}
