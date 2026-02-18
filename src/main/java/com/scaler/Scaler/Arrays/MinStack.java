package com.scaler.Scaler.Arrays;

import java.util.ArrayList;

public class MinStack {

    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> minList = new ArrayList<>();

    public void push(int x) {
        a.add(x);
        minList(x);
    }

    public void pop() {
        if (a.size() == 0) {
            return;
        }
        int deletedElement = a.remove(a.size() - 1);
        if (!minList.isEmpty()) {
            minList.remove(deletedElement);
        }
    }

    public int top() {
        if (a.size() == 0) {
            return -1;
        }
        return a.get(a.size() - 1);
    }

    public int getMin() {
        return (minList.isEmpty()) ? -1 : minList.get(0);
    }

    public void minList(int i) {
        if (minList.isEmpty()) {
            minList.add(i);
        } else {
            int j = 0;
            while (j < minList.size()) {
                if (minList.get(j) < i) {
                    j++;
                } else {
                    minList.add(j, i);
                    break;
                }
            }
        }
    }
}
