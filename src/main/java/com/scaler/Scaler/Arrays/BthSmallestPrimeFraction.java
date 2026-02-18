package com.scaler.Scaler.Arrays;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BthSmallestPrimeFraction {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.fraction < b.fraction) {
                        return -1;
                    }
                    if (a.fraction > b.fraction) {
                        return 1;
                    }
                    return 0;
                });
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                double x = (double) A.get(i) / (double) A.get(j);
                //System.out.println(A.get(i) + " " + A.get(j));
                pq.add(new Node(x, A.get(i), A.get(j)));
            }
        }
        for (int i = 0; i < B - 1; i++) {
            pq.poll();
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Node temp = pq.poll();
        ans.add(temp.num);
        ans.add(temp.denom);
        return ans;
    }

    class Node {
        double fraction;
        int num;
        int denom;

        public Node(Double fraction, int num, int denom) {
            this.fraction = fraction;
            this.num = num;
            this.denom = denom;
        }
    }
}
