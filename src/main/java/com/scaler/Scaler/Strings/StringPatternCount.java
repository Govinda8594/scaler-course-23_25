package com.scaler.Scaler.Strings;

public class StringPatternCount {
    public static void main(String[] args) {
        stringCount(5,"#**#*");
    }
        public static int stringCount(int n, String s) {
            // Write your code here.
            int count = 0, i = 0,j = i + 1;
            while(i < n && j < n){
                if(s.substring(i, j+1).length() == 2){
                    if(s.substring(i, j+1).equals("*#") || s.substring(i, j+1).equals("#*")){
                        count++;
                    }
                }
                j++;
                if(j == n){
                    i++;
                    j = i+1;
                }
            }
            // for(int i=0;i<n;i++){
            //     for(int j=i+1;j<n;j++){
            //         // if(s.substring(i, j).length() == 2){
            //         if(s.substring(i, j+1).equals("*#") || s.substring(i, j+1).equals("#*")){
            //             count++;
            //         }
            //         // }
            //     }
            // }
            return count;
        }
}
