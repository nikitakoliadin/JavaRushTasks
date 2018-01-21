package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    public static void main(String[] args) {
    }
    private int top;
    private int left;
    private int width;
    private int height ;

    public void initialize(int left, int top, int width, int height){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }
    public void initialize(int left, int top){
        this.left = left;
        this.top = top;
    }
    public void initialize(int left, int top, int width){
        this.left = left;
        this.top = top;
        this.width = width;
    }
    public void initialize(){
        Rectangle rectangle = new Rectangle();
    }
}
