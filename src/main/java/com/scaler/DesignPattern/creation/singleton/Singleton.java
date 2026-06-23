package com.scaler.DesignPattern.creation.singleton;

// Eager Initilization
class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

//Pros
//
//Simple
//Thread-safe
//No synchronization overhead
//
//Cons
//
//Instance is created even if not used


//Approach 2: Synchronized Method
class Singleton_2 {

    private static Singleton_2 instance_1;

    private Singleton_2() {}

    public static synchronized Singleton_2 getInstance() {
        if (instance_1 == null) {
            instance_1 = new Singleton_2();
        }

        return instance_1;
    }
}

//Pros
//
//Lazy initialization
//Thread-safe
//
//Cons
//
//Synchronization overhead on every call

//Approach 3: Double-Checked Locking
//Why volatile?
//volatile prevents instruction reordering and ensures visibility across threads.(MultiThread)
//Each thread may cache variables locally (CPU cache or registers).
//So one thread updates a variable, but another thread may still see old value.
//volatile ensures that changes made by one thread are immediately visible to other threads
// and prevents instruction reordering so that dependent operations execute in the
// intended order in a multithreaded environment.
//without volatile
//int data = 0;
//boolean ready = false;
//Thread 1
//data = 100;
//ready = true;
//
//JVM reoreder
//Step 1: ready = true
//Step 2: data = 100
//Thread 2
//if (ready) {
//        System.out.println(data); // wrong print 0
//ready becomes true first
//but data is still 0 (not updated yet)
class Singleton_5 {

    private static volatile Singleton_5 instance_5;

    private Singleton_5() {}

    public static Singleton_5 getInstance() {
        if (instance_5 == null) {
            synchronized (Singleton_5.class) {
                if (instance_5 == null) {
                    instance_5 = new Singleton_5();
                }
            }
        }

        return instance_5;
    }
}

//Approach 4: Bill Pugh Singleton
class Singleton_4 {

    private Singleton_4() {}

    private static class SingletonHolder {
        private static final Singleton_4 INSTANCE_4 = new Singleton_4();
    }

    public static Singleton_4 getInstance() {
        return SingletonHolder.INSTANCE_4;
    }
}

//Pros
//
//Lazy initialization
//Thread-safe
//No synchronization overhead
//
//This is one of the best approaches in Java.