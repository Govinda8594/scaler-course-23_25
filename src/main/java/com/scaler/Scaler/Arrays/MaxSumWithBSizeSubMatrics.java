package com.scaler.Scaler.Arrays;

public class MaxSumWithBSizeSubMatrics {
    public static void main(String[] args) {
        MaxSumWithBSizeSubMatrics(new int[][]{
                {
                        1, 1, 1, 1, 1
                },
                {
                        2, 2, 2, 2, 2
                },
                {
                        3, 8, 6, 7, 3
                },
                {
                        4, 4, 4, 4, 4
                },
                {
                        5, 5, 5, 5, 5
                }
        }, 3);
    }

    public static int MaxSumWithBSizeSubMatrics(int[][] A, int B) {
        int R = A.length;
        int C = A[0].length;
        int max = Integer.MIN_VALUE;
        // Prefix sum on rows
        for (int r = 0; r < R; r++) {  // TC - R*C
            for (int c = 1; c < C; c++) {
                A[r][c] = A[r][c - 1] + A[r][c];
            }
        }
        // Prefix sum on columns
        for (int c = 0; c < C; c++) {  // TC - R*C
            for (int r = 1; r < R; r++) {
                A[r][c] = A[r - 1][c] + A[r][c];
            }
        }
        for (int r = B - 1; r < R; r++) { // TC - BR points of Square Matrix
            for (int c = B - 1; c < C; c++) {
                int sum = A[r][c];
                if (r >= B) sum -= A[r - B][c];
                if (c >= B) sum -= A[r][c - B];
                if (r >= B && c >= B) sum += A[r - B][c - B];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    static int maxSumSlidingwindowWithPFSum(int[][] A, int B) {
        int col = A[0].length;
        int row = A.length, n = row;
        // if size or n = 0, n*n | b = 1, (n-1)*(n-1) | b = 2,(n - 2)*(n - 2) matrix size
        // in general (n - B + 1) * (n - B + 1) matrix size;
        int[][] pf = new int[n - B + 1][col];
        for (int c = 0; c < n; c++) {
            int sum = 0;
            for (int r = 0; r < B; r++) {
                sum += A[r][c];
            }
            pf[0][c] = sum;
            for (int r = 1; r < n - B + 1; r++) {
                sum = sum + A[r + B - 1][c] - A[r - 1][c];
                pf[r][c] = sum;
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int r = 0; r < n - B + 1; r++) {
            int sum = 0;
            for (int c = 0; c < B; c++) {
                sum += pf[r][c];
            }
            ans = Math.max(ans, sum);
            for (int c = 1; c < n - B + 1; c++) {
                sum = sum + pf[r][c + B - 1] - pf[r][c - 1];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    public int solve(int[][] A, int B) {
        int row = A.length;
        int col = A[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[][] pf = new int[row][col];
        //calculate row wise sum
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    pf[i][j] = A[i][j];
                } else {
                    pf[i][j] = pf[i][j - 1] + A[i][j];
                }
            }
        }
        for (int i = 0; i <= row - B; i++) {
            for (int j = B - 1; j < col; j++) {
                int sum = 0;
                for (int k = i; k < i + B; k++) {
                    if (j - B >= 0) {
                        sum = sum + pf[k][j] - pf[k][j - B];
                    } else {
                        sum = sum + pf[k][j];
                    }
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
