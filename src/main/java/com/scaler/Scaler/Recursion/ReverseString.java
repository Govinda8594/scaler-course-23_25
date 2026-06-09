package com.scaler.Scaler.Recursion;

import java.util.Scanner;

public class ReverseString {
        public static void main(String[] args) {
            // YOUR CODE GOES HERE
            // Please take input and print output to standard input/output (stdin/stdout)
            // DO NOT USE ARGUMENTS FOR INPUTS
            // E.g. 'Scanner' for input & 'System.out' for output
            Scanner sc = new Scanner(System.in);
            String text = sc.nextLine();
            int len = text.length();
            System.out.println(reverseString(text.toCharArray(),0,len-1));
        }

        public static char[] reverseString(char[] text,int start,int end){
            if(start >= end) return text;
            char temp = text[start];
            text[start] = text[end];
            text[end] = temp;
            return reverseString(text,start+1,end-1);
        }
}
