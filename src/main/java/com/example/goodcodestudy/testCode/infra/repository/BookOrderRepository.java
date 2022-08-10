package com.example.goodcodestudy.testCode.infra.repository;

import com.example.goodcodestudy.testCode.infra.entity.BookOrder;

public interface BookOrderRepository {
    BookOrder save(BookOrder bookOrder);
}
