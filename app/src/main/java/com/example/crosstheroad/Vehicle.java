//package com.example.crosstheroad;
//
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//
//public class Vehicle {
//    protected int speed;
//    protected int size;
//    protected int xPosition;
//    protected int yPosition;
//    protected Bitmap sprite;
//
//    // Constructor
//    public Vehicle(int speed, int size, int xPosition, int yPosition, Bitmap sprite) {
//        this.speed = speed;
//        this.size = size;
//        this.xPosition = xPosition;
//        this.yPosition = yPosition;
//        this.sprite = sprite;
//    }
//    public void move() {
//        xPosition -= speed;
//    }
//
//    public void draw(Canvas canvas) {
//        Rect src = new Rect(0, 0, sprite.getWidth(), sprite.getHeight());
//        Rect dst = new Rect(xPosition, yPosition, xPosition + size, yPosition + size);
//        canvas.drawBitmap(sprite, src, dst, null);
//    }
//
//    // Getters and setters
//    public int getSpeed() {
//        return speed;
//    }
//
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }
//
//    public int getXPosition() {
//        return xPosition;
//    }
//
//    public void setXPosition(int xPosition) {
//        this.xPosition = xPosition;
//    }
//
//    public int getYPosition() {
//        return yPosition;
//    }
//
//    public void setYPosition(int yPosition) {
//        this.yPosition = yPosition;
//    }
//
//    public Bitmap getSprite() {
//        return sprite;
//    }
//
//    public void setSprite(Bitmap sprite) {
//        this.sprite = sprite;
//    }
//
//}