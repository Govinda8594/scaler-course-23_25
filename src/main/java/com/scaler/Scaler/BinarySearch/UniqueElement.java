package com.scaler.Scaler.BinarySearch;

import java.util.Arrays;

public class UniqueElement {
    public static void main(String[] args) {
        int ans = uniqueElementBinary(new int[]{3, 3, 5, 5, 4, 4, 2, 1, 1});
    }

    static int uniqueElement(int[] A) {
        int len = A.length;
        int ans = 0;
        for (int j : A) {
            ans = ans ^ j;
        }
        return ans;
    }


    static int uniqueElementBinary(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        if (len == 1) {
            return A[0];
        }
        if (A[0] != A[1]) return A[0];
        if (A[len - 1] != A[len - 2]) return A[len - 1];
        int low = 1, high = len - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid - 1] != A[mid] && A[mid] != A[mid + 1]) return A[mid];
            if (A[mid - 1] == A[mid]) {
                mid = mid - 1;
            }
            if (mid % 2 == 0) low = mid + 2;
            else high = mid - 1;
        }
        return -1;
    }
}
