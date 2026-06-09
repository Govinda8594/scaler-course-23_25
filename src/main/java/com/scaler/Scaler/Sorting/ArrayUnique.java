package com.scaler.Scaler.Sorting;

public class ArrayUnique {
        public static void main(String[] args) {

            int[] nums = {1,1,2,2,3,3,4,4,4,6,6,9};
            int n = nums.length;

            int uniqueIndex = 0;

            // ✅ Step 1: Move uniques to front
            for (int i = 0; i < n; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    nums[uniqueIndex++] = nums[i];
                }
            }

            // ✅ Step 2: Append duplicates AFTER uniques
            int write = uniqueIndex;

            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    nums[write++] = nums[i];
                }
            }

            // ✅ Print result
            System.out.print("Output: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }

            System.out.println("\nUnique length: " + uniqueIndex);
        }
}
