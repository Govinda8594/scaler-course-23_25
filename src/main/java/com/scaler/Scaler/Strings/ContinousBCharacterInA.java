package com.scaler.Scaler.Strings;

public class ContinousBCharacterInA {

    static int continousBCharacter2(char c,String a,int Blen) {
        int result = 0;
        for(int i=0;i<a.length();i++){
            int othercharr = 0;
            for(int j = i;j<a.length();j++){
                if(a.charAt(j) != c){
                    othercharr++;
                }
                if(othercharr <= Blen){
                    result = Math.max(result,j - i +1);
                }
            }
        }
        return result;
    }

    static int continousBCharacter(char c,String a,int Blen) {
        int result = 0;
       int i =0,j = 0,otherchar = 0;
       int len = a.length();
       while(j<len){
           if(a.charAt(j) != c){
               otherchar++;
           }
           if(otherchar > Blen){
               result = Math.max(result,j-i);
               while(otherchar > Blen){
                   if(a.charAt(i) != c){
                       otherchar--;
                   }
                   i++;
               }
           }
           j++;
       }
        result = Math.max(result,j-i+1);
        return result;
    }
}
