package com.scaler.Scaler.GreedyProblem;

//You are given a string A consisting of 1's and 0's. Now the task is to make the string consisting of only 1's. But you are allowed to perform only the following operation:
//
//        Take exactly B consecutive string elements and change 1 to 0 and 0 to 1.
//        Each operation takes 1 unit time, so you have to determine the minimum time required to only make the string of 1's. If not possible, return -1.
public class MinimumTimeForBinaryString1_0_and_0_1 {
    // 00010110 B = 3
    public static void main(String[] args) {
        solve("00010110", 3);
    }

    public static int solve(String A, int B) {
        int flip = 0, count = 0, len = A.length();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            int ch = A.charAt(i) - '0';
            flip = flip + arr[i]; // Keep track of the number of flips (to reflip the 1)
            // 1 check => If ch is 0, and flip is 0 then do flip in next i + B length substring
            // 2 check => If ch is 1, if flip is 0 no change but flip is 1 need to reflip because it was previously flipped to 0,
            // so calculate the answer again
            if ((ch == 0 && (flip & 1) == 0) || (ch == 1 && (flip & 1) == 1)) {
                if (i + B - 1 >= len) {
                    return -1; // If the substring exceeds the length, return -1
                }
                count++; // Increment the count of valid substrings
                flip++; // Update the flip count
                if (i + B < len) {
                    arr[i + B] += -1; // Adjust the array for future calculations
                }
            }
        }
        return count; // Return the total count of valid substrings
    }
}
