package com.scaler.Scaler.Strings;

import java.util.Arrays;

public class SortStringBasedOnFrequency {
    public static void main(String[] args) {
        String ans = solve("abcabcbadbccbffbbcd");
    }
    //    optimize contract failed 10 power 5
    public static String solve(String A) {
        int len = A.length();
        int[] freq = new int[26];
        for(int i = 0;i<len;i++){
            freq[A.charAt(i)- 'a']++;
        }

        Character[] carray = new Character[len];
        int i = 0;
        for(char c:A.toCharArray()){
            carray[i++] = c;
        }
        Arrays.sort(carray,(a, b)-> {
            int freq1 = freq[a.charValue() - 'a'];
            int freq2 = freq[b.charValue() - 'a'];
            if(freq1 > freq2)
                return -1;
            else if(freq1 < freq2)
                return 1;
            else return (a.charValue() - 'a') - (b.charValue()-'a');
        });

        StringBuilder ans = new StringBuilder();
        for(Character ch : carray){
            ans.append(ch);
        }
        String  s = ans.toString();
        return s;
    }
}
