package com.scaler.MultiThreading;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value value = new Value();

        Lock lock = new ReentrantLock(true);

        AdderLock AdderLock = new AdderLock(value, lock);
        SubtractorLock SubtractorLock = new SubtractorLock(value, lock);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> adderFuture = es.submit(AdderLock);
        Future<Void> substractorFuture = es.submit(SubtractorLock);


        adderFuture.get();
        substractorFuture.get();

        System.out.println("value.value = " + value.value);

        es.shutdown();
    }

}

class Value {
    int value = 0;


}

class AdderLock implements Callable<Void> {

    Value val;
    Lock lock;

    public AdderLock(Value val, Lock lock) {
        this.val = val;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for(int i=0; i<=50; i++){
            lock.lock();
            System.out.println("Requesting lcok for AdderLock "+i);
            Thread.sleep(1000);
            val.value += i;
            System.out.println("Added "+i);
            System.out.println("val.value = " + val.value);
            lock.unlock();
        }
        return null;
    }
}

 class SubtractorLock implements Callable<Void> {

    Value val;
    Lock lock;

    public SubtractorLock(Value val, Lock lock) {
        this.val = val;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for(int i=0; i<=50; i++){
            lock.lock();
            System.out.println("Requesting lcok for SubtractorLock "+i);
            Thread.sleep(1000);
            val.value -= i;
            System.out.println("SubtractorLock "+i);
            System.out.println("val.value = " + val.value);
            lock.unlock();
        }
        return null;
    }
}
