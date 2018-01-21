package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/




public class Rectangle {
    public static void main(String[] args) {
    }

    private int top = 0;
    private int left = 0;
    private int width = 0;
    private int height = 0;

    public Rectangle(int left,int top,int width,int height){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }
    public Rectangle(int left,int top){
        this.left = left;
        this.top = top;
    }
    public Rectangle(int left,int top,int width){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }
    public Rectangle(){
        Rectangle rectangle = new Rectangle();
    }

}
