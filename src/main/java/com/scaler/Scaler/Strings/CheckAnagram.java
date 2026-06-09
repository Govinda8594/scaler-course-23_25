package com.scaler.Scaler.Strings;

public class CheckAnagram {
//    You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.
//            Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.
    public int solve(String A, String B) {
       int[] freq1= new int[26];
       int[] freq2 = new int[26];

       for(int i = 0;i<A.length();i++){
           freq1[A.charAt(i) - 'a']++;
       }

       for(int i = 0;i<B.length();i++){
           freq2[B.charAt(i)-'a']++;
       }
       for(int i=0;i<26;i++) {
           if (freq1[i] != 0 || freq2[i] != 0) {
               if (freq1[i] != freq2[i]) {
                   return 0;
               }
           }
            }
       return 1;
        
    }
}