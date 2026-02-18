package com.scaler.Scaler.MathDSA.GeneralProblem;

import java.util.ArrayList;

public class CountFactors {
    public static void main(String[] args) {
        System.out.println(allDivisor(12));
    }

    public static Integer[] allDivisor(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sqrt = (int) Math.sqrt(A);
        for (int i = 1; i <= A; i++) {
            if (A % i == 0 || A / i == i)
                ans.add(i);
        }
        return ans.toArray(new Integer[ans.size()]);
    }

    public int solve(int A) {
        int count = 0;
        int sqrt = (int) Math.sqrt(A);
        for (int i = 1; i <= sqrt; i++) {
            if (A % i == 0 && i * i != A)
                count += 2;
            else if (i * i == A)
                count++;
        }
        return count;
    }
}
