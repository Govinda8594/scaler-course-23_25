package com.scaler.Scaler.BinarySearch;

public class SquareRootOfNumber {
    public int sqrt1(int A) {
        long l = 0, r = A, ans = 0, mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (mid * mid <= A) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) Math.floor(ans);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public int sqrt(int A) {
        //base case
        if (A == 0) {
            return A;
        }
        long ans = -1;
        long l = 1, r = A;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (mid * mid == A) {//case 1
                return (int) mid;
            } else if (mid * mid < A) {//case 2 store it ans and check if there is any other value for sqrt(A)
                ans = mid;
                l = mid + 1;
            } else {//case 3 mid*mid>A so reduce the r=mid-1
                r = mid - 1;
            }
        }
        return (int) Math.floor(ans);
    }


}
