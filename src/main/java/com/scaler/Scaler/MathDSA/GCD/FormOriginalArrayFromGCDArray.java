package com.scaler.Scaler.MathDSA.GCD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FormOriginalArrayFromGCDArray {
    public static void main(String[] args) {
        solve(new int[]{2, 2, 2, 2, 8, 2, 2, 2, 10});
    }

    public static int[] solve(int[] A) {
        int n = A.length;
        int interval = (int) Math.sqrt(n);
        int[] res = new int[interval];
        int max = 0;
        int count = 0, k = 0;

        for (int j : A) {
            if (j > max) max = j;
            count++;
            if (count == interval) {
                res[k++] = max;
                max = 0;
                count = 0;
            }
        }
        return res;
    }

    public static int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Collections.sort(A, Collections.reverseOrder());
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        // mp stores the count of A[i]'s that are to be deleted from the array
        for (int x : A) {
            if (mp.containsKey(x) && mp.get(x) > 0)
                mp.put(x, mp.get(x) - 1);
            else {
                for (Integer an : ans) {
                    int g = gcd(an, x);
                    // we are adding 2 to the mp as there will 2 pairs gcd(ans[j],A[i]) and gcd(A[i],ans[j])
                    mp.put(g, mp.getOrDefault(g, 2) + 2);
//                    if (mp.containsKey(g))
//                        mp.put(g, mp.get(g) + 2);
//                    else
//                        mp.put(g, 2);

                }
                ans.add(x);
            }
        }
        return ans;
    }
}
