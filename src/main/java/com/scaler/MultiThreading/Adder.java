package com.scaler.MultiThreading;

public class Adder implements Runnable{

    int a;
    int b;

    public Adder(int x,int y){
        this.a = x;
        this.b = y;
    }

    @Override
   public void run(){
        System.out.println(Thread.currentThread().getName()+" "+ a + b);
    }
}
