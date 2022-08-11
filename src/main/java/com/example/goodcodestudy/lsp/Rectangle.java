package com.example.goodcodestudy.lsp;

import lombok.Setter;

@Setter
public class Rectangle {
    private int width; // 가로
    private int height; // 세로

    public int getArea() {
        return width * height;
    }
}
