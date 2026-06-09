package com.scaler.Scaler.Arrays;

import java.util.Scanner;

public class MaxtrixGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        long[] r = new long[100005];
        long[] c = new long[100005];
        for(int i = 0;i<n;i++) r[i] = i;
        for(int i = 0;i<m;i++) c[i] = i;
        for(int i = 0;i<q;i++){
            int t = sc.nextInt();
            if(t == 1){
                int c1 = sc.nextInt(),c2 = sc.nextInt();
                long tmp = c[c1-1];
                c[c1-1] = c[c2-1];
                c[c2-1] = tmp;
            }else if(t == 2){
                int r1 = sc.nextInt(), r2 = sc.nextInt();
                long tmp = r[r1-1];
                r[r1-1] = r[r2-1];
                r[r2-1] = tmp;
            }else if(t == 3){
                int x1 = sc.nextInt(),y1 = sc.nextInt(),x2 = sc.nextInt(),y2 = sc.nextInt();
                // w/o creating 2-D matrix
                // formula for A[X][Y] = 1 + col[x][y] + row[x][y]*m
                long a = r[x1-1]*m + c[y1-1] + 1;
                long b = r[x2-1]*m + c[y2-1] + 1;
                System.out.println(a|b);
            }else if(t == 4){
                // w/o creating 2-D matrix
                // formula for A[X][Y] = 1 + col[x][y] + row[x][y]*m
                int x1 = sc.nextInt(),y1 = sc.nextInt(),x2 = sc.nextInt(),y2 = sc.nextInt();
                long a = r[x1-1]*m + c[y1-1] + 1;
                long b = r[x2-1]*m + c[y2-1] + 1;
                System.out.println(a&b);
            }
        }
    }
}
