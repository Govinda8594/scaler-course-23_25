package com.scaler.Scaler.DynamicProgramming;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.print(F(n));
    }

    /// top down - tabulation + space optimization
    static int F(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // tabulation
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fib = new int[n + 1]; //  fib[i] denotes the i'th fibonacci number
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        System.out.println(fib[n]);
    }

    public static void main1(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // creating array and initailizing -1
        int dp[] = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }
        System.out.println(fibonacci(N, dp));
    }
// memorization method

    public static int fibonacci(int N, int dp[]) {
        if (dp[N] != -1) {
            return dp[N]; //checking array have value or NOT
        }
        if (N == 0 || N == 1) {
            return N; //base case
        }
        dp[N] = fibonacci(N - 1, dp) + fibonacci(N - 2, dp); //logic and storing in dp array
        return dp[N];
    }
}
