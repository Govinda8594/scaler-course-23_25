package com.scaler.Scaler.Strings;

import java.util.Arrays;

public class SortString {
    public static void main(String[] args) {

//       String s1 = sortOptimizewithfrequency("abcebcbace");
    }

    static String getStoredStringByBubblesort(String A){
        StringBuilder sb = new StringBuilder(A);
        int len = A.length();
        for(int i = 0; i <len-1;i++){
            boolean swapped = false;
            for(int j = 0; j <len-i-1;j++){
                if(sb.charAt(j) > sb.charAt(j+1)){
                    char ch = sb.charAt(j);
                    sb.setCharAt(j,sb.charAt(j+1));
                    sb.setCharAt(j+1,ch);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return sb.toString();
    }

    static String sortOptimizewithfrequency(String A){
        StringBuilder temp = new StringBuilder(A);
        int len = A.length();
        int[] freq = new int[26];
        for(int i=0; i<len; i++){
            freq[A.charAt(i)-'a']++;
        }
        int k = 0;
        for(int i=0; i<26; i++){
            char ch = (char)('a' + i);
            if(freq[i] != 0) {
                for (int j = 1; j <= freq[i]; j++) {
                    temp.setCharAt(k, ch);
                    k++;
                }
            }
        }
        return temp.toString();
    }


}
