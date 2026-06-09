package com.scaler.Scaler.Hashing;

import java.util.HashSet;

public class PairsWithGivenXor {

    public int solve2(int[] A, int B) {
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        for (int j : A) {
            //a^b =c;   a^b^a = c^a ;  (a^a = 0, 0^b = b) ;  b = c^a; (c^a = a^c) => b = a^c
            hs.add(j);
        }

        for (int j : A) {
            int val = j ^ B;
            if (hs.contains(val)) {
                count++;
            }
        }
        return count / 2;
    }
}
