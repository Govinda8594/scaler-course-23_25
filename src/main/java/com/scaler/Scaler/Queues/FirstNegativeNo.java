package com.scaler.Scaler.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNo {

    public static void main(String[] args) {
        printFirstNegativeInteger(new long[]{8, 2, 3, 6, -10}, 5, 2);
    }

    public static long[] printFirstNegativeInteger(long[] A, int N, int K) {
        long[] ans = new long[N - K + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (A[i] < 0)
                q.offer(i);
        }
        if (!q.isEmpty()) {
            ans[0] = A[q.element()];
        } else
            ans[0] = 0;
        for (int i = K; i < N; i++) {
            if (A[i] < 0)
                q.offer(i);
            if (!q.isEmpty() && q.element() < i - K + 1) {
                q.poll();
            }
            if (q.isEmpty())
                ans[i - K + 1] = 0;
            else ans[i - K + 1] = A[q.element()];
        }
        return ans;
    }
}
