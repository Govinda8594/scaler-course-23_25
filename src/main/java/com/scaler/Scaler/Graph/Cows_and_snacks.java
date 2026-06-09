package com.scaler.Scaler.Graph;
//The legendary Farmer John is throwing a huge party, and animals from all over the world are hanging out at his house.
// His guests are hungry, so he instructs his cow Bessie to bring out the snacks! Moo!
//        There are A snacks flavors, numbered with integers 1,2,…,A. Bessie has A snacks,
//        one snack of each flavor. There are M guests and every guest has exactly two favorite flavors.
//        The procedure for eating snacks will go as follows:
//        First, Bessie will line up the guests in some way.
//        Each guest in their turn will eat all remaining snacks of their favorite flavor.
//        In case no favorite flavors are present when a guest goes up, they become very sad.
//        Help Bessie to minimize the number of sad guests by lining the guests in an optimal way.
//
//        Problem Constraints
//        2 <= A <= 100000
//        1 <= M <= 100000
//        1 <= B[i][0] , B[i][1] <= A
//        B[i][0] != B[i][1]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cows_and_snacks {
    public int solve2(int A, int[][] B) {
        int[] par = new int[A + 1];
        int cnt = 0;
        for (int i = 1; i <= A; i++) {
            par[i] = i;  // each snack with own component
        }
        for (int[] arr : B) {
            int a = getRoot(arr[0], par);
            int b = getRoot(arr[1], par);
            if (a == b) { // common snack for guest
                cnt++;
            } else {
                par[a] = b; // still either of two snack is favoutite make one favourite for minimal guest
            }
        }
        return cnt;
    }

    private int getRoot(int x, int[] par) {
        if (par[x] == x) {
            return x;
        }
        int ans = getRoot(par[x], par);
        par[x] = ans;
        return ans;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    void bfs(int start, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int ele : list.get(temp)) {
                if (!visited[ele]) {
                    visited[ele] = true;
                    queue.add(ele);
                }
            }
        }
    }

    public int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            list.get(ints[0]).add(ints[1]);
            list.get(ints[1]).add(ints[0]);
        }
        boolean[] visited = new boolean[A + 1];
// Total isolated Component
// If there is K vertices in a connected component than K-1 animal can be satisfied
// First animal will eat the 2 favourite flavor and rest of animal will eat 1 flavor
// Basically, we are finding No. of edges without cycle
        int isolatedCompo = 0;
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) { // snack not visited
                bfs(i, list, visited);
                isolatedCompo++; // act like common snack count
            }
        }
// Total Number of happy cows
        int happyCows = A - isolatedCompo;
        return B.length - happyCows; // number of minimum uhappy cow
    }
}
