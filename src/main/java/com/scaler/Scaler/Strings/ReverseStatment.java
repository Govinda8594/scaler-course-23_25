package com.scaler.Scaler.Strings;

public class ReverseStatment {
    public static void main(String[] args) {
        String ans = Optimize("the sky is blue");
    }

    static String Optimize(String statement){
        String[] words = statement.trim().split(" ");
        int start = 0,end = words.length-1;
        StringBuilder sb = new StringBuilder();
        for(int i = end; i>=0; i--){
            if(start == end){
                sb.append(words[i].trim());
            } else sb.append(words[i].trim()).append(" ");
            start++;
        }
        return sb.toString();
    }

    public String solve(String A) {
        String[] words = A.split(" ");
        int len = words.length;
        String result = "";
        for(int i = 0;i<len;i++){
            if(i == len -1){
                result = words[i] + result;
            }else result = " " + words[i] + result;
        }
        return result;
    }

    static String reverseStatment(String statement){
        String[] words = statement.trim().split(" ");
        int start = 0,end = words.length-1;
        while(start < end){
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
        start = 0;
        end = words.length - 1;
        StringBuilder sb = new StringBuilder();
        for(String temp :words){
            if(start == end){
                sb.append(temp.trim());
            } else sb.append(temp.trim()).append(" ");
          start++;
        }
        return sb.toString();
    }
}
