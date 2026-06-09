package com.scaler.Scaler.GreedyProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class MaxProfitJobSequenceWithUnBoundedTime {
    char job_id;
    int deadline;
    int profit;

    MaxProfitJobSequenceWithUnBoundedTime(char job_id, int deadline, int profit) {
        this.deadline = deadline;
        this.job_id = job_id;
        this.profit = profit;
    }

    static void printJobScheduling(ArrayList<MaxProfitJobSequenceWithUnBoundedTime> arr) {
        int n = arr.size();
        // sorting the array on the
        // basis of their deadlines
        Collections.sort(arr, (a, b) -> {
            return a.deadline - b.deadline;
        });
        // initialise the result array and maxHeap
        ArrayList<MaxProfitJobSequenceWithUnBoundedTime> result = new ArrayList<>();
        PriorityQueue<MaxProfitJobSequenceWithUnBoundedTime> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    return b.profit - a.profit;
                });
        // starting the iteration from the end
        for (int i = n - 1; i > -1; i--) {
            int slot_available;
            // calculate slots between two deadlines
            if (i == 0) {
                slot_available = arr.get(i).deadline;
            } else {
                slot_available = arr.get(i).deadline
                        - arr.get(i - 1).deadline;
            }
            // include the profit of job(as priority),
            // deadline and job_id in maxHeap
            maxHeap.add(arr.get(i));
            while (slot_available > 0
                    && maxHeap.size() > 0) {
                // get the job with max_profit
                MaxProfitJobSequenceWithUnBoundedTime job = maxHeap.remove();
                // reduce the slots
                slot_available--;
                // include the job in the result array
                result.add(job);
            }
        }
        // jobs included might be shuffled
        // sort the result array by their deadlines
        Collections.sort(result, (a, b) -> {
            return a.deadline - b.deadline;
        });
        for (MaxProfitJobSequenceWithUnBoundedTime job : result) {
            System.out.print(job.job_id + " ");
        }
        System.out.println();
    }

    // Driver's Code
    public static void main(String[] args) {
        ArrayList<MaxProfitJobSequenceWithUnBoundedTime> arr = new ArrayList<MaxProfitJobSequenceWithUnBoundedTime>();
        arr.add(new MaxProfitJobSequenceWithUnBoundedTime('a', 2, 100));
        arr.add(new MaxProfitJobSequenceWithUnBoundedTime('b', 1, 19));
        arr.add(new MaxProfitJobSequenceWithUnBoundedTime('c', 2, 27));
        arr.add(new MaxProfitJobSequenceWithUnBoundedTime('d', 1, 25));
        arr.add(new MaxProfitJobSequenceWithUnBoundedTime('e', 3, 15));
        System.out.println("Following is maximum "
                + "profit sequence of jobs");
        // Function call
        printJobScheduling(arr);
    }
}