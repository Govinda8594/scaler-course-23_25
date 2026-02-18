package com.scaler.Scaler.Strings;

public class SubStringlength {

    public static void main(String[] args) {
            String A = "amazon";
        int ans= 0, substringlen;
        for(int i = 0;i<A.length();i++){
            if(Character.toString(A.charAt(i)).toString().equalsIgnoreCase("a") ||
                    Character.toString(A.charAt(i)).toString().equalsIgnoreCase("e") ||
                    Character.toString(A.charAt(i)).toString().equalsIgnoreCase("i") ||
                    Character.toString(A.charAt(i)).toString().equalsIgnoreCase("o") ||
                    Character.toString(A.charAt(i)).toString().equalsIgnoreCase("u")
            ){
                substringlen = A.length() - i;
                ans += substringlen;
                ans = ans%10003;

            }
        }
            System.out.println(ans % 10003);
        }
}

