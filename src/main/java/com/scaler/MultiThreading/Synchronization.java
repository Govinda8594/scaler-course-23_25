package com.scaler.MultiThreading;

public class Synchronization {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        Thread thread = new Thread(new AdderCount(inventoryCounter));
        Thread thread1 = new Thread(new SubstractCount(inventoryCounter));

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(inventoryCounter.getCount());

    }
}

class  AdderCount implements Runnable {
    private InventoryCounter inventoryCounter;

    public  AdderCount(InventoryCounter counter){
        inventoryCounter = counter;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            this.inventoryCounter.increment();
        }
    }
}

class  SubstractCount implements Runnable {
    private InventoryCounter inventoryCounter;

    public  SubstractCount(InventoryCounter counter){
        inventoryCounter = counter;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            this.inventoryCounter.decrement();
        }
    }
}


class InventoryCounter {

    private int count;

    InventoryCounter(){
        count = 0;
    }

     synchronized void increment(){
        this.count++;
    }

     synchronized void decrement(){
        this.count--;
    }

    int getCount(){
        return count;
    }
}
