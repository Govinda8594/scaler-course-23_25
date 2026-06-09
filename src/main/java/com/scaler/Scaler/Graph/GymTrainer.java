package com.scaler.Scaler.Graph;
//You are the trainer of a gym and there are A people who come to your gym.
//        Some of them are friends because they walk together, and some of them are friends because they talk together.
//        But people become possessive about each other, so a person cannot walk with one friend and talk with another.
//        Although he can walk with two or more people or talk with two or more people.
//        You being the trainer, decided to suggest each one of the 2 possible diets.
//        But friends, being friends will always have the same diet as all the other friends are having.
//        Find and return the number of ways you can suggest each of them a diet.
//        As the number of ways can be huge, return the answer modulo 109+7.
//        NOTE: If there is any person who walks with one person and talks with the another person, then you may return 0.
//
//        Problem Constraints
//        1 <= A, N, M <= 105
//        1 <= B[i][0], B[i][1], C[i][0], C[i][1] <= A

import java.util.*;

public class GymTrainer {

    List<List<Integer>> adjList;

    public int solve3(int A, int[][] B, int[][] C) {
        int[] par = new int[A + 1];
        HashSet<Integer> set = new HashSet<>();
        for (int[] arr : B) {
            set.add(arr[0]);
            set.add(arr[1]);
        }
        for (int[] arr : C) {
            if (set.contains(arr[0]) || set.contains(arr[1])) {
                return 0;
            }
        }
        for (int i = 1; i <= A; i++) {
            par[i] = i;
        }
        //  suggest same diet for only walk people
        for (int[] pair : B) {
            int a = getRoot(pair[0], par);
            int b = getRoot(pair[1], par);
            if (a != b) {
                par[a] = b;
            }
        }
        //  suggest same diet for only talk people
        for (int[] pair : C) {
            int a = getRoot(pair[0], par);
            int b = getRoot(pair[1], par);
            if (a != b) {
                par[a] = b;
            }
        }

        // maxium count of diet suggestedd
        int cnt = 0;
        for (int i = 1; i <= A; i++) {
            if (i == par[i]) {
                cnt++;
            }
        }
        int mod = 1000000007;
        // calcualte pair of people with same diet forming grope 2 pow cnt
        int ans = 1;
        while (cnt > 0) {
            ans = (ans * 2) % mod;
            cnt--;
        }
        return ans;
    }

    private int getRoot(int x, int[] par) {
        if (x == par[x]) {
            return x;
        }
        int ans = getRoot(par[x], par);
        par[x] = ans;
        return ans;
    }

    /////////////////////////BFS////////////////////////////////////////////////////


    public int solve(int A, int[][] B, int[][] C) {
        adjList = new ArrayList<>();
        Set<Integer> likeToWalk = new HashSet<>(); //maintaining a set of persons who like to walk
        boolean[] visited = new boolean[A + 1];
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            int a = ints[0];
            int b = ints[1];
            likeToWalk.add(a);
            likeToWalk.add(b);
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        //while creating adjList of C we can check the base condition of intersection if 2 diff type of friends intersecting
        for (int[] ints : C) {
            int a = ints[0];
            int b = ints[1];
            if (likeToWalk.contains(a) || likeToWalk.contains(b)) {
                return 0;
            }
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        int differentGroups = 0;
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                differentGroups++;
                bfs(i, visited);
            }
        }
        //we can distribute the diet in 2 ^differentGroups ways
        int mod = 1000000007;
        return pow(differentGroups, 2, mod);
    }

    public void bfs(int node, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int neighbor : adjList.get(temp)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public int pow(int exponent, int base, int mod) {
        long result = 1;
        long power = exponent;
        while (base > 0) {
            if (base % 2 == 1) {
                result = (result * power) % mod;
            }
            power = (power * power) % mod;
            base /= 2;
        }
        return (int) result;
    }
}
