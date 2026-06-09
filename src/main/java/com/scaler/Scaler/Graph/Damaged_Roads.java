package com.scaler.Scaler.Graph;
//You are the Prime Minister of a country and once you went for a world tour.
//        After 5 years, when you returned to your country,
//        you were shocked to see the condition of the roads between the cities.
//        So, you plan to rePair6 them, but you cannot afford to spend a lot of money.
//        The country can be represented as a (N+1) x (M+1) grid, where Country(i, j) is a city.
//        The cost of rePair6ing a road between (i, j) and (i + 1, j) is A[i]. The cost of rePair6ing a road between (i, j)
//        and (i, j + 1) is B[j].
//        Return the minimum cost of rePair6ing the roads such that all cities can be visited from city indexed (0, 0).
//        As the cost can be large, return the cost modulo 109+7.
//
//        Problem Constraints
//        1 <= N, M <= 105
//        1 <= A[i], B[i] <= 103

import java.util.*;

public class Damaged_Roads {
    static final int MOD = 1_000_000_007;
    static Map<String, Integer> memo = new HashMap<>();

    static void main(String[] args) {
        int[] A = {1, 2, 3}; // N = 3 → grid has 4 rows
        int[] B = {4, 5};    // M = 2 → grid has 3 columns
        Damaged_Roads.mergeApproach(A, B);
    }


    /// //////////////////////////////////////////////////////////////////////////
    static int mergeApproach(int[] A, int[] B) {
        Arrays.sort(A); /* sort row wise cost */
        Arrays.sort(B); // sort col wise cost
        int N = A.length, M = B.length, p = (int) 1e9 + 7;
        long ans = 0L;
        int i = 0, j = 0;
/* since we have to connect each and every cell we
can use merge sort kind of algorithm and compare costs whether we are gonna move
row wise first or col wise first */
        while (i < N && j < M) {
            if (A[i] <= B[j]) {
                ans += (long) A[i] * (M - j + 1);
                ans %= p;
                i++;
            } else {
                ans += (long) B[j] * (N - i + 1);
                ans %= p;
                j++;
            }
        }
        while (i < N) {
            ans += A[i++];
        }
        while (j < M) ans += B[j++];

        return (int) (ans % p);
    }

    /// //////////////////////////////////////////////////////////////////////////
    public static int minRepairCost2(int[] A, int[] B) {
        // Sort in descending order
        Arrays.sort(A);
        Arrays.sort(B);
        reverse(A);
        reverse(B);

        int n = A.length, m = B.length;
        int i = 0, j = 0;

        long verticalParts = 1;    // number of row segments
        long horizontalParts = 1;  // number of column segments
        long cost = 0;

        while (i < n || j < m) {
            if (j == m || (i < n && A[i] >= B[j])) {
                // when hortizonal cost is increment vertical edges
                // Take a vertical edge (between rows i and i+1), affects all current column segments
                cost = (cost + (A[i] % MOD) * (horizontalParts % MOD)) % MOD;
                verticalParts++;
                i++;
            } else {
                // when verical cost is increment horizonal edges
                // Take a horizontal edge (between columns j and j+1), affects all current row segments
                cost = (cost + (B[j] % MOD) * (verticalParts % MOD)) % MOD;
                horizontalParts++;
                j++;
            }
        }

        return (int) (cost % MOD);
    }

    private static void reverse(int[] arr) {
        for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
    }

    //BRUTE FORCE
    public int solve2(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] cities = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                cities[i][j] = Integer.MAX_VALUE;
            }
        }
        cities[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] currentIndex = q.poll();
            int[] nextRow = new int[]{currentIndex[0] + 1, currentIndex[1]};
            int[] nextCol = new int[]{currentIndex[0], currentIndex[1] + 1};
            if (nextRow[0] <= n) {
                cities[nextRow[0]][nextRow[1]] = Math.min(cities[nextRow[0]][nextRow[1]], A[nextRow[0] - 1]);
                q.add(nextRow);
            }
            if (nextCol[1] <= m) {
                cities[nextCol[0]][nextCol[1]] = Math.min(cities[nextCol[0]][nextCol[1]], B[nextCol[1] - 1]);
                q.add(nextCol);
            }
        }
        long minCost = 0;
        int mod = 1000000007;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                minCost = (minCost + cities[i][j]) % mod;
            }
        }
        return (int) minCost % mod;
    }

    //OPTIMIZED
    public int solve1(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        List<int[]> cost = new ArrayList<>(n + m);
        // vertical cost
        for (int i = 0; i < n; i++) {
            cost.add(new int[]{A[i], 1});
        }
        // horitonal cost
        for (int i = 0; i < m; i++) {
            cost.add(new int[]{B[i], 0});
        }
        cost.sort((a, b) -> Integer.compare(a[0], b[0]));
        n++;
        m++;
        long minCost = 0;
        int mod = 1000000007;
        for (int[] road : cost) {
            if (road[1] == 0) {
                minCost = (minCost + ((long) n * road[0])) % mod;
                m--;
            } else {
                minCost = (minCost + ((long) m * road[0])) % mod;
                n--;
            }
        }
        return (int) minCost % mod;
    }
}