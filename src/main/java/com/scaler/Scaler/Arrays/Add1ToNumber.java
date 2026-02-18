package com.scaler.Scaler.Arrays;

import java.util.ArrayList;

public class Add1ToNumber {
    public static void main(String[] args) {
        plusOne(new int[]{1, 2, 3});
    }

    public static int[] plusOne(int[] A) {
        int len = A.length, carry = 1;
        // add  one from right to left and carry forward question
        for (int i = len - 1; i >= 0; i--) {
            if (carry > 0) {
                A[i] += carry;
                carry = A[i] / 10;
                if (carry == 1) {
                    A[i] = A[i] % 10;
                }
            }
        }
        int[] ans = {0};
        // check the prefix is 0 present and count 0 with no carry
        if (A[0] == 0 && carry == 0) {
            int countZero = 0, idx = -1;
            for (int i = 0; i < len; i++) {
                if (A[i] == 0) {
                    countZero++;
                    idx = i; // update index till non -zero value
                } else break;
            }
            ans = new int[len - countZero]; // create new array
            System.arraycopy(A, idx + 1, ans, 0, len - countZero);// copy existing array
//            ans = Arrays.copyOfRange(A, idx + 1, len);
        } else if (carry > 0) {
            ans = new int[len + 1];
//            System.arraycopy(A, 0, ans, 1, len);
            System.arraycopy(A, 1, ans, 1, len - 1);
            ans[0] = carry; // append the carry to front if carry is non-zero
        }
        return carry > 0 || A[0] == 0 ? ans : A;
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        int num;
        int size = A.size();
        // traversing the digits of the number in reverse order
        for (int i = size - 1; i >= 0; i--) {
            num = A.get(i);
            num += carry;
            carry = 0;
            if (num == 10) {
                num = 0;
                carry = 1;
            }
            A.set(i, num);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (carry == 1)
            res.add(1);
        for (int x : A) {
            if (x == 0 && res.isEmpty())
                continue;
            res.add(x);
        }
        return res;
    }
}
