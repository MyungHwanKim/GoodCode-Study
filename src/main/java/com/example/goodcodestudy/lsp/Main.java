package com.example.goodcodestudy.lsp;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(4);
        rectangle.setHeight(5);

        System.out.println(rectangle.getArea()); // 20

        Square square = new Square();
        square.setWidth(4);
        square.setHeight(5);

        System.out.println(square.getArea());  // 25

    }
}
