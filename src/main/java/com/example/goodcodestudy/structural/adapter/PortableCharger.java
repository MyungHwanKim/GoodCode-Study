package com.example.goodcodestudy.structural.adapter;

import com.example.goodcodestudy.structural.adapter.cable.UsbCable;

public class PortableCharger {

    public void charge(UsbCable usbCable) {
        System.out.println("PortableCharger : " + usbCable.getConnectDeviceName() +  " USB 충전중...");
    }
}
