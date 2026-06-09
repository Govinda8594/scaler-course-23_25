package com.scaler.Scaler.Combinatrics;
//Given a string A, find the rank of the string amongst its permutations sorted lexicographically.
//        Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
//        Look at the example for more details.
//        NOTE:
//        The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
//        String A can consist of both lowercase and uppercase letters. Characters with lesser ASCII values are considered smaller, i.e., 'a' > 'Z'.

public class RankOfStringWithRepeatedCharacter {
    public int findRank(String A) {
        int m = 1000003;
        int n  = A.length();
        long rank = 1;
        int[] freq = new int[52];
        freq[idx(A.charAt(n-1))]++;
        long perm = 1;
        for (int i = n-2; i >= 0; i--) {
            int id = idx(A.charAt(i));
            freq[id]++;
            for (int j = 0; j < id; j++) {
                if (freq[j] != 0) {
                    long temp =  (perm * freq[j]) % m;
                    temp = (temp * pow(freq[id], m)) % m;
                    rank = (rank + temp) % m;
                }
            }
            perm = (perm * (n-i)) % m;
            perm = (perm * pow(freq[id], m)) % m;
            //System.out.println(rank+" "+perm);
        }
        return (int) rank;
    }

    public long pow(int num, int m) {
        long res = 1;
        long n = num % m;
        int p = m - 2;
        while (p > 0) {
            if ((p & 1) == 1)
                res = (res * n) % m;
            n = (n * n) % m;
            p >>= 1;
        }
        return res;
    }

    public int idx(char c) {
        if (c <= 'Z')
            return c - 'A';
        return c - 'a' + 26;
    }
}
