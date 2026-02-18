package com.scaler.Scaler.Combinatrics;

public class CalculateNCR {
    //Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
//        x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
//        NOTE: For this problem, we are considering 1 as a prime.
    public int CalculateNCROptimize(int A, int B, int C) {
        long fact[] = new long[1000005];
        long ans = 0;
        fact[0] = 1;
        for (int i = 1; i <= A; i++) {
            fact[i] = (fact[i - 1] * i) % C;
        }
        ans = fact[A];
        ans = (ans * pow(fact[B], C - 2, C)) % C;
        ans = (ans * pow(fact[A - B], C - 2, C)) % C;
        return (int) ans;
    }

    static long pow(long a, int b, int m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % m;
            }
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }
/////////////////////////////////////////////////////////////////////////////////
//    Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
//            x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

    public int CalculateNCR(int A, int B, int C) {
        return nCr(A, B, C);
    }

    static int nCr(int n, int r, int m) {
        int mat[][] = new int[n + 1][r + 1];
        for (int i = 0; i <= n; i++) {
            mat[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                if (j <= i) {
                    mat[i][j] = mat[i - 1][j] % m + mat[i - 1][j - 1] % m;
                }
            }
        }
        return mat[n][r] % m;
    }
}
