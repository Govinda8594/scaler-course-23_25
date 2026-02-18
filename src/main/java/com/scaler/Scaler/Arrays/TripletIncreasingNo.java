package com.scaler.Scaler.Arrays;

public class TripletIncreasingNo {
    public static void main(String[] args) {
        countTripletsincreasingOrderOptimize(new int[]{2, 1, 2, 3});
    }

    static int countTripletsincreasingOrderOptimize(int[] A){
        int len = A.length,ans = 0;
        for(int i=0;i<len;i++){
            int smallest = 0;
            for(int j=i-1;j>=0;j--){
                if(A[j] < A[i]) {
                    smallest++;
                }
            }
            int largest = 0;
            for(int k=i+1;k<len;k++){
                    if(A[i] < A[k]){
                        largest++;
                    }
                }
            int count = smallest*largest;
            ans += count;

        }
        return ans;
    }

    static int countTripletsincreasingOrder(int[] A){
        int len = A.length,ans = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j+1;k<len;k++){
                    if(A[i] < A[j] && A[j] < A[k]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
