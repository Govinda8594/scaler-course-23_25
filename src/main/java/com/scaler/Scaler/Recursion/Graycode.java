package com.scaler.Scaler.Recursion;

import java.util.ArrayList;

//The gray code is a binary numeral system where two successive values differ in only one bit.
//
//        Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
//
//        A gray code sequence must begin with 0.
public class Graycode {

    public static ArrayList<Integer> grayCode1(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        grayCodeRecurs(ans, A);
        return ans;
    }

    public static void grayCodeRecurs(ArrayList<Integer> ans, int A) {
        if (A == 1) {
            ans.add(0);
            ans.add(1);
            return;
        }
        grayCodeRecurs(ans, A - 1);
        for (int i = ans.size() - 1; i >= 0; i--) {
            ans.add(ans.get(i) + (int) Math.pow(2, A - 1));
        }
    }

    //////////////////////////////////////////////////////
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (a == 1) {
            al.add(0);
            al.add(1);
            return al;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>(grayCode(a - 1));
        ArrayList<Integer> ans = new ArrayList<Integer>(temp);
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i) + (1 << (a - 1)));
        }
        return ans;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<Integer> grayCode2(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == 1) {
            ans.add(0);
            ans.add(1);
            return ans;
        }
        ArrayList<Integer> temp_list = new ArrayList<>();
        temp_list = grayCode2(A - 1);
        ans = temp_list;
        for (int i = ans.size() - 1; i >= 0; i--) {
            ans.add(ans.get(i) + (1 << (A - 1)));
        }
        return ans;
    }
}
