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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    UserInfoClient userInfoClient;
    @Mock
    BookStockRepository bookStockRepository;
    @Mock
    BookOrderRepository bookOrderRepository;

    @InjectMocks
    OrderService orderService;

    @BeforeEach
    void setUp() {
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(new Book(true, 0)));
        when(userInfoClient.findUserInfo(anyLong())).thenReturn(Optional.of(new UserInfo(20, false)));
        when(bookStockRepository.findByBookId(anyLong())).thenReturn(Optional.of(new BookStock(10)));

        when(bookOrderRepository.save(any(BookOrder.class))).thenReturn(new BookOrder(1L, null, null));
    }

    @Test
    void success() {
        // given
        Long orderId = orderService.order(User.asNew(1L), 1L);
        // when
        // then
        assertThat(orderId).isNotNull();

        verify(bookRepository).findById(anyLong());
        verify(userInfoClient).findUserInfo(anyLong());
        verify(bookStockRepository).findByBookId(anyLong());
        verify(bookOrderRepository).save(any(BookOrder.class));
    }

    @Test
    @DisplayName("❗ Book 존재하지 않으면 익셉션 발생(NOT_FOUND_BOOK)")
    void throwException_when_not_found_book() {
        // given when
        when(bookRepository.findById(anyLong())).thenReturn(Optional.empty());

        // then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZeroBaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.NOT_FOUND_BOOK);
    }

    @Test
    @DisplayName("❗ UserInfo 존재하지 않으면 익셉션 발생(USER_INFO_CLIENT_ERROR)")
    void throwException_when_not_found_userInfo() {
        // given when
        when(userInfoClient.findUserInfo(anyLong())).thenReturn(Optional.empty());

        // then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZeroBaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.USER_INFO_CLIENT_ERROR);
    }

    @Test
    @DisplayName("❗ BookStock 존재하지 않으면 익셉션 발생(NOT_FOUND_BOOK_STOCK)")
    void throwException_when_not_found_bookStock() {
        // given when
        when(bookStockRepository.findByBookId(anyLong())).thenReturn(Optional.empty());

        // then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZeroBaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.NOT_FOUND_BOOK_STOCK);
    }

    @Test
    @DisplayName("❗ 판매 중이지 않은 Book을 주문하면 익셉션 발생(BOOK_IS_NOT_SALE)")
    void throwException_when_is_not_sale() {
        // given
        Book book = Book.builder().sale(false).build();
        // when
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(book));

        // then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZeroBaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.BOOK_IS_NOT_SALE);
    }

    @Test
    @DisplayName("❗ 휴먼고객이 주문을 시도하면 익셉션 발생(FAIL_BOOK_ORDER)")
    void throwException_when_userInfo_id_dormant() {
        // given
        UserInfo userInfo = UserInfo.builder().dormant(true).build();
        // when
        when(userInfoClient.findUserInfo(anyLong())).thenReturn(Optional.of(userInfo));

        // then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZeroBaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.FAIL_BOOK_ORDER);
    }

    @Test
    @DisplayName("❗ 나이제한에 걸린 도서를 주문할 때 익셉션 발생(FAIL_BOOK_ORDER)")
    void throwException_when_check_enough_age() {
        // given
        Book book = Book.builder().minAge(20).sale(true).build();
        UserInfo userInfo = UserInfo.builder().age(15).dormant(true).build();
        // when
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(book));
        when(userInfoClient.findUserInfo(anyLong())).thenReturn(Optional.of(userInfo));

        // then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZeroBaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.FAIL_BOOK_ORDER);
    }

    @Test
    @DisplayName("❗ 재고가 부족할 때 도서를 주문하면 익셉션 발생(FAIL_BOOK_ORDER)")
    void throwException_when_check_enough_stock() {
        // given
        BookStock bookStock = BookStock.builder().stock(0).build();

        // when
        when(bookStockRepository.findByBookId(anyLong())).thenReturn(Optional.of(bookStock));

        // then
        assertThatThrownBy(() -> orderService.order(User.asNew(1L), 1L))
                .isInstanceOf(ZeroBaseException.class)
                .hasFieldOrPropertyWithValue("code", ExceptionCode.FAIL_BOOK_ORDER);
    }

    @Test
    @DisplayName("재고가 정상으로 차감된다")
    void success_when_decrease_stock() {
        // given
        final int stockCount = 10;
        BookStock bookStock = BookStock.builder().stock(stockCount).build();
        // when
        when(bookStockRepository.findByBookId(anyLong())).thenReturn(Optional.of(bookStock));
        orderService.order(User.asNew(1L), 1L);
        // then
        assertThat(bookStock.getStock()).isLessThan(stockCount);
    }
}