package com.scaler.Scaler.Recursion;
//In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
//        The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
//        You have the following constraints:
//
//        Only one disk can be moved at a time.
//        A disk is slid off the top of one tower onto another tower.
//        A disk cannot be placed on top of a smaller disk.
//        You have to find the solution to the Tower of Hanoi problem.
//        You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
//        In each row, there should be 3 integers (disk, start, end), where:
//
//        disk - number of the disk being moved
//        start - number of the tower from which the disk is being moved
//        end - number of the tower to which the disk is being moved

import java.util.ArrayList;

public class TowerOfHanoi {

    static ArrayList<String> list = new ArrayList<String>();
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    static int i = 0;
    static int[][] ans;

    public static void main(String[] args) {

        towerOfHanoi2(3);

    }

    public static int[][] towerOfHanoi(int A) {
        int M = (1 << A) - 1;
        int[][] ans = new int[M][3];
        tower(A, 1, 3, 2);
        int i = 0;
        for (String str : list) {
            String[] arr = str.split(",");
            ans[i][0] = Integer.parseInt(arr[0]);
            ans[i][1] = Integer.parseInt(arr[1]);
            ans[i][2] = Integer.parseInt(arr[2]);
            i++;
        }
        return ans;
    }

    static void tower(int A, int start, int end, int mid) {
        if (A == 1) {
            list.add(A + "," + start + "," + end);
            return;
        }
        tower(A - 1, start, mid, end);
        list.add(A + "," + start + "," + end);
        tower(A - 1, mid, end, start);
    }

    public static int[][] towerOfHanoi2(int Disk) {
        ans = new int[(int) Math.pow(2, Disk) - 1][3];
        toh(Disk, 1, 3, 2);
        return ans;

    }

    public static void toh(int Disk, int Source, int Destination, int Mid) {
        if (Disk == 0) {
            return;
        }
        toh(Disk - 1, Source, Mid, Destination);
        ans[i][0] = Disk;
        ans[i][1] = Source;
        ans[i][2] = Destination;
        i++;
        toh(Disk - 1, Mid, Destination, Source);
    }

}
