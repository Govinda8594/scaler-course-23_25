package com.scaler.Scaler.Queues;

import java.util.LinkedList;
import java.util.Queue;
//Given an integer A, you have to find the Ath Perfect Number.
//
//        A Perfect Number has the following properties:
//
//        It comprises only 1 and 2.
//        The number of digits in a Perfect number is even.
//        It is a palindrome number.
//        For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

public class AthPerfectNumberIsPalindrome {
    public String solve2(int A) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        for (int i = 1; i < A; i++) {
            String s = q.poll();
            q.add(s + "1");
            q.add(s + "2");
        }
        assert q.peek() != null;
        return q.peek().concat(new StringBuilder(q.peek()).reverse().toString());
    }

}
