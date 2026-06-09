package com.scaler.Scaler.Arrays;

import java.util.ArrayList;

public class MergeOverlappingIntervls {
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

    ////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<>();
        intervals.sort((i1, i2) -> i1.start - i2.start);
        int n = intervals.size();
        Interval oldIntr = intervals.get(0);
        for (int i = 1; i < n; i++) {
            Interval currIntr = intervals.get(i);
            if (oldIntr.end < currIntr.start) {
                ans.add(oldIntr);
                oldIntr = currIntr;
            } else if (oldIntr.end > currIntr.start) {
                oldIntr.start = Math.min(oldIntr.start, currIntr.start);
                oldIntr.end = Math.max(oldIntr.end, currIntr.end);
            }
        }
        ans.add(oldIntr);
        return ans;
    }

    static class Interval {

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
}
