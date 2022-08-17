package com.example.goodcodestudy.structural.adapter;

import com.example.goodcodestudy.structural.adapter.cable.UsbCable;

public class PortablePan implements UsbCable {
    @Override
    public String getConnectDeviceName() {
        return getClass().getSimpleName();
    }
}
