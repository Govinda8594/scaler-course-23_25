package com.scaler.InterviewCodingQuestionPractice;

public class MinJumps {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 5, 2, 0, 9, 0, 7, 7, 5};
        int jump = minimumJumps(arr, arr.length);
    }

    public static int minimumJumps(int[] arr, int N) {
        // Write your code here
        int jumps = 0, i = 0;

        while (i <= N - 1) {
            if (i == N - 1) break;
            int val = 0, k = -1;
            /**
             *k is denoting the shop which is most beificial to jump at
             * this is because the val i.e index of that shop + jumps gained by landing on it is maximum in range i+1 to i+arr[i]
             *if in doing so he reaches the n-1 shop it means we got our ans i.e jumps+1
             *otherwise we set i to k and repeat the while loop.
             **/

            for (int j = i + 1; j <= i + arr[i]; j++) { // find best possible arr[j] for jumping
                if (j >= N - 1) return jumps + 1;
                if (j + arr[j] > val) {
                    val = j + arr[j];
                    k = j;
                }
            }
            if (k == -1) return -1;
            jumps++;
            i = k; // most beneficial jump idx so far
        }

        return jumps;
    }

    public int jump(int[] nums) {
        int jumps = 0, currEnd = 0, farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }

        return jumps;
    }


    public int minJumps(int[] nums) {
        return jumpFrom(0, nums);
    }

    private int jumpFrom(int position, int[] nums) {
        if (position >= nums.length - 1) return 0; // already at or beyond end

        int min = Integer.MAX_VALUE;
        int maxJump = nums[position];

        for (int step = 1; step <= maxJump; step++) {
            int nextPos = position + step;
            if (nextPos < nums.length) {
                int jumps = jumpFrom(nextPos, nums);
                if (jumps != Integer.MAX_VALUE) {
                    min = Math.min(min, jumps + 1);
                }
            }
        }

        return min;
    }

    ///////////////////////////////////////Check - CanReachEND

    public boolean canJumpFrom(int[] nums, int position) {
        if (position >= nums.length - 1) return true;

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int next = position + 1; next <= furthestJump; next++) {
            if (canJumpFrom(nums, next)) return true;
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFrom(nums, 0);
    }

    public boolean canJump2(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // ❌ can't reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

}
