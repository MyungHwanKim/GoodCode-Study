package com.example.goodcodestudy.structural.facade;

public class BootLoader {
    public OperationSystem findOperationSystem(HardDiskDrive hdd) {
        return new OperationSystem();
    }
}
