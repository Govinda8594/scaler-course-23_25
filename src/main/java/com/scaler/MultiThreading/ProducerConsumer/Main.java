package com.scaler.MultiThreading.ProducerConsumer;

import javax.management.Query;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Queue<Object> q = new ConcurrentLinkedQueue<>();
        int maxSize = 6;

        Semaphore ps = new Semaphore(maxSize);
        Semaphore cs = new Semaphore(0);
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i=0; i<8; i++){
            Producer producer = new Producer(q,maxSize,"producer "+i,ps,cs);
            es.execute(producer);
        }

        for(int i=0; i<20; i++){
            Consumer consumer = new Consumer(q,maxSize,"consumer "+i,ps,cs);
            es.execute(consumer);
        }

        es.shutdown();
    }
}
