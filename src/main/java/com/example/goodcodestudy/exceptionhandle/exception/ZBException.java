package com.example.goodcodestudy.exceptionhandle.exception;

import com.example.goodcodestudy.exceptionhandle.type.ExceptionCode;
import lombok.Getter;

@Getter
public class ZBException extends RuntimeException {
    private final ExceptionCode code;

    public ZBException(ExceptionCode code) {
        this.code = code;
    }

    public ZBException(String message, ExceptionCode code) {
        super(message);
        this.code = code;
    }

    public ZBException(String message, Throwable cause, ExceptionCode code) {
        super(message, cause);
        this.code = code;
    }

    public ZBException(Throwable cause, ExceptionCode code) {
        super(cause);
        this.code = code;
    }

    public ZBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ExceptionCode code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public ZBException(ExceptionCode code, String message) {
        super(message);
        this.code = code;
    }

    public ZBException(ExceptionCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
