package com.example.goodcodestudy.structural.adapter;

public class Main {
    public static void main(String[] args) {

        MacBook macBook = new MacBook();      // C-type
        IPhone iPhone = new IPhone();         // 8-pin
        PortablePan pan = new PortablePan();  // USB

        PortableCharger portableCharger = new PortableCharger();  // USB
        portableCharger.charge(pan);
        portableCharger.charge(new CtypeToUsbAdapter(macBook));
        portableCharger.charge(new CtypeToUsbAdapter(new LightningCableToCtypeAdapter(iPhone)));
        // 8pin -> USB X
        // 8PIN -> C type -> USB O
    }
}
