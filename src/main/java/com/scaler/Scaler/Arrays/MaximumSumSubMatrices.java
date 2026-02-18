package com.scaler.Scaler.Arrays;

//Given a row-wise and column-wise sorted matrix A of size N * M.
//        Return the maximum non-empty submatrix sum of this matrix.
public class MaximumSumSubMatrices {
    public static void main(String[] args) {
        optimize(new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}});
    }

    static long maxSumSubMatricWithSuffixSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        long ans = A[n - 1][m - 1];
        long[][] suffixsumMatrics = new long[n][m];
        // row wise suffixsumMatrics
        for (int i = n - 1; i >= 0; i--) {
            suffixsumMatrics[i][m - 1] = A[i][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                suffixsumMatrics[i][j] = suffixsumMatrics[i][j + 1] + A[i][j];
            }
        }
        // col wise suffixsumMatrics
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 2; i >= 0; i--) {
                suffixsumMatrics[i][j] = suffixsumMatrics[i][j] + suffixsumMatrics[i + 1][j];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (ans < suffixsumMatrics[i][j]) {
                    ans = suffixsumMatrics[i][j];
                }
            }
        }
        return ans;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    static long maxSumSubMatrics(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        long ans = Integer.MIN_VALUE;
        long[] sum = null;
        for (int start = 0; start < row; start++) {
            sum = new long[col];
            for (int end = start; end < row; end++) {
                for (int j = 0; j < col; j++) {
                    sum[j] += A[end][j];
                }
                ans = Math.max(ans, maxSubArraykadane(sum, col));
            }
        }
        return ans;
    }

    public static long maxSubArraykadane(long[] A, int m) {
        long sum = 0;
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            sum += A[i];
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static long optimize(int[][] A) {
        long maxsum = Integer.MIN_VALUE;
        int N = A.length;
        int M = A[0].length;
        int row = N - 1;
        int col = M - 1;
        if (A[row][col] < 0) return A[row][col];
        long[][] pf = new long[N + 1][M + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                long s = (long) A[i][j] + pf[i + 1][j] + pf[i][j + 1] - pf[i + 1][j + 1];
                maxsum = Math.max(s, maxsum);
                pf[i][j] = s;
            }
        }
        return maxsum;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public long optimize2(int[][] A) {
        // S[i][j] = A[i][j] + S[i][j+1] + S[i+1][j] - S[i+1][j+1];
        int M = A.length - 1;
        int N = A[0].length - 1;
        // Becuase of long need to take temp. So space complexity is O(M+N) or else it would be 1 i.e. constant
        long[][] temp = new long[M + 1][N + 1];
        long max = Long.MIN_VALUE;
        for (int i = M; i > -1; i--) {
            for (int j = N; j > -1; j--) {
                temp[i][j] = A[i][j];
                if (j + 1 <= N) {
                    temp[i][j] += temp[i][j + 1];
                }
                if (i + 1 <= M) {
                    temp[i][j] += temp[i + 1][j];
                }
                if (j + 1 <= N && i + 1 <= M) {
                    temp[i][j] -= temp[i + 1][j + 1];
                }
                max = Math.max(max, temp[i][j]);
            }
        }
        return max;
    }
}
