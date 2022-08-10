package com.example.goodcodestudy.testCode;

import com.example.goodcodestudy.testCode.exception.ExceptionCode;
import com.example.goodcodestudy.testCode.exception.ZeroBaseException;
import com.example.goodcodestudy.testCode.infra.entity.Book;
import com.example.goodcodestudy.testCode.infra.entity.BookOrder;
import com.example.goodcodestudy.testCode.infra.entity.BookStock;
import com.example.goodcodestudy.testCode.infra.entity.User;
import com.example.goodcodestudy.testCode.infra.repository.BookOrderRepository;
import com.example.goodcodestudy.testCode.infra.repository.BookRepository;
import com.example.goodcodestudy.testCode.infra.repository.BookStockRepository;
import com.example.goodcodestudy.testCode.user.UserInfo;
import com.example.goodcodestudy.testCode.user.UserInfoClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {
    private final BookRepository bookRepository;
    private final UserInfoClient userInfoClient;
    private final BookStockRepository bookStockRepository;
    private final BookOrderRepository bookOrderRepository;

    public Long order(User user, long bookId) {
        Book book = findBook(bookId);
        UserInfo userInfo = findUserInfo(user);
        BookStock bookStock = findBookStock(bookId);

        checkOnSale(book);
        checkDormant(userInfo);
        checkEnoughAge(book, userInfo);
        checkEnoughStock(bookStock);

        bookStock.decreaseStock();
        bookStockRepository.save(bookStock);
        BookOrder bookOrder = bookOrderRepository.save(createBookOrder(user, book));
        return bookOrder.getId();
    }

    private BookStock findBookStock(long bookId) {
        return bookStockRepository.findByBookId(bookId)
                .orElseThrow(() -> new ZeroBaseException(ExceptionCode.NOT_FOUND_BOOK_STOCK));
    }

    private UserInfo findUserInfo(User user) {
        return userInfoClient.findUserInfo(user.getId())
                .orElseThrow(() -> new ZeroBaseException(ExceptionCode.USER_INFO_CLIENT_ERROR));
    }

    private Book findBook(long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ZeroBaseException(ExceptionCode.NOT_FOUND_BOOK));
    }

    private BookOrder createBookOrder(User user, Book book) {
        return BookOrder.builder()
                .user(user)
                .book(book)
                .build();
    }

    private void checkEnoughStock(BookStock bookStock) {
        if (!bookStock.enoughStock())
            throw new ZeroBaseException(ExceptionCode.FAIL_BOOK_ORDER, "도서 재고가 부족합니다.");
    }

    private void checkEnoughAge(Book book, UserInfo userInfo) {
        if (!book.enoughAge(userInfo.getAge()))
            throw new ZeroBaseException(ExceptionCode.FAIL_BOOK_ORDER, "나이 제한이 걸려서 주문할 수 없습니다.");
    }

    private void checkDormant(UserInfo userInfo) {
        if (userInfo.isDormant())
            throw new ZeroBaseException(ExceptionCode.FAIL_BOOK_ORDER, "휴먼고객은 주문할 수 없습니다.");
    }

    private void checkOnSale(Book book) {
        if (!book.onSale())
            throw new ZeroBaseException(ExceptionCode.BOOK_IS_NOT_SALE);
    }
}
