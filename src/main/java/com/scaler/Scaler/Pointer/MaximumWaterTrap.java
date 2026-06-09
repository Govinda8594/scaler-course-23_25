package com.scaler.Scaler.Pointer;
//Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).
//        N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
//        Find two lines, which together with x-axis forms a container, such that the container contains the most water. You need to return this maximum area.
//        Note: You may not slant the container. It is guaranteed that the answer will fit in integer limits.
public class MaximumWaterTrap {
    static int maximumtrappedWater(int[] A){
        int len = A.length;
        int waterTrapped = 0;
        for(int i = 0; i < len; i++){
            for (int j = i; j < len;j++){
                int height = Math.min(A[i], A[j]);
                int width = j - i;
                waterTrapped  = Math.max(height * width,waterTrapped);
            }
        }
        return waterTrapped;
    }
    ///////////////////////////////////////////////////////////////////////////////////
    public int maxArea(int[] A) {
            int i = 0, j = A.length - 1, ans = 0;
            while (i < j) {
                int height = Math.min(A[i], A[j]);
                int width = j - i;
                int water = height * width;
                ans = Math.max(ans, water);
                if (A[j] < A[i]) {
                    j--;
                } else if (A[i] <= A[j]) {
                    i++;
                }
            }
            return ans;
        }
}
