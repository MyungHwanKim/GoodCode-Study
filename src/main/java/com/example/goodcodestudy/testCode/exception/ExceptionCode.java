package com.example.goodcodestudy.testCode.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {
    NOT_FOUND_BOOK(500, "도서를 찾을 수 없습니다."),
    NOT_FOUND_BOOK_STOCK(500, "재고를 찾을 수 없습니다."),
    USER_INFO_CLIENT_ERROR(500, "유저 정보 조회에 실패하였습니다."),
    BOOK_IS_NOT_SALE(500, "판매중인 도서가 아닙니다."),

    NOT_ENOUGH_STOCK(500, "재고가 부족합니다."),

    FAIL_BOOK_ORDER(500, "도서 주문에 실패하였습니다.");

    private final int code;
    private final String message;
}
