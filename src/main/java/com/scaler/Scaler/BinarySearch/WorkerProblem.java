package com.scaler.Scaler.BinarySearch;

public class WorkerProblem {
    public static void main(String[] args) {
//        int[] blocks = new int[]{1,23,5,10,7,5,3,2,1};
//        minTimeCompleteWork(blocks, 4);
        int[] time = new int[]{5, 6, 7, 12, 10, 9, 3, 1, 4, 8};
        int ans = minTimeCompleteWork(time, 5);
    }

    static int minTimeCompleteWork(int[] blocks, int Painter) {
        int len = blocks.length;
        int low = 0, high = 0, minTime = Integer.MAX_VALUE;
        for (int block : blocks) {
            low = Math.max(low, block);
        }

        for (int block : blocks) {
            high += block;
        }

        while (low <= high) {
            int midtime = (low + high) / 2;
            if (checkTimeRequired(blocks, Painter, midtime)) {
                minTime = midtime;
                high = midtime - 1;
            } else {
                low = midtime + 1;
            }
        }
        return minTime;
    }

    private static boolean checkTimeRequired(int[] blocks, int painter, int midtime) {
        int len = blocks.length;
        int t = 0, person = 1;
        for (int block : blocks) {
            t += block;
            if (t > midtime) {
                person++;
                t = block;
            }
        }
        return person <= painter;
    }

}
