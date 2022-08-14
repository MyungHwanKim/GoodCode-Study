package com.example.goodcodestudy.creational.builder;

public class SimpleUser {
    private long id;
    private String name;
    private int age;
    private String address;
    private String phoneNumber;

    public SimpleUser(SimpleUserBuilder simpleUserBuilder) {
            this.id = simpleUserBuilder.userInfo.getId();
            this.name = simpleUserBuilder.userInfo.getName();
            this.age = simpleUserBuilder.userInfo.getAge();
            this.address = simpleUserBuilder.userAddress.mergedAddress();
            this.phoneNumber = simpleUserBuilder.userInfo.getPhoneNumber();
    }

    public static SimpleUserBuilder builder() {
        return null;
    }

    public static class SimpleUserBuilder {
        private UserInfo userInfo;
        private UserAddress userAddress;

        public SimpleUserBuilder userInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
            return this;
        }

        public SimpleUserBuilder userAddress(UserAddress userAddress) {
            this.userAddress = userAddress;
            return this;
        }

        public SimpleUser build() {
            return new SimpleUser(this);
        }
    }
}