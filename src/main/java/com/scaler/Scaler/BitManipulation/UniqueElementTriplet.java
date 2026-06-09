package com.scaler.Scaler.BitManipulation;

public class UniqueElementTriplet {
    public static void main(String[] args) {

    }
    // Use hashmap ot store frequency
    // use bruteforce
    //  sort and compare
    //    every element repeat thrice except 1 unique element
    //    every element repeat thrice except 1 element which come twice => c % 3 == 2
    //    every element repeat 5 time except 1 unique element => c % 5 == 1
    //    every element repeat 5 time except 1 element which comes twice => c % 5 == 2
    //    every element repeat 5 time except 1 element which comes thrice => c % 5 == 3
    static int uniqueElement(int[] elements){
        int len = elements.length;
        int ans = 0;
        for(int i = 0;i <= 30;i++){
            int count = 0;
            for(int j = 0;j < len;j++){
                if((elements[j] >> i & 1) == 1) count++;
            }
            if(count % 3 == 1){
                ans = ans + (1 << i);
            }
        }
        return ans;
    }
}
