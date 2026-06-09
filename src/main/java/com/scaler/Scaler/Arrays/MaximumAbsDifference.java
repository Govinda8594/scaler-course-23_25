package com.scaler.Scaler.Arrays;

public class MaximumAbsDifference {
    public static void main(String[] args) {
        maxABSDifference(new int[]{1, 3, -1});
    }
    // Expalnation :
// We have to find |A[i] - A[j]| + |i - j|
// for mod we can get four possiblities (+, +) , (+ , -), (- , +), (-, -)
// So we can write the above as
// (A[i] - A[j]) + (i - j) => (A[i] + i) - (A[j] + j)
// (A[i] - A[j]) - (i - j) => (A[i] - i) - (A[j] - j)
// -(A[i] - A[j]) + (i - j) => -(A[i] - i) + (A[j] - j)
// -(A[i] - A[j]) - (i - j) => -(A[i] + i) + (A[j] + j)
// So from the above we can see that we have to find only four pair
// A = A[i] + i = maxForI
// B = A[i] - i = minForI
// C = A[j] + j = maxForJ
// D = A[j] - j = minForJ

    static int maxABSDifference(int[] A) {
        int len = A.length, ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                ans = Math.max(ans, Math.abs(A[i] - A[j]) + Math.abs(i - j));
            }
        }
        return ans;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int maxArr(int[] A) {
        int maxForI = A[0];
        int maxForJ = A[0];
        int minForI = A[0];
        int minForJ = A[0];
        for (int i = 0; i < A.length; i++) {
            maxForI = Math.max(maxForI, A[i] + i);
            minForI = Math.min(minForI, A[i] + i);
            maxForJ = Math.max(maxForJ, A[i] - i);
            minForJ = Math.min(minForJ, A[i] - i);
        }
        return Math.max(maxForI - minForI, maxForJ - minForJ);
    }
}
