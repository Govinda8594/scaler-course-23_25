package com.scaler.Scaler.Tries;

import java.util.HashSet;
import java.util.Set;

import static com.scaler.Scaler.Tries.DistinctRowIn2DMatrix.Node.countDistinctRows;

public class DistinctRowIn2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0}, {1, 1, 0, 0}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int n = matrix.length, m = matrix[0].length;
        int count = countDistinctRows(matrix, n, m);
        System.out.println("Number of distinct rows: " + count);
        /////////////////////////////////Brute Force Operations //

        int[][] matrix2 = new int[n][m];
        Set<String> rows = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < Math.min(m, 64); j++) {
                sb.append(matrix2[i][j]);
            }
            rows.add(sb.toString());
        }
        System.out.println(rows.size());
    }

    static class Node {
        Node[] children;

        Node() {
            children = new Node[2];
            children[0] = null;
            children[1] = null;
        }

        public static boolean insert(int[] row, Node root) {
            Node t = root;
            int m = row.length;
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if (t.children[i] != null) {
                    t = t.children[row[i]];
                } else {
                    Node nn = new Node();
                    t.children[row[i]] = nn;
                    t = t.children[row[i]];
                    flag = true;
                }
            }
            return flag;
        }

        public static int countDistinctRows(int[][] matrix, int n, int m) {
            int c = 0;
            Node root = new Node();
            for (int i = 0; i < n; i++) {
                if (insert(matrix[i], root)) {
                    c++;
                }
            }
            return c;
        }
    }
}
