package com.scaler.Scaler.MathDSA.GeneralProblem;

//Given a number A, check if it is a magic number or not.
//A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.
public class IsMagicNumber {
    public static int digitSum(int A) {
        if (A == 0) {
            return 0;
        }
        return A % 10 + digitSum(A / 10);
    }

    static int ismagicNumber(int number) {
        if (number < 10) {
            return (number == 1) ? 1 : 0;
        }
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return ismagicNumber(sum);
    }

    static int ismagicNumberBruteForce(int A) {
        do {
            A = digitSum(A);
        } while (A >= 10);
        if (A == 1) {
            return 1;
        }
        return 0;
    }


    public int solv2e(int A) {
        while (A > 9) {
            A = digitSum(A);
        }
        return A == 1 ? 1 : 0;
    }


    public int ismagicNumberOptimize(int A) {
        //The divisibility rule of 9 says that a number is divisible by 9 if the sum of its digits
        // are also divisible by 9. Therefore, if a number is divisible by 9, then, recursively,
        // all the digit sums are also divisible by 9. The final digit sum is always 9.
        // An increase of 1 in the original number will increase the ultimate value by 1, making it 10
        // and the ultimate sum will be 1, thus verifying that it is a magic number.
        if (A % 9 == 1) {
            return 1;
        }
        return 0;
    }
    /////////////////////////////////////////////////////////////////////////////

    public int solve(int A) {
        // the value we need to compute is called as DIGITAL ROOT.
// and there's a formula to get this in O(1).
        int ans;
        if (A == 0) {
            ans = 0;
        } else if (A % 9 == 0) {
            ans = 9;
        } else {
            ans = (A % 9);
        }
// can also combine it to a single statement
// ans = (A == 0) ? 0 : 1 + (A-1) % 9;
// to check if its magic or not.
// magic if digital-root is 1 else not a magic.
        return (ans == 1) ? 1 : 0;
    }
}
