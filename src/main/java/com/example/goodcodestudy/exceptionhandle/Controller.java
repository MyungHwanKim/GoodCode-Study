package com.example.goodcodestudy.exceptionhandle;

import com.example.goodcodestudy.exceptionhandle.exception.ZBException;
import com.example.goodcodestudy.exceptionhandle.type.ExceptionCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/exception")
    public void error() {
//        throw new ZBException(ExceptionCode.INTERNAL_ERROR);
        throw new ZBException(ExceptionCode.INTERNAL_ERROR, "바뀐 에러문구입니다.");
    }
}
