package com.example.goodcodestudy.testCode.user;

import java.util.Optional;

public interface UserInfoClient {
    Optional<UserInfo> findUserInfo(Long id);
}
