package com.scaler.Scaler.Arrays;

public class MinumumBulbON {
    public static void main(String[] args) {
//        MinumumBulbON()
    }
        public int MinumumBulbON(int[] A) {
            int len = A.length;
            int cost = 0;
            for(int i = 0;i<len;i++){
                if(cost % 2 != 0) A[i] = 1 - A[i]; //flip the blub
                if(A[i] != 1) cost++;
            }
            return cost;
        }
}
