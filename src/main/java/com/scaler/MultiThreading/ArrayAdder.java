package com.scaler.MultiThreading;

import java.util.List;
import java.util.concurrent.Callable;

public class ArrayAdder implements Callable<Integer> {

    List<Integer> elements;
    public ArrayAdder(List<Integer> element) {
        this.elements = element;
    }

    public Integer call(){
        int sum = 0;
        for (Integer element : elements) {
            sum += element;
        }
        return sum;
    }
}
