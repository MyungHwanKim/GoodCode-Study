package com.example.goodcodestudy.testCode.infra.repository;

import com.example.goodcodestudy.testCode.infra.entity.Book;
import com.example.goodcodestudy.testCode.infra.entity.BookOrder;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(long bookId);
}
