package com.scaler.Scaler.GreedyProblem;
//The monetary system in DarkLand is really simple and systematic. The locals-only use coins. The coins come in different values. The values used are:
//
//        1, 5, 25, 125, 625, 3125, 15625, ...
//        Formally, for each K >= 0 there are coins worth 5K.
//
//        Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).

public class SmallestNoOfCoins {
    public static void main(String[] args) {
        solve(47);
    }

    public static int solve(int A) {
        int ans = 0;
        while (A != 0) {
            ans += A % 5;
            A = A / 5;
        }
        return ans;
    }
}
