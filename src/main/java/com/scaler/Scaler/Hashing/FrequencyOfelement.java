package com.scaler.Scaler.Hashing;

import java.util.HashMap;

public class FrequencyOfelement {
    public int[] solve(int[] A, int[] B) {
        int len = A.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i = 0;i<len;i++){
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }
        int[] res= new int[B.length];
        for(int i = 0;i<B.length;i++){
            res[i] = map.getOrDefault(B[i],0);
        }
        return res;
    }
}
