package com.scaler.Scaler.Arrays;

//Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
//
//        Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
//
//        NOTE:
//
//        Rows are numbered from top to bottom, and columns are numbered from left to right.
//        The sum may be large, so return the answer mod 109 + 7.
//        Also, select the data type carefully, if you want to store the addition of some elements.
//        Indexing given in B, C, D, and E arrays is 1-based.
//        Top Left 0-based index = (B[i] - 1, C[i] - 1)
//        Bottom Right 0-based index = (D[i] - 1, E[i] - 1)
public class SubMatricesQueries {
    int modNum = 1000000007;

    public static void main(String[] args) {
        prefixOfSubMatricsBruteForce(new int[][]{{-5, -4, -3}, {-1, 2, 3}, {2, 2, 4}});
    }

    public static long[][] prefixOfSubMatricsBruteForce(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        long[][] prefixsum = new long[M][N];
        for (int i = 0; i < M; i++) {
            prefixsum[i][0] = A[i][0];
        }
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                prefixsum[i][j] = prefixsum[i][j - 1] + A[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                prefixsum[j][i] = prefixsum[j - 1][i] + prefixsum[j][i];
            }
        }
        return prefixsum;
    }

    //  Returns prefix-sum matrix array.
    //     TC -> O(N * M), SC -> O(N * M) /
    private long[][] getPrefixSumMatrix(int[][] A) {
       /*  Create N * M size prefix-sum matrix array as same as orginal matrix array.
            Data type of prefix-sum matrix array is long to avoid the overflow */
        long[][] pf = new long[A.length][A[0].length];

        /*  Row-wise prefix-sum of orginal matrix array */
        for (int r = 0; r < A.length; r++) {
            pf[r][0] = A[r][0];
            for (int c = 1; c < A[0].length; c++) {
                pf[r][c] = pf[r][c - 1] + A[r][c];
            }
        }

        /*  Column-wise prefix sum of row-wise prefixed-sum matrix array */
        for (int c = 0; c < pf[0].length; c++) {
            // pf[0][c] = A[0][c];
            for (int r = 1; r < pf.length; r++) {
                pf[r][c] = pf[r - 1][c] + pf[r][c];
                // sum = sum + pf[r][c];
                // pf[r][c] = sum;
            }
        }
        return pf;
    }

    /*  Outputs the prefix-sum matrix array on console */
    private void displayPrefixSumMatrix(long[][] A) {
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++)
                System.out.print(A[r][c] + " ");
            System.out.println();
        }
    }

    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        /*  Get the prefix-sum matrix array */
        long[][] prefixsum = getPrefixSumMatrix(A);

        /*  Single dimension array for returning the output */
        int[] subMatSum = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            /*  Top-Left index */
            int r1 = B[i] - 1;
            int c1 = C[i] - 1;

            /*  Bottom-Right index */
            int r2 = D[i] - 1;
            int c2 = E[i] - 1;
            long sum = prefixsum[r2][c2];  /*  Sum of all matrix from [0, 0] to [N-1, M-1] */
            if (c1 > 0)
                sum = sum - prefixsum[r2][c1 - 1];   /*  Remove sum of [(bottom-left) - 1] from sum.
                                                i.e [0, 0] to [r2, c1-1] */
            if (r1 > 0)
                sum = sum - prefixsum[r1 - 1][c2];   /*  Remove sum of [(top-right) - 1] from sum.
                                                i.e [0, 0] to [r1-1, c2] */
            if (r1 > 0 && c1 > 0)
                sum = sum + prefixsum[r1 - 1][c1 - 1]; /*  Add sum of [0, 0] to [r1-1, c1-1] to sum
                                                as this particular sum is removed twice 
                                                from initial sum as mentioned in bottom-left and top-right */

            /*  Finally convert into int and mod sum with (10 ^ 9 + 7) as mentioned in problem constraint */
            subMatSum[i] = (int) (((sum % modNum) + modNum) % modNum);
        }
        return subMatSum;
    }
}
