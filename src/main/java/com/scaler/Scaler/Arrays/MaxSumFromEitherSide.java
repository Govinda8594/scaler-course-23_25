package com.scaler.Scaler.Arrays;

public class MaxSumFromEitherSide {
    public static void main(String[] args) {
        MaxSumFromEitherSide obj = new MaxSumFromEitherSide();
        int[] A = {5, -2, 3 , 1, 2};
        int B = 3;
        System.out.println(obj.MaxSumFromEitherSide(A,B));

    }
        public int MaxSumFromEitherSide(int[] A, int B) {
            int currentSum = 0,len = A.length,ans = 0;
            for(int i = 0;i<B;i++){
                ans+=A[i];
            }
            currentSum = ans;
            int idx = B - 1;
            for(int j = len-1;j >= len-B;j--){
                currentSum += A[j];
                currentSum -= A[idx];
                idx--;
                ans = Math.max(currentSum,ans);
            }
            return ans;
        }

}
