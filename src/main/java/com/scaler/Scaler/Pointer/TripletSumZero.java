package com.scaler.Scaler.Pointer;

import java.util.*;
//Jerry is excited about an array that Tom gave him. The array A consists of N integers.
//        Tom challenges Jerry to find all such unique triplets a, b, c in A such that a + b = - c.
public class TripletSumZero {

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (A == null) {
            return res;
        }
        Collections.sort(A);
        int n = A.size();
        for (int low = 0; low < n - 2; low++) {
            int mid = low + 1;
            int high = n - 1;
            int sum = -A.get(low);
            if (low > 0 && A.get(low).intValue() == A.get(low - 1).intValue()) {
                continue;
            }
            while (mid < high) {
                int num = A.get(mid) + A.get(high);
                if (num == sum) {
                    temp.add(A.get(low));
                    temp.add(A.get(mid));
                    temp.add(A.get(high));
                    res.add(new ArrayList(temp));
                    temp.clear();
                    int prev = mid;
                    while (mid <= high && A.get(mid).intValue() == A.get(prev).intValue()) {
                        mid++;
                    }
                } else if (num < sum) {
                    mid++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }

    ///////////////////////////////////////////////////////////////////
    public int[][] threeSum(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        HashSet<List<Integer>> hashset = new HashSet<>();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int target = -A[i];
            int start = i + 1, end = n - 1;
            while (start < end) {
                int sum = A[start] + A[end];
                if (sum == target) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(A[i]);
                    arr.add(A[start++]);
                    arr.add(A[end--]);
                    if (!hashset.contains(arr)) {
                        hashset.add(arr);
                        res.add(arr.stream().mapToInt(Integer::intValue).toArray());
                    }
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        int outSize = res.size();
        int[][] out = new int[outSize][3];
        for (int i = 0; i < outSize; i++) {
            out[i] = res.get(i);
        }
        return out;
    }
}
