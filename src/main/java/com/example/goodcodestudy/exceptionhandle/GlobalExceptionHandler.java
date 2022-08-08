package com.example.goodcodestudy.exceptionhandle;

import com.example.goodcodestudy.exceptionhandle.exception.ZBException;
import com.example.goodcodestudy.exceptionhandle.type.ExceptionCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ZBException.class)
    public ResponseEntity<ErrorResult> runtimeException(ZBException e) {
        ExceptionCode errorCode = e.getCode();
        ErrorResult result = ErrorResult.builder()
                .code(errorCode.name())
//                .message(errorCode.getMessage())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(result, errorCode.getHttpStatus());
    }
}
