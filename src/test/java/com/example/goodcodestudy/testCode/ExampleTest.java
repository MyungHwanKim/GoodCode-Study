package com.example.goodcodestudy.testCode;

import com.example.goodcodestudy.testCode.infra.entity.BookStock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class ExampleTest {
    // 상태 테스트
    @Test
    @DisplayName("BookStock 재고가 없으면 false")
    void enough_stock_test() {
        // given
        BookStock bookStock = BookStock.builder()
                .stock(0)
                .build();
        // when
        // then
        assertThat(bookStock.enoughStock()).isFalse();
    }

    @Test
    @DisplayName("BookStock 재고를 확인한다.")
    void stock_check() {
        // given
        BookStock bookStock = BookStock.builder()
                .stock(10)
                .build();
        // when
        // then
        assertThat(bookStock.getStock()).isEqualTo(10);
        assertThat(bookStock.enoughStock()).isTrue();
    }

    @Test
    @DisplayName("BookStock 재고가 감소한다..")
    void stock_decrease_test() {
        // given
        final int stockCount = 10;
        BookStock bookStock = BookStock.builder()
                .stock(stockCount)
                .build();
        // when
        bookStock.decreaseStock();
        // then
        assertThat(bookStock.getStock()).isLessThan(stockCount);
    }

    // 행위 테스트
    @Test
    void test() {
        // given
        BookStock mock = Mockito.mock(BookStock.class);
        // when
        mock.decreaseStock();
        // then
        verify(mock, atLeastOnce()).decreaseStock();
    }
}
