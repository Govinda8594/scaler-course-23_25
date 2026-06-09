package com.scaler.Scaler.Graph;
//Given character matrix A of dimensions N×M consisting of O's and X's, where O = white, X = black.
//        Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
//        Problem Constraints
//        1 <= N, M <= 1000
//        A[i][j] = 'X' or 'O'
//A = [ [X, X, X], [X, X, X], [X, X, X] ]
//        Output 1:
//        1

import java.util.ArrayList;

public class Black_Shapes {
    private final int[] di = new int[]{1, -1, 0, 0};
    private final int[] dj = new int[]{0, 0, 1, -1};

    public int black1(String[] A) {
        int c = 0;
        int m = A[0].length();// A[0] contains string , so string length
        char[][] ch = new char[A.length][m];
        for (int i = 0; i < A.length; i++) {
            String str = A[i];
            for (int j = 0; j < str.length(); j++) {
                ch[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[0].length; j++) {
                if (ch[i][j] == 'X') {
                    c = c + 1;
                    checkconnected(ch, i, j);
                }
            }
        }
        return c;
    }

    void checkconnected(char[][] A, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == 'O') {
            return;
        }
        A[i][j] = 'O';
        checkconnected(A, i - 1, j);
        checkconnected(A, i + 1, j);
        checkconnected(A, i, j - 1);
        checkconnected(A, i, j + 1);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int black(ArrayList<String> A) {
        int m, n;
        if (A == null) {
            return 0;
        }
        m = A.size();
        n = A.get(0).length();
        boolean[][] marked = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!marked[i][j] && A.get(i).charAt(j) == 'X') {
                    dfs(marked, A, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(boolean[][] marked, ArrayList<String> A, int i, int j, int m, int n) {
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ii = i + di[k];
            int jj = j + dj[k];
            if (isValid(A, ii, jj, m, n) && !marked[ii][jj]) {
                dfs(marked, A, ii, jj, m, n);
            }
        }
    }

    public boolean isValid(ArrayList<String> A, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        return A.get(i).charAt(j) == 'X';
    }
}
