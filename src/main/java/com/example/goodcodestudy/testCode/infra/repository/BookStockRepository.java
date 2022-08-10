package com.example.goodcodestudy.testCode.infra.repository;

import com.example.goodcodestudy.testCode.infra.entity.Book;
import com.example.goodcodestudy.testCode.infra.entity.BookStock;

import java.util.Optional;

public interface BookStockRepository {
    Optional<BookStock> findByBookId(long bookId);

    void save(BookStock bookStock);
}
