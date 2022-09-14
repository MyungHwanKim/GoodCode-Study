package com.example.goodcodestudy.behavioral.template_method;

import com.example.goodcodestudy.behavioral.template_method.key.KeyboardKey;

public class AlphabetKey implements KeyboardKey {
    private String keyName;
    public AlphabetKey(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public String getKey() {
        return keyName;
    }
}
