package com.scaler.generics.staticUnderstanding;

public class Friend<T> {

    public static <U> void doSomethingElse(U u) {
        System.out.println("Printing u from static " + u);
    }

    public void something(T t) {
        System.out.println("Printing t from non static " + t);
    }

//    @Override
//    public String toString(){
//        return "Print friend from toString";
//    }

}
