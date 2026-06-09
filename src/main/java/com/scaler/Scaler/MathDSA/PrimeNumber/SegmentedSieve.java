package com.scaler.Scaler.MathDSA.PrimeNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity: O(n log log n)
//        Space Complexity: O(√n + segment_size)

//Key Features:
//        Base Prime Generation:
//        Uses standard Sieve of Eratosthenes to generate primes up to √high
//        These primes are used to mark composites in the target segment
//        Segment Handling:
//        Creates a boolean array sized for the target range [low, high]
//        Handles edge cases for low=0 and low=1
//        Efficient Marking:
//        For each base prime, calculates the first multiple in the segment
//        Starts marking from max(prime², first_multiple) for efficiency
//        Only marks within the target segment
//        Result Collection:
//        Scans the segment array to collect remaining primes
//        Adjusts indexes by low offset to get actual values
//Advantages over Simple Sieve:
//        Memory Efficient: Uses O(√n + segment_size) memory instead of O(n)
//        Range Flexibility: Can generate primes for any sub-range without generating all primes up to n
//        Large Range Support: Can handle ranges where full sieve would exceed memory
//        This implementation is optimized for clarity while maintaining proper sieve efficiency. For production use, you might add:
//        Input validation
//        Large integer handling
//        Parallel processing for very large segments
//        Wheel factorization optimizations
public class SegmentedSieve {
    public static void main(String[] args) {
        int low = 100, high = 300;  // Example range
        List<Integer> primes = segmentedSieve(low, high);
        System.out.println("Primes between " + low + " and " + high + ":");
        System.out.println(primes);
    }

    public static List<Integer> segmentedSieve(int low, int high) {
        // Step 1: Generate base primes up to sqrt(high)
        int limit = (int) Math.sqrt(high) + 1;
        boolean[] baseSieve = new boolean[limit + 1];
        Arrays.fill(baseSieve, true);
        baseSieve[0] = baseSieve[1] = false;

        // Standard Sieve for base primes
        for (int i = 2; i * i <= limit; i++) {
            if (baseSieve[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    baseSieve[j] = false;
                }
            }
        }

        // Collect base primes
        List<Integer> basePrimes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (baseSieve[i]) basePrimes.add(i);
        }

        // Step 2: Initialize segment sieve
        int n = high - low + 1;
        boolean[] segmentSieve = new boolean[n];
        Arrays.fill(segmentSieve, true);

        // Handle low=0 or low=1 cases
        if (low == 0) {
            segmentSieve[0] = false;
            if (n > 1) segmentSieve[1] = false;
        } else if (low == 1) {
            segmentSieve[0] = false;
        }

        // Step 3: Mark non-primes in segment using base primes
        for (int prime : basePrimes) {
            // Find first multiple in segment
            int start = (int) Math.ceil((double) low / prime) * prime;
            if (start < low) start += prime;  // Ensure within range

            // Start from max(prime^2, start)
            start = Math.max(start, prime * prime);

            // Mark multiples in segment
            for (int j = start; j <= high; j += prime) {
                segmentSieve[j - low] = false;
            }
        }

        // Step 4: Collect primes from segment
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (segmentSieve[i]) {
                primes.add(i + low);
            }
        }

        return primes;
    }
}