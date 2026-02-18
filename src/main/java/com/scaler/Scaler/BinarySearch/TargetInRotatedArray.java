package com.scaler.Scaler.BinarySearch;
//Given a sorted array of integers A of size N and an integer B,
//        where array A is rotated at some pivot unknown beforehand.
//        For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
//        Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
//        You can assume that no duplicates exist in the array.
//        NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
public class TargetInRotatedArray {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
        // lets consider array in 2 parts , part 1(rotated portion) and part 2.
        //if mid is in same part as target. we can apply normal BS.
        //thus if we bring target and mid in same part, we can use normal BS.
        // there are 2 cases .. if target in part 1 and mid in part 2.. then bring mid to part 1 and vice versa.
        //how we know mid or target is in which part.. by reference of A[0]..
        //by A[0]..if mid or target less then A[0] then it is in part 2. else in part 1.
        //lets use above logic to solve problem in one BS.
        int N = A.length;
        int l = 0, r = N - 1;

        while (l <= r) {
            int mid = l + r >> 1;
            if (A[mid] == B) {
                return mid;
            }
            //mid in part 2 and target in part 1.. lets move towards left.
            else if (A[mid] < A[0] && B >= A[0]) {
                r = mid - 1;
            }
            //mid in part 1 and target in part 2..lets move towards right.
            else if (A[mid] >= A[0] && B < A[0]) {
                l = mid + 1;
            } else if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int targetInRotatedArray(final int[] A, int B) {
        int n = A.length;

        int l = 0, r = n - 1;

        while (l <= r) {
            int m = (r + l) / 2;

            if (A[m] == B) {
                return m;
            }

            if (A[m] <= A[l]) {
                if (A[m] <= B && B <= A[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (A[l] <= B && B <= A[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
