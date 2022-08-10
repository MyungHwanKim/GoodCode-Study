package com.example.goodcodestudy.testCode.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Book {
    private boolean sale;
    private int minAge;

    public boolean onSale() {
        return sale;
    }

    public boolean enoughAge(int age) {
        return this.minAge <= age;
    }
}
