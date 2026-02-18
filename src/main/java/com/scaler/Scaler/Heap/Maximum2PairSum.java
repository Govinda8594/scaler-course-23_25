package com.scaler.Scaler.Heap;

import java.util.*;

public class Maximum2PairSum {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        A.sort(Collections.reverseOrder());
        B.sort(Collections.reverseOrder());
        int n = A.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : A) {
            for (int j : B) {
                int s = i + j;
                if (pq.size() < n) {
                    pq.add(s);
                } else {
                    if (s > pq.peek()) {
                        pq.poll();
                        pq.add(s);
                    } else {
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> ret = new ArrayList<>(pq);
        ret.sort(Collections.reverseOrder());
        return ret;
    }
    ////////////////////////////////////////////////////////////

    public ArrayList<Integer> solve2(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashSet<String> set = new HashSet<>();
        int n = A.size();
        Collections.sort(A);
        Collections.sort(B);
        ArrayList<Integer> ans = new ArrayList<>();
        int i = n - 1, j = n - 1;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> b.data - a.data);
        StringBuilder str = new StringBuilder();
        str.append((char) i);
        str.append((char) j);
        set.add(str.toString());
        pq.add(new Triplet(A.get(i) + B.get(j), i, j));
        while (n > 0) {
            Triplet poll = pq.poll();
            i = poll.index1;
            j = poll.index2;
            ans.add(poll.data);
            str = new StringBuilder();
            str.append((char) (i - 1));
            str.append((char) (j));
            if (i > 0 && set.add(str.toString())) {
                pq.add(new Triplet(A.get(i - 1) + B.get(j), i - 1, j));
            }
            str = new StringBuilder();
            str.append((char) (i));
            str.append((char) (j - 1));
            if (j > 0 && set.add(str.toString())) {
                pq.add(new Triplet(A.get(i) + B.get(j - 1), i, j - 1));
            }
            n--;
        }
        return ans;
    }

    public ArrayList<Integer> solve5(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        if (n == 0) {
            return new ArrayList<>();
        }
        A.sort(Collections.reverseOrder());
        B.sort(Collections.reverseOrder());

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Set<Long> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        heap.offer(new int[]{A.get(0) + B.get(0), 0, 0});
        visited.add(0L);

        for (int k = 0; k < n; k++) {
            int[] current = heap.poll();
            result.add(current[0]);
            int i = current[1];
            int j = current[2];

            if (i + 1 < n) {
                long key1 = (long) (i + 1) * n + j;
                if (!visited.contains(key1)) {
                    visited.add(key1);
                    heap.offer(new int[]{A.get(i + 1) + B.get(j), i + 1, j});
                }
            }

            if (j + 1 < n) {
                long key2 = (long) i * n + (j + 1);
                if (!visited.contains(key2)) {
                    visited.add(key2);
                    heap.offer(new int[]{A.get(i) + B.get(j + 1), i, j + 1});
                }
            }
        }

        return result;
    }

    class Triplet {
        int index1, index2, data;

        Triplet(int x, int n1, int n2) {
            index1 = n1;
            index2 = n2;
            data = x;
        }
    }
}
