package com.scaler.Scaler.Graph;
//Sheldon lives in a country with A cities (numbered from 1 to A) and B bidirectional roads.
//        Roads are denoted by integer array D, E and F of size M, where D[i] and E[i] denotes the cities
//        and F[i] denotes the distance between the cities.
//        Now he has many lectures to give in the city and is running short of time, so he asked you C queries,
//        for each query i, find the shortest distance between city G[i] and H[i].
//        If the two cities are not connected then the distance between them is assumed to be -1.
//
//        Problem Constraints
//        1 <= A <= 200
//        1 <= B <= 200000
//        1 <= C <= 100000
//        1 <= F[i] <= 1000000
//        1 <= D[i], E[i], G[i], H[i] <= A

import java.util.Arrays;

public class Sheldon_and_Pair_of_Cities {

    ///////////////////////////Floyd Warshall///////////////////////////////////////////////////////////////

    public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
          /*
        problem explanation
        ===================
        A = no of cities (nodes)
        B = total no of roads (edges)
        C = total no of queries given to find the answer
        D = city1 array
        E = city2 array
        F = F[i] = distance between D[i] and E[i]
        G = query1 for city1
        H = query2 for city2
         */
        long[][] dp = new long[A + 1][A + 1];
        //INITIALISING EVERY DISTANCE WITH INFINITY
        for (int i = 0; i <= A; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i <= A; i++) {
            dp[i][i] = 0;
        }
        //EDGES INSERTION
        for (int i = 0; i < B; i++) {
            dp[D[i]][E[i]] = Math.min(dp[D[i]][E[i]], F[i]);
            dp[E[i]][D[i]] = Math.min(dp[E[i]][D[i]], F[i]);
        }
        //CONSIDERING EVERY VERTEX AS INTERMEDIATE PT BW EACH EDGE
        for (int k = 1; k <= A; k++) {
            for (int i = 1; i <= A; i++) {
                for (int j = 1; j <= A; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
//                dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }
        //GETTING QUERRY
        int[] ans = new int[C];
        for (int i = 0; i < C; i++) {
            if (dp[G[i]][H[i]] != Integer.MAX_VALUE) {
                ans[i] = (int) dp[G[i]][H[i]];
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
