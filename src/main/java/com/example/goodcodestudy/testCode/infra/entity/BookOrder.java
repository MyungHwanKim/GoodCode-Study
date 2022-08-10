package com.example.goodcodestudy.testCode.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BookOrder {
    private Long id;
    private User user;
    private Book book;
}
