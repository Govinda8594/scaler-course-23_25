package com.scaler.Scaler.Hashing;

import java.util.HashSet;

//Given a number A, find if it is COLORFUL number or not.
//
//        If number A is a COLORFUL number return 1 else, return 0.
//
//        What is a COLORFUL Number:
//
//        A number can be broken into different consecutive sequence of digits.
//        The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
//        This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
public class ColorfulElement {
    public static void main(String[] args) {
        ColorfulElement colorfulElement = new ColorfulElement();
        colorfulElement.colorful1(3245);
    }

    public int colorful1(int A) {
        HashSet<Integer> set = new HashSet<>();
        while (A > 0) {
            int temp = A;
            int product = 1;
            while (temp > 0) {
                product = product * (temp % 10);
                if (!set.add(product)) {
                    return 0;
                }
                set.add(product);
                temp /= 10;
            }
            A /= 10;
        }
        return 1;
    }

}
