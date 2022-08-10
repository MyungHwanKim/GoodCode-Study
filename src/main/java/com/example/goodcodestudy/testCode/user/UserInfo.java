package com.example.goodcodestudy.testCode.user;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class UserInfo {
    private int age;
    private boolean dormant;

    public boolean isDormant() {
        return dormant;
    }

    public int getAge() {
        return age;
    }
}
