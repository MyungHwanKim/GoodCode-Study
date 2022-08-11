package com.example.goodcodestudy.isp;

public class Marine implements Moveable, Attackable {
    @Override
    public void move() {
        System.out.println("마린이 이동합니다.");
    }

    @Override
    public void attack() {
        System.out.println("마린이 공격합니다.");
    }
}
