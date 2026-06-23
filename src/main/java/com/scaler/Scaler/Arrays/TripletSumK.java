package com.scaler.Scaler.Arrays;

import java.util.*;

public class TripletSumK {
//    public int solve(int[] A) {
//        int ans = 0;
//        int len = A.length;
//        for(int i = 0;i<len;i++){
//            int l=0,r=0;
//            for(int j = i-1;j>=0;j--){
//                if(A[j] < A[i])
//                    l++;
//            }
//            for(int k = i+1;k<len;k++){
//                if(A[k] > A[i])
//                    r++;
//            }
//            int count = l*r;
//            ans += count;
//        }
//        return ans;
//    }
//
//    public int solve2(int[] A) {
//        int len = A.length,ans = 0;
//        for(int i=0;i<len;i++){
//            for(int j=i+1;j<len;j++){
//                for(int k=j+1;k<len;k++){
//                    if(A[i] < A[j] && A[j] < A[k]){
//                        ans++;
//                    }
//                }
//            }
//        }
//        return ans;
//    }
    public static List<List<Integer>> findTriplets(int[] A,int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = A.length;
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

        List<List<Integer>> output = new ArrayList<>(result);
        output.sort((t1, t2) -> {
            for (int i = 0; i < 3; i++) {
                if (!t1.get(i).equals(t2.get(i))) {
                    return Integer.compare(t1.get(i), t2.get(i));
                }
            }
            return 0;
        });

        return output;
    }

    public static void main(String[] args) {
        int[] A = {1, -2, 1, 0, 2, -1};
        List<List<Integer>> triplets = findTriplets(A,-2);
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}
