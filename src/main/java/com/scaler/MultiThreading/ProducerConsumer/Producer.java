package com.scaler.MultiThreading.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private Queue<Object> que;
    private int maxSize;
    private String name;
    private Semaphore ps;
    private Semaphore cs;
    public Producer(Queue<Object> queue, int size,String id,Semaphore poducer,Semaphore consumer) {
        que = queue;
        maxSize = size;
        name  =id;
        ps = poducer;
        cs = consumer;
    }
    @Override
    public void run() {
            while (true) {
                synchronized (que) {
                    if (que.size() < this.maxSize) {
                        System.out.println("Adding " + que.size());
                        que.add(new Object());
                    }
                }
            }
    }
}
