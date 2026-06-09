package com.scaler.Scaler.BitManipulation;

public class LengthOfLongest1s {
    public static void main(String[] args) {
        LengthOfLongest1s lengthOfLongest1s = new LengthOfLongest1s();
        System.out.println(lengthOfLongest1s.swapOswith1s("111000"));
    }

    // swaping O's with 1's within the array itself
    public int swapOswith1s(String A) {
        int len = A.length();
        int count = 0;
        for(int i = 0;i<len;i++){
            count += Character.getNumericValue(A.charAt(i));
        }
        if(count == len) return len;
        if(count == 0) return 0;
        int ans = 0;
        for(int i = 0;i<len;i++){
            if(Character.getNumericValue(A.charAt(i)) == 0){
                int l = 0,r = 0;
                for(int j = i-1;j>=0;j--){
                    if(Character.getNumericValue(A.charAt(j)) == 1)
                        l++;
                    else 
                        break;    
                }

                for(int j = i+1;j<len;j++){
                    if(Character.getNumericValue(A.charAt(j)) == 1)
                        r++;
                    else 
                        break;    
                }
                int c = l + r;
                if (count > l + r) {
                    c++;
                }
                if(c > ans) 
                    ans = c;
            }
        }
        return ans;
    }


    // replace O's with 1's
    public int LengthOfLongest1s(String A) {
        int len = A.length();
        int count = 0;
        for(int i = 0;i<len;i++){
            count += Character.getNumericValue(A.charAt(i));
        }
        if(count == len) return len;
        if(count == 0) return 1;
        int ans = 0;
        for(int i = 0;i<len;i++){
            if(Character.getNumericValue(A.charAt(i)) == 0){
                int l = 0,r = 0;
                for(int j = i-1;j>=0;j--){
                    if(Character.getNumericValue(A.charAt(j)) == 1)
                        l++;
                    else
                        break;
                }

                for(int j = i+1;j<len;j++){
                    if(Character.getNumericValue(A.charAt(j)) == 1)
                        r++;
                    else
                        break;
                }
                int c = l + r + 1;
                if(c > ans)
                    ans = c;
            }
        }
        return ans;
    }
}
