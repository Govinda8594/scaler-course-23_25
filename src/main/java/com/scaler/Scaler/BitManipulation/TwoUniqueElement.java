package com.scaler.Scaler.BitManipulation;

//Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
//        Find the two integers that appear only once.
//
//        Note: Return the two numbers in ascending order.
public class TwoUniqueElement {
    public static void main(String[] args) {
    }

    static int[] getTwoUniqueElements(int[] elements) {
        int num = 0;
        for (int element : elements) {
            num = num ^ element;
        }
        int position = 0;
        for (int i = 0; i < 30; i++) {
            if ((num >> i & 1) == 1) {
                position = i;
                break;
            }
        }
        int set = 0, unset = 0;
        for (int element : elements) {
            if ((element >> position & 1) == 1) {
                set = set ^ element;
            } else unset = unset ^ element;
        }
        return new int[]{set, unset};
    }

    static int[] getTwoUniqueElementsFrom1ToNplus2ElementInArray(int[] elements) {
        int num1 = 0, num2 = 0;
        int len = elements.length;
        int n = len + 2;
        for (int element : elements) {
            num1 = num1 ^ element;
        }
        for (int i = 1; i <= n; i++) {
            num2 = num2 ^ i;
        }
        int xornum = num1 ^ num2;
        int position = 0;
        for (int i = 0; i < 30; i++) {
            if ((xornum >> i & 1) == 1) {
                position = i;
                break;
            }
        }
        int set = 0, unset = 0;
        for (int element : elements) {
            if ((element >> position & 1) == 1) {
                set = set ^ element;
            } else unset = unset ^ element;
        }
        for (int i = 1; i <= n; i++) {
            if ((i >> position & 1) == 1) {
                set = set ^ i;
            } else unset = unset ^ i;
        }
        return new int[]{set, unset};
    }

    static boolean checkBit(int A, int pos) {
        return (((A >> pos) & 1) == 1);
    }

    public int[] solve(int[] A) {
        //Step 1: XOR of all elements
        int val = 0;
        for (int ele : A) {
            val ^= ele;
        }
        //Step 2:Get set bit pos for value
        int pos = 0;
        for (int i = 0; i < 32; i++) {
            if (checkBit(val, i)) {
                pos = i;
                break;
            }
        }
        //Step 3: Split A[] based on the pos bit
        int set = 0, unset = 0;
        for (int ele : A) {
            if (checkBit(ele, pos)) {
                set ^= ele;
            } else {
                unset ^= ele;
            }
        }
        //Step 4: Set and unset contains the two unque elements
        int a = Math.min(unset, set);
        int b = Math.max(unset, set);
        return new int[]{a, b};
    }
}
