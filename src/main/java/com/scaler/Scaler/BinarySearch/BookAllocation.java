package com.scaler.Scaler.BinarySearch;

import java.util.ArrayList;
//Given an array of integers A of size N and an integer B.
//
//        The College library has N books. The ith book has A[i] number of pages.
//
//        You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
//
//        A book will be allocated to exactly one student.
//        Each student has to be allocated at least one book.
//        Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

public class BookAllocation {
    public int books(int[] A, int B) {
        int n = A.length;
// since each student should at least get one book, allocation cannot happen if no. of students are greater than no. of books available.
        if (n < B) {
            return -1;
        }
// let's say an array has [10, 20, 30, 40, 50]
// if we need to allocate these books to 5 students, then certainly one student gets 50. Therefore the max here is 50.
// if we need to allocate these books to only one student, then this student gets all pages i.e., sum of all pages which is 150.
// In the worst case, a student gets 150 pages. In the best case, he gets 50. So the answer space lies from 50 to 150.
// let's say there are only two students s1 and s2.
// the possible cases are --> a) first 4 books to s1 and last book to s2 ==> (100, 50), max is 50. b) first 3 books to s1 and last two books to s2 ==> (60, 90), max is 90
// c) first two books to s1 and last three books to s2 ==> (30, 120), max is 120
// d) first book to s1 and remaining to s2 ==> (10, 140), max is 140
// Among 100, 90, 120, 140 the least max is 90 and our target is just this that is to minimize the maximum distance possible.
// search space: from max of an array to the sum of the array.
        long max = A[0];
        long sum = A[0];
        for (int i = 1; i < n; i++) {
            sum += A[i];
            if (A[i] > max) {
                max = A[i];
            }
        }
// our answer is to find the
// minimum possible maximum pages allocated. Since in the worst case, all pages are allocated to one, that is the sum.. let's initialize our ans variable with sum here.
        long ans = sum;
        long l = max;
        long h = sum;
// target is to find the minimum possible. So by logic it suggests us that we may find an even minimum answer than the current if we move left from mid.
        while (l <= h) {
            long m = (l + h) / 2;
            if (check(A, B, m)) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) ans;
    }

    public boolean check(int[] arr, int k, long m) {
        long s = 0;
// first book is allocated to first student here. So we start our count from 1.
// if at a point s exceeds m, then the book that's present at that point would be allocated to the next student and we update our count now.
        int count = 1;
        for (int j : arr) {
            s += j;
            if (s > m) {
                count++;
                s = j;
            }
            if (count > k) {
                return false;
            }
        }
        return true;
    }

    /// /////////////////////////////////////////////////////////////////////////////////////////////////

    public int books(ArrayList<Integer> A, int B) {
        long high = Long.MAX_VALUE;
        long low = 0;
        long mid, res = 0;
        if (B > A.size()) {
            return -1;
        }
        long sum = 0;
        for (int pages : A) {
            sum += pages;
        }
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (isPossible(A, B, mid, sum)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) res;
    }

    private boolean isPossible(ArrayList<Integer> A, int B, long maxPage, long totalPages) {
        if (maxPage < totalPages / B) {
            return false;
        }
        int index = 0;
        int n = A.size();
        int i;
        for (i = 0; i < B && index < n; i++) {
            long total = 0;
            while (total < maxPage && index < n) {
                total += A.get(index);
                if (total > maxPage) {
                    break;
                }
                index++;
            }
        }
        return index >= n;
    }
}
