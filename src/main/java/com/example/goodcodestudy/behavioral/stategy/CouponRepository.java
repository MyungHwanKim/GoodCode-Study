package com.example.goodcodestudy.behavioral.stategy;

import java.util.Optional;

public interface CouponRepository {
    Optional<Coupon> findById(long id);
}
