package com.scaler.Scaler.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//Given an integer A denoting the value of N, return all distinct solutions to the N-queens puzzle.
//
//        Each solution contains a distinct board configuration of the N-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//        The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.

public class NQueen {

    public ArrayList<ArrayList<String>> solveNQueens1(int A) {
        HashSet<Integer> col = new HashSet<Integer>();
        HashSet<Integer> ld = new HashSet<Integer>();
        HashSet<Integer> rd = new HashSet<Integer>();
        char[][] mat = new char[A][A];
        for (int i = 0; i < A; i++) {
            Arrays.fill(mat[i], '.');
        }
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        return findQueen(res, mat, A, 0, col, ld, rd);
    }

    public ArrayList<ArrayList<String>> findQueen(ArrayList<ArrayList<String>> res, char[][] mat, int n, int row, HashSet<Integer> cols, HashSet<Integer> ld, HashSet<Integer> rd) {
        if (row == n) {
            ArrayList<String> state = new ArrayList<String>();
            for (int k = 0; k < n; k++) {
                state.add(new String(mat[k]));
            }
            res.add(state);
            return res;
        }
        int col;
        for (col = 0; col < n; col++) {
            if (cols.contains(col) || ld.contains(row - col) || rd.contains(row + col)) {
                continue;
            }
            mat[row][col] = 'Q';
            cols.add(col);
            ld.add(row - col);
            rd.add(row + col);
            findQueen(res, mat, n, row + 1, cols, ld, rd);
            mat[row][col] = '.';
            cols.remove(col);
            ld.remove(row - col);
            rd.remove(row + col);
        }
        return res;
    }
}
