package com.scaler.Scaler.BackTracking;

//Given a matrix of integers A of size N x M . There are 4 types of squares in it:
//
//        1. 1 represents the starting square.  There is exactly one starting square.
//        2. 2 represents the ending square.  There is exactly one ending square.
//        3. 0 represents empty squares we can walk over.
//        4. -1 represents obstacles that we cannot walk over.
//        Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//
//        Note: Rows are numbered from top to bottom and columns are numbered from left to right.
public class UniquePathInMatrix {
    int n, m, ans1;
    int[] xx = new int[]{1, 0, 0, -1};
    int[] yy = new int[]{0, 1, -1, 0};

    public static void main(String[] args) {
//        ArrayList<ArrayList> mat= new ArrayList<ArrayList>();
        int[][] mat = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        UniquePathInMatrix matrix = new UniquePathInMatrix();
        matrix.solve2(mat);
    }

    void recur(int x, int y, int cnt, int[][] a) {
        if (a[x][y] == 2) {
            // checks if every non-obstacle square has been covered
            if (cnt == 0) {
                ans1++;
            }
            return;
        }
        int temp = a[x][y];
        a[x][y] = -1;
        // traverse all the directions
        for (int i = 0; i < 4; i++) {
            int u = x + xx[i];
            int v = y + yy[i];
            if (0 <= u && u < n && 0 <= v && v < m && a[u][v] != -1) {
                recur(u, v, cnt - 1, a);
            }
        }
        a[x][y] = temp;
    }

    public int solve2(int[][] a) {
        n = a.length;
        m = a[0].length;
        ans1 = 0;
        int u = -1, v = -1, cnt = 0;
        // find starting point and count number of non-obstacle squares
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    u = i;
                    v = j;
                } else if (a[i][j] == 0) {
                    cnt++;
                }
            }
        }
        // Ending square is also counted in cnt so pass cnt + 1
        recur(u, v, cnt + 1, a);
        return ans1;
    }
}
