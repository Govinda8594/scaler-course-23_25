package com.scaler.Scaler.MathDSA.GeneralProblem;

public class ArmStrongNumber {
    //    If sum of cubes of each digit of the number is equal to the number itself,
//    then the number is called an Armstrong number.
//    For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ).
    public static void main(String[] args) {
        int A = 454;
        // loop check 1 to 454 , how many armstrong number
        for (int i = 1; i <= A; i++) {
            int temp = i;
            int remainder = 0;
            int sum = 0;
            // check armstrong number
            while (temp > 0) {
                remainder = temp % 10;
                temp = temp / 10;
                sum += (remainder * remainder * remainder);
            }
            if (sum == i) {
                System.out.println(sum);
            }
        }
    }
}
