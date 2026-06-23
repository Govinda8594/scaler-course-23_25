package com.scaler.Scaler.Arrays;

import java.util.*;

public class TripletSumZero {
    static void main(String[] args) {
// threeSumNLogN(new int[]{-1, 0, 1, 2, -1, 4});
//        threeSumCountBruteforce(new int[]{-1, 0, 1, 2, -1, 4});
//        threeSumN2(new int[]{-1, 0, 1, 2, -1, 4});
    }

    public static int[][] threeSumNLogN(int[] A) {
      List<List<Integer>> result = new ArrayList<>();
                int n = A.length;
                int target = 0;
                Arrays.sort(A);

                for (int i = 0; i < n - 2; i++) {

                    // skip duplicates
                    if (i > 0 && A[i] == A[i - 1]) continue;

                    int left = i + 1;
                    int right = n - 1;

                    while (left < right) {
                        int sum = A[i] + A[left] + A[right];

                        if (sum == target) {
                            result.add(Arrays.asList(A[i], A[left], A[right]));

                            left++;
                            right--;

                            // skip duplicates
                            while (left < right && A[left] == A[left - 1]) left++;
                            while (left < right && A[right] == A[right + 1]) right--;

                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
        int[][] temp = result.stream()
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
