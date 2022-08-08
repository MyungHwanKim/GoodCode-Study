package com.example.goodcodestudy.exceptionhandle;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResult {
    String code;
    String message;
}
