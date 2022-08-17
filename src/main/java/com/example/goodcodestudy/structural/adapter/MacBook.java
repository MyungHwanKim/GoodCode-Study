package com.example.goodcodestudy.structural.adapter;

import com.example.goodcodestudy.structural.adapter.cable.CtypeCable;

public class MacBook implements CtypeCable {

    @Override
    public String getCtypeConnectDeviceName() {
        return getClass().getSimpleName();
    }
}
