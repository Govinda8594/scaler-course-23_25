package com.scaler.Scaler.Arrays;

import java.util.ArrayList;

public class LeaderInArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int len = A.size();
        ArrayList<Integer> res = new ArrayList<>(len);
        int max = A.get(len-1);
        res.add(max);
        for(int i = len-2;i>=0;i--){
            if(A.get(i) > max){
                max = A.get(i);
                res.add(max);
            }
        }
        return res;
    }
}
