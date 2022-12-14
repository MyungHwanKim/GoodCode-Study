package com.example.goodcodestudy.testCode.infra.entity;

import com.example.goodcodestudy.testCode.exception.ExceptionCode;
import com.example.goodcodestudy.testCode.exception.ZeroBaseException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
public class BookStock {
    private int stock;

    public boolean enoughStock() {
        return stock > 0;
    }

    public void decreaseStock() {
        log.info("decreaseStock");
        if (stock <= 0) {
            throw new ZeroBaseException(ExceptionCode.NOT_ENOUGH_STOCK);
        }
        stock--;
    }
}
