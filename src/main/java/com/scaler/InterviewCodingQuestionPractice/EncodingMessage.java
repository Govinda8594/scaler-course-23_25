package com.scaler.InterviewCodingQuestionPractice;

import java.util.Scanner;

public class EncodingMessage {
    public static void main(String[] args) {

        System.out.println(encode("ssssssssss"));
    }
        public static String encode(String message) {
            // Write your code here.
            int len = message.length();
            int count = 1;
            StringBuilder ans  = new StringBuilder();
            if(len == 1){
                return ans.append(message).append(count).toString();
            }
            int i = 0,j = i+1;
            while(j<=len-1) {
                if(Character.compare(message.charAt(i),message.charAt(j)) == 0){
                    count++;
                }
                else {
                    ans.append(message.charAt(i));
                    ans.append(count);
                    count = 1;

                }
                i++;j++;
                if(j == len){
                    ans.append(message.charAt(j-1));
                    ans.append(count);
                }
            }
            return ans.toString();
        }
}
