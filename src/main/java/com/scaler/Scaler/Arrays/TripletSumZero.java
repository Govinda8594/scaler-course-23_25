package com.scaler.Scaler.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class TripletSumZero {
    static void main(String[] args) {
// threeSumNLogN(new int[]{-1, 0, 1, 2, -1, 4});
//        threeSumCountBruteforce(new int[]{-1, 0, 1, 2, -1, 4});
//        threeSumN2(new int[]{-1, 0, 1, 2, -1, 4});
    }

    public static int[][] threeSumNLogN(int[] A) {
        int len = A.length;
        HashSet<ArrayList<Integer>> ans = new HashSet<>();
        Arrays.sort(A);
        for (int i = 0; i < len; i++) {
            if (i > 0 && A[i] == A[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int key = A[l] + A[r] + A[i];
                if (key == 0) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(A[l]);
                    pair.add(A[r]);
                    pair.add(A[i]);
                    ans.add(pair);
                    l++;
                    r--;
                    while (l < r && A[l] == A[l - 1]) l++;
                    while (l < r && A[r] == A[r + 1]) r--;
                } else if (key < 0)
                    l++;
                else
                    r--;
            }
        }
        int[][] temp = ans.stream()
                .map(l -> l.stream()
                        .mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        int countpair = temp.length;
        return temp;
    }

    public static int threeSumCountBruteforce(int[] A) {
        int len = A.length;
//        Arrays.sort(A);
        HashSet<ArrayList<Integer>> ans = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (A[i] <= A[j] && A[j] <= A[k]) {
                        if ((A[i] + A[j] + A[k]) == 0) {
                            ArrayList<Integer> pair = new ArrayList<>();
                            pair.add(A[i]);
                            pair.add(A[j]);
                            pair.add(A[k]);
                            Collections.sort(pair);
                            ans.add(pair);
                            System.out.println(ans);
                        }
                    }
                }
            }
        }
        return ans.size();
    }

    public static int[][] threeSumN2(int[] A) {
        int len = A.length;
        HashSet<ArrayList<Integer>> ans = new HashSet<>();
        for (int i = 0; i < len; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < len; j++) {
                int key = -(A[i] + A[j]);
                if (set.contains(key)) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(A[i]);
                    pair.add(A[j]);
                    pair.add(key);
                    Collections.sort(pair);
                    ans.add(pair);
                } else set.add(A[j]);
            }
        }
        int[][] temp = ans.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        int countpair = temp.length;
        return temp;
    }


}
