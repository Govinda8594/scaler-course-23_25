package com.scaler.Scaler.BitManipulation;

public class CountSubArraywithBitwise1s {
    public static void main(String[] args) {
//        long ans = SubArraywithBitwise1s(3,new int[]{1,0,1});
        long ans = countSubarraysWithNonZeroOR2(3,new int[]{1,0,1});
    }


        public static long countSubarraysWithNonZeroOR(int[] B) {
            int n = B.length;
            long totalSubarrays = (long) n * (n + 1) / 2;
            long zeroORSubarrays = 0;

            int start = 0;
            while (start < n) {
                if (B[start] != 0) {
                    start++;
                    continue;
                }

                int end = start;
                while (end < n && B[end] == 0) {
                    end++;
                }

                int len = end - start;
                zeroORSubarrays += (long) len * (len + 1) / 2;
                start = end;
            }

            return totalSubarrays - zeroORSubarrays;
        }


    public static long countSubarraysWithNonZeroOR2(int A,int[] B) {
        int n = B.length;
        long count = 0;
        int or = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            or |= B[right];

            if (or == 0) {
                // All zeros so far
                count += (right - left + 1);
            } else {
                // Reset window
                left = right + 1;
                or = 0;
            }
        }

        long total = (long) n * (n + 1) / 2;
        return total - count;
    }
}
