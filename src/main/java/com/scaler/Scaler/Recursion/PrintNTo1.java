package com.scaler.Scaler.Recursion;

public class PrintNTo1 {

    public void solve(int A) {
        printNums(A);
        System.out.println("");
    }
    void printNums(int N)    {
        if(N == 1){
            System.out.print(1 + " ");
            return;
        }
        System.out.print(N + " ");
        printNums(N-1);
    }
}
