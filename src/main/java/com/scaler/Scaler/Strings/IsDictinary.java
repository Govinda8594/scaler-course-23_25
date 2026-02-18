package com.scaler.Scaler.Strings;

public class IsDictinary {
    public static void main(String[] args) {

    }

        public int solve(String[] A, String B) {
            int[] idx = new int[26];
            int len = A.length;
            for(int i = 0;i<26;i++){
                idx[B.charAt(i) - 'a'] = i;
            }
            for(int i=0; i<len-1; i++){
                String word1 = A[i];
                String word2  =A[i+1];
                boolean flag = false;
                for(int k = 0;k<Math.min(word1.length(),word2.length());k++){
                    if(word1.charAt(k) != word2.charAt(k)){
                        if(idx[word1.charAt(k) - 'a'] > idx[word2.charAt(k)-'a']){
                            return 0;
                        }
                        flag = true;
                        break;
                    }
                }
                if(flag == false){
                    if(word1.length() > word2.length())
                        return 0;
                }
            }
            return 1;
        }
}
