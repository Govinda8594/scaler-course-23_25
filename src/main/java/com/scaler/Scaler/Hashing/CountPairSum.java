package com.scaler.Scaler.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class CountPairSum {
    public static void main(String[] args) {
//        int A[] = new int[]{1,2,3,2,1};
//        solve3(A,5);
        int[] arr = {1, 5, 7, -1};
        int n = arr.length;
        int k = 6;
        // Function call
//        System.out.println("Count of pairs is "
//                + getPairsCount(arr, n, k));
    }

    // lowerBound implementation
    public static int lowerBound(int[] arr, int start,
                                 int end, int key) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // upperBound implementation
    public static int upperBound(int[] arr, int start,
                                 int end, int key) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }


    public int solve1(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            int x = k - arr[i];
            int y = lowerBound(arr, i + 1, n, x);
            int z = upperBound(arr, i + 1, n, x);
            c = c + z - y;
        }
        return c % 1000000007;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int bruteforce(int[] A, int B) {
        int size = A.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (A[i] + A[j] == B)
                    count++;
            }
        }
        return count;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : A) {
            int k = B - num;
            if (map.containsKey(k)) count += map.get(k);
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        return count % 1000000007;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve2(int[] A, int B) {
        // working only for if array element are duplicate
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int count = 0;
        for (int j : A) {
            if (sumMap.containsKey(B - j)) {
                count += sumMap.get(B - j);
            }
            sumMap.put(j, sumMap.getOrDefault(j, 0) + 1);
        }
        return count % 1000000007;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
//    public List<int[]> pairSum(int[] arr, int s) {
//        // Write your code here.
//        List<int[]> ans = new ArrayList<>();
//        int[] pair = null;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] + arr[j] == s)
//                    pair = new int[2];
//                pair[0] = arr[i];
//                pair[1] = arr[j];
//                ans.add(pair);
//            }
//        }
//        return ans;
//    }

    public int solve3(int[] A, int B) {
        // working only for if array element are distinct
        Arrays.sort(A);
        int count = 0, i = 0, j = A.length - 1;
        while (i < j) {
            int k = A[i] + A[j];
            if (k == B) {
                i++;
                j--;
                count++;
            } else if (k > B) {
                j--;
            } else {
                i++;
            }
        }
        return count;
    }

    ///////////////////////////////////////////////////////////////////////////
    public int countpairSum(int[] A, int B) {
        // working only for if array element are +ve and -ve
        int size = A.length;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int count = 0;
        for (int j : A) {
            sumMap.put(j, sumMap.getOrDefault(j, 0) + 1);
        }
        for (int a : A) {
            int b = B - a;
            if (a != b && sumMap.containsKey(b))
                count++;
            if (a == b && sumMap.get(a) > 1) {
                count++;
            }
        }
        return count % 1000000007;
    }
}
