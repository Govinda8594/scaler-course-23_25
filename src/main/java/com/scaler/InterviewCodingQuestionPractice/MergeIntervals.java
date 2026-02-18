package com.scaler.InterviewCodingQuestionPractice;

import java.util.ArrayList;

public class MergeIntervals {
//        intervals[i][0] = start point of i'th interval
//        intervals[i][1] = finish point of i'th interval

    public static void main(String[] args) {
//        mergeIntervals()
    }

    public static ArrayList<ArrayList<Integer>> mergeIntervals(ArrayList<ArrayList<Integer>> intervals) {
        // WRITE YOUR CODE HERE
        int len = intervals.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        intervals.sort((a, b) -> a.get(0) - b.get(0));
        ArrayList<Integer> previous = intervals.get(0);
        for (int i = 1; i < len; i++) {
            ArrayList<Integer> curr = intervals.get(i);
            if (previous.get(1) < curr.get(0)) {
                ans.add(previous);
                previous = curr;
            } else if (previous.get(1) >= curr.get(0)) {
                previous.set(0, Math.min(previous.get(0), curr.get(0)));
                previous.set(1, Math.max(previous.get(1), curr.get(1)));
                // intervals.set(i, previous);
                // ans.add(previous);
            }
        }
        ans.add(previous);
        return ans;
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        ArrayList<Interval> ans = new ArrayList<>(size);
        for (Interval interval : intervals) {
            // newInterval(non intersecting) appears before current array - intervals
            if (newInterval.end < interval.start) {
                ans.add(newInterval);
                newInterval = interval;
            }
            // newInterval(non intersecting) appears after current array - intervals
            else if (newInterval.start > interval.end) {
                ans.add(interval);
            }
            // newInterval(intersecting) appears. Take min(newInterval start, current start). Take max(newInterval end, current end).
            else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        ans.add(newInterval);
        return ans;
    }

}

class Interval {

    public int start;
    public int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}