package com.example.goodcodestudy.structural.adapter;

import com.example.goodcodestudy.structural.adapter.cable.CtypeCable;
import com.example.goodcodestudy.structural.adapter.cable.LightningCable;

public class LightningCableToCtypeAdapter implements CtypeCable {

    LightningCable lightningCable;

    public LightningCableToCtypeAdapter(LightningCable lightningCable) {
        this.lightningCable = lightningCable;
    }

    @Override
    public String getCtypeConnectDeviceName() {
        return lightningCable.getLightningConnectDeviceName();
    }
}
