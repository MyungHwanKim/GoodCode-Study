package com.example.goodcodestudy.behavioral.stategy;

import java.util.Optional;

public class MockCouponRepository implements CouponRepository {
    @Override
    public Optional<Coupon> findById(long id) {
        if (id <= 0) {
            return Optional.empty();
        }

        if (id < 100) {
            return Optional.of(new PercentageCoupon(10));
        }
        return Optional.of(new DiscountCoupon(2000));
    }
}
