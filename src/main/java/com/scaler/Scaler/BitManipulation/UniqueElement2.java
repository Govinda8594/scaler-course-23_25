package com.scaler.Scaler.BitManipulation;

//Given an array of integers, every element appears thrice except for one, which occurs once.
//        Find that element that does not appear thrice.
public class UniqueElement2 {
    public int singleNumber(final int[] A) {
        int ans = 0;
        int c;
        for (int i = 0; i <= 30; i++) {
            c = 0;
            for (int k : A) {
                int bool = (k >> i) & 1;
                if (bool == 1)
                    c++;
            }
            if (c % 3 == 1)
                ans += (1 << i);
        }
        return ans;
    }

    public int singleNumberRepeat5and1(final int[] A) {
        int ans = 0;
        int c;
        for (int i = 0; i <= 30; i++) {
            c = 0;
            for (int k : A) {
                int bool = (k >> i) & 1;
                if (bool == 1)
                    c++;
            }
            if (c % 5 == 1)
                ans += (1 << i);
        }
        return ans;
    }

    public int singleNumberRepeat5and2(final int[] A) {
        int ans = 0;
        int c;
        for (int i = 0; i <= 30; i++) {
            c = 0;
            for (int k : A) {
                int bool = (k >> i) & 1;
                if (bool == 1)
                    c++;
            }
            if (c % 5 == 2)
                ans += (1 << i);
        }
        return ans;
    }

    public int singleNumberRepeat3and2(final int[] A) {
        int ans = 0;
        int c;
        for (int i = 0; i <= 30; i++) {
            c = 0;
            for (int k : A) {
                int bool = (k >> i) & 1;
                if (bool == 1)
                    c++;
            }
            if (c % 3 == 2)
                ans += (1 << i);
        }
        return ans;
    }
}
