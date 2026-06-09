package com.scaler.Scaler.GreedyProblem;

import java.util.ArrayList;

//There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
//        There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
//        An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
//        Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.
//        In one jump a person can move to the adjacent seat (if available).
//        NOTE: 1. Return your answer modulo 107 + 3.
public class FillEmptySeatTogeather {
    public int seats1(String A) {
        int n = A.length();
        long mod = 10000003, totalx = 0, leftx = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                totalx++;
            }
        }
        // ....x..xx...x..
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                leftx++;
            } else {
                ans = (ans + Math.min(leftx, totalx - leftx)) % mod;
            }
        }
        return (int) ans;
    }

    public int seats3(String A) {
        ArrayList<Integer> index = new ArrayList<>();
        long mod = 10000003;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x')
                index.add(i);
        }
        if (index.isEmpty())
            return 0;
        if (index.size() == A.length())
            return 0;
        int mid = index.size() / 2;
        long ans = 0;
        for (int i = 0; i < index.size(); i++) {
            ans = (ans + Math.abs(index.get(i) - (index.get(mid) - mid + i))) % mod;
        }
        return (int) ans;
    }

}
