package com.scaler.Scaler.Strings;
//You are given a string A. Find the number of substrings that start and end with 'a'.
public class CountNoOfSubString {
        public int solve(String A) {
            int countOfA = 0;
            for(int i =0; i < A.length(); i++){
                if(A.charAt(i) == 'a'){
                    countOfA++;
                }
            }
            return (countOfA * (countOfA + 1)) / 2;
        }

}
