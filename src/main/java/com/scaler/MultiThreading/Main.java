package com.scaler.MultiThreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Adder adder = new Adder(5,6);
        Thread th = new Thread(adder);
        th.start();
        // wait();
        // join() current thread join the execution before main thread
        // join(1000) current thread will jon and execute for 1000 sec then main thread execute
        // sleep() current thread will sleep and with releaseing lock
        // sleep(1000) sleep current thread for specific time and other thread will execute
        // wait(1000) current thread release the lock for specific time and main thread will esecute
        // notify one theard is awaked
        // notifyAll  all thread are awaked

        // Cirtical section
        // race conditon
        // pre-emption - > cpu executed code half instruction => pre-stop

        // solution for sync Problem
        // 1- Mutual Exculsion => one thread allow CS at one time => Achieved by MUTEX
        // Progress => steady process for overall system
        // Bounded Waiting => No thread wait undefinite amout of time
        // Busy Waiting = > No Busy waiting / notify mechansim

        AtomicInteger atomicInteger = new AtomicInteger();
        // atomic is single unit instruction
        ExecutorService executorService = Executors.newFixedThreadPool(10);

            for (int i = 0; i < 10; i++) {
                adder = new Adder(i, i + 1);
                executorService.execute(adder);
            }

            for (int i = 0; i < 10; i++) {
                adder = new Adder(i, i + 1);
                Future<?> ans = executorService.submit(adder);
                System.out.println(ans.isDone());
            }

            List<Integer> ar1 = List.of(5,3,6,8,7);
            List<Integer> ar2 = List.of(5,2,3,3,0);
            ArrayAdder aarr2 = new ArrayAdder(ar1);
            ArrayAdder aarr1 = new ArrayAdder(ar2);
            Future<Integer> a  = executorService.submit(aarr2);
            Future<Integer> b =   executorService.submit(aarr1);
            if(a.isDone() && b.isDone())
              System.out.println(a.get() + b.get());


            MergeSorter mergeSorter = new MergeSorter(ar1,executorService);
            Future<List<Integer>> listFuture = executorService.submit(mergeSorter);
            List<Integer> sorted = listFuture.get();
            System.out.println("Sored "+sorted);
            executorService.shutdown();

            Thread evenT = new Thread(() -> {
                for(int i = 0; i< 100;i++){
                    if(i % 2 == 0){
                        System.out.println("Even Number =" + i);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
        Thread oddT = new Thread(() -> {
            for(int i = 0; i< 100;i++){
                if(i % 2 != 0){
                    System.out.println("Odd Number ="+ i);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        evenT.start();
        oddT.start();

            Lock reentrantLock = new ReentrantLock(true);
            /// No-difference when lock available trylock and lock
          ///  when lock unavialble on resourde lock will wait try,catch,finally willnot execute
                /// when unavailble trylock return true or fale and else will execute
            reentrantLock.lock(); //
            try {
            ///  critical session
            } finally {
                reentrantLock.unlock();
            }

            if(reentrantLock.tryLock()){
                try {
                    ///  critical session
                } finally {
                    reentrantLock.unlock();
                }
            }else {

            }


            // faster than noraml reentrantLock
            ReadWriteLock readWrtieLocke = new ReentrantReadWriteLock(true);

               Lock readock =  readWrtieLocke.readLock(); // all thread allow read;
        Lock writeLock = readWrtieLocke.writeLock(); // one thread allow to write





    }


}
