package com.scaler.Scaler.BinarySearch;

public class FindAthMagicalNumberWhichIsDivisibleByBandC {

    public int gcd(int x, int y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
    }

    public int solve(int A, int B, int C) {
        // lcm of B and C
        long lcm = (long) B * C / gcd(B, C);
        long low = 2, high = ((long)A * Math.min(B, C)) , ans = 0;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            // f(x) = x / B + x / C - x / lcm(B, C)
            long cntB = mid / B, cntC = mid / C, cntBC = mid / lcm;
            if (cntB + cntC - cntBC >= A) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return (int)(ans % (1000 * 1000 * 1000 + 7));
    }
///////////////////////////////////////////////////////////////////////////
    public int solve1(int A, int B, int C) {
        long low = Math.min(B, C);
        long high = A * low;
        long lcm = lcm(B, C);
        long mod = (long) Math.pow(10, 9) + 7;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sum = (mid / B + mid / C - mid / lcm);
            if (sum < A) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)(low % mod);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, Math.abs(b - a));
    }
}
