package com.example.goodcodestudy.structural.adapter;

import com.example.goodcodestudy.structural.adapter.cable.LightningCable;

public class IPhone implements LightningCable {
    @Override
    public String getLightningConnectDeviceName() {
        return getClass().getSimpleName();
    }
}
