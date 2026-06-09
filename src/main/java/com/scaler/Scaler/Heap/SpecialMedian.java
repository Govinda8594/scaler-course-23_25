package com.scaler.Scaler.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class SpecialMedian {

    /*You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:

There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.

Return 1 if the array is special else return 0.

NOTE:

Do not neglect decimal point while calculating the median
For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]*/

    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> reversed = new ArrayList<>(A);
        Collections.reverse(reversed);
        if (checkMedian(A) || checkMedian(new ArrayList<>(reversed))) {
            return 1;
        }
        return 0;
    }

    boolean checkMedian(ArrayList<Integer> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap.add(A.get(0));
        for (int i = 1; i < A.size() - 1; i++) {
            if (A.get(i) <= maxHeap.peek()) {
                maxHeap.add(A.get(i));
            } else {
                minHeap.add(A.get(i));
            }
            //either both the heaps will have equal number of elements or max-heap will have one more element
            // than the min heap
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() == minHeap.size()) {
                //we have even number of elements , take average of middle elements
                double ans = ((long) maxHeap.peek() + minHeap.peek()) / 2.0;
                if (ans == A.get(i + 1)) {
                    return true;
                }
            } else {
                if (maxHeap.peek().equals(A.get(i + 1))) {
                    return true;
                }
            }
        }
        return false;
    }
}
