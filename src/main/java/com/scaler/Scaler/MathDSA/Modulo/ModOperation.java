package com.scaler.Scaler.MathDSA.Modulo;

public class ModOperation {
    public static void main(String[] args) {
        Concatenate(20, 33, 20);
    }

    //    You are given a large number in the form of a array A of size N where each element denotes a digit of the number.
//    You are also given a number B. You have to find out the value of A % B and return it.
    public static int modArray(int[] A, int B) {
        long sum = 0;
        long t = 1; // multiplier 10 pow 0,10 pow 1, 10 pow 2
        for (int i = A.length - 1; i >= 0; i--) {
            sum = (sum + A[i] * t) % B;
            t = (t * 10) % B;
        }
        return (int) sum;
    }

    //    You are given A, B and C .
//    Calculate the value of (A ^ B) % C
    public static int powerModulo(int A, int B, int C) {
        long ans = 1;
        for (int i = 1; i <= B; i++) {
            ans = (ans * A) % C;
        }
        return (int) ans;
    }

    //    Given a number in the form of an array A of size N. Each of the digits of the number is represented by A[i]. Check if the number is divisible by 3.
//    sum of the digits of the number % 3
    public static int divisibilityRule3(int[] A) {
        int sum = 0;
        for (int j : A) {
            sum += j;
        }
        if (sum % 3 == 0)
            return 1;
        return 0;
    }

    public static int Concatenate(int A, int B, int C) {
        int answer = 0;
        if (A <= B && B <= C)
            answer = Integer.parseInt(Integer.toString(A).concat(Integer.toString(B)).concat(Integer.toString(C)));
        else if (B <= C && C <= A)
            answer = Integer.parseInt(Integer.toString(B).concat(Integer.toString(C)).concat(Integer.toString(A)));
        else if (C <= A && A <= B)
            answer = Integer.parseInt(Integer.toString(C).concat(Integer.toString(A)).concat(Integer.toString(B)));
        else if (A <= C && C <= B)
            answer = Integer.parseInt(Integer.toString(A).concat(Integer.toString(C)).concat(Integer.toString(B)));
        else if (A <= C)
            answer = Integer.parseInt(Integer.toString(B).concat(Integer.toString(A)).concat(Integer.toString(C)));
        else answer = Integer.parseInt(Integer.toString(C).concat(Integer.toString(B)).concat(Integer.toString(A)));
        return answer;
    }

    // last 3 digits of a number % 8
    public int divisibilityRule8(String A) {
        String digit = "";
        if (A.length() > 3)
            digit = A.substring(A.length() - 3);
        else digit = A;
        int num = Integer.parseInt(digit);
        if (num % 8 == 0) {
            return 1;
        }
        return 0;
    }

    //    Given an integer A representing a year, Return 1 if it is a leap year else, return 0.
//    A year is a leap year if the following conditions are satisfied:
//    The year is multiple of 400.
//    or the year is multiple of 4 and not multiple of 100.
    public int solve(int A) {
        int ans = 0;
        if (A % 4 == 0 && A % 100 != 0)
            ans = 1;
        else if (A % 400 == 0) {
            ans = 1;
        }
        return ans;
    }
}
