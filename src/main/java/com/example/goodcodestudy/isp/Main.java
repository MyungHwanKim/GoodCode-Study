package com.example.goodcodestudy.isp;

public class Main {
    public static void main(String[] args) {
        // 마린, 메딕
        // unit
        Moveable marine = new Marine();
        Attackable attackMarine = new Marine();
        marine.move();
        attackMarine.attack();

        Moveable medic = new NonAttackUnit();
        medic.move();
    }
}
