package com.scaler.Scaler.Arrays;

import java.util.stream.IntStream;

//Given an integer A, find and return the total number of digit 1 appearing in all non-negative integers less than or equal to A.
public class NoOfDigit1 {
    public static void main(String[] args) {
        solve2(23);
    }

    ////////////////////////////////////////////////////////////////////////////
    public static int solve2(int A) {
        int count = 0; // Initialize count to store the number of times digit '1' appears
        int k = 1; // Initialize k to represent the current digit position (units, tens, hundreds, etc.)

        // Loop to process each digit position
        while (A / k > 0) {
            int prefix = A / (k * 10); // Prefix represents the part of the number before the current digit position
            int cur = (A / k) % 10; // cur represents the current digit
            int suffix = A % k; // Suffix represents the part of the number after the current digit position

            // If the current digit is 0
            if (cur == 0) {
                count += prefix * k; // Count the 1s contributed by the prefix
            }
            // If the current digit is 1
            else if (cur == 1) {
                count += prefix * k + suffix + 1; // Count the 1s contributed by the prefix, current digit, and suffix
            }
            // If the current digit is greater than 1
            else {
                count += (prefix + 1) * k; // Count the 1s contributed by the prefix and the additional range due to the current digit
            }

            k *= 10; // Move to the next digit position (units to tens, tens to hundreds, etc.)
        }

        return count; // Return the total count of digit '1' occurrences
    }


    ////////////////////////////////////////////////////////////////////////////////////
    static int countDigits(int A) {
        int count = 0;
        for (int i = 1; i <= A; i++) {
            int num = i;
            while (num >= 1) {
                int digit = num % 10;
                if (digit == 1) {
                    count++;
                }
                num = num / 10;
            }
        }
        return count;
    }

    public int solve(int A) {
        int count = 0;
        for (int i = 1; i <= A; i *= 10) {
            count += (A / (i * 10)) * i + Math.min(Math.max(A % (i * 10) - (i - 1), 0), i);
        }
        return count;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public int solve3(int A) {
        return IntStream.rangeClosed(1, A)
                .parallel()
                .flatMap(n -> String.valueOf(n).chars())
                .map(c -> c == '1' ? 1 : 0)
                .sum();
    }
}
