package com.scaler.Scaler.Strings;

import java.util.Arrays;

public class ReverseString {


        public static void main(String[] args) {
            String text = "Hello, world";
            int len = text.length();
//            System.out.println(reverseString(text.toCharArray(),0,len-1));
        }

        public static char[] reverseString(char[] text,int start,int end){
            if(start >= end) return text;
            char temp = text[start];
            text[start] = text[end];
            text[end] = temp;
            return reverseString(text,start++,end--);

        }




}


