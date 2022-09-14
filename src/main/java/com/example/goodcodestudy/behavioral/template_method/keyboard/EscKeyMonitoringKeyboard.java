package com.example.goodcodestudy.behavioral.template_method.keyboard;

import com.example.goodcodestudy.behavioral.template_method.key.KeyboardKey;

public class EscKeyMonitoringKeyboard extends Keyboard {
    @Override
    protected void keyUp(KeyboardKey key) {
        if (isEscKey(key)) {
            System.out.println("ESC logging...key up : " + key.getKey());
        }
    }

    @Override
    protected void keyDown(KeyboardKey key) {
        if (isEscKey(key)) {
            System.out.println("ESC logging...key up : " + key.getKey());
        }
    }

    private boolean isEscKey(KeyboardKey key) {
        return "ESC".equalsIgnoreCase(key.getKey());
    }
}
