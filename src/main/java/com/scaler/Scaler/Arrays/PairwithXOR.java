package com.scaler.Scaler.Arrays;

import java.util.HashSet;

public class PairwithXOR {

    public int PairwithXOR(int[] A, int B) {
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        for (int num : A) {
            //a^b =c;   a^b^a = c^a ;  (a^a = 0, 0^b = b) ;  b = c^a; (c^a = a^c) => b = a^c
            hs.add(num);
        }

        for (int num : A) {
            int val = num ^ B;
            if (hs.contains(val)) {
                count++;
            }
        }
        return count / 2;
    }
}
