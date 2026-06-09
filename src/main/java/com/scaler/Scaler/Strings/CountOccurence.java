package com.scaler.Scaler.Strings;

public class CountOccurence {
//    Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
    public static void main(String[] args) {
        countStringOccurence("abobc");
    }

    static int countStringOccurence(String str){
        int len = str.length(), start = 0,end = 3,count = 0;
        while(end <= len){
            if(str.substring(start, end).equals("bob")){count++;}
            start++;
            end++;
        }
        return count;
    }
}

