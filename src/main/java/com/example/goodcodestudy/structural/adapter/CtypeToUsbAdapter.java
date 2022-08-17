package com.example.goodcodestudy.structural.adapter;

import com.example.goodcodestudy.structural.adapter.cable.CtypeCable;
import com.example.goodcodestudy.structural.adapter.cable.UsbCable;

public class CtypeToUsbAdapter implements UsbCable {

    private CtypeCable ctypeCable;

    public CtypeToUsbAdapter(CtypeCable ctypeCable) {
        this.ctypeCable = ctypeCable;
    }

    @Override
    public String getConnectDeviceName() {
        return ctypeCable.getCtypeConnectDeviceName();
    }
}
