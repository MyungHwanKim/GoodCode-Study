package com.example.goodcodestudy.behavioral.template_method;

import com.example.goodcodestudy.behavioral.template_method.keyboard.Keyboard;
import com.example.goodcodestudy.behavioral.template_method.keyboard.LoggingKeyboard;
import com.example.goodcodestudy.behavioral.template_method.keyboard.EscKeyMonitoringKeyboard;

public class main {
    public static void main(String[] args) {
        Keyboard keyboard = new LoggingKeyboard();
        Keyboard keyboard1 = new EscKeyMonitoringKeyboard();
        keyboard.press(new AlphabetKey("A"));
        keyboard.press(new AlphabetKey("B"));
        keyboard.press(new AlphabetKey("C"));
        System.out.println("------------------------");
        keyboard1.press(new AlphabetKey("A"));
        keyboard1.press(new AlphabetKey("B"));
        keyboard1.press(new AlphabetKey("C"));
        keyboard1.press(new AlphabetKey("ESC"));
    }
}
