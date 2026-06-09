package com.scaler.Scaler.Arrays;

public class SubArrayWhereORZero {
    public static void main(String[] args) {

    }

    static int subArrayOrZero(int [] array){
        int count = 0,len = array.length,ans = 0;
        for(int i = 0; i < len;i++){
            // count no of zero elements
            if(array[i] == 0) count++;
            else{ ans += (count * (count + 1))/2;
            count = 0;
            }
            // if encounter 1 calculate subarray with OR 0 with total subarray formula (n*n+1)/2
        }
        // last array exhausted and didn't find 1 then calculate subarray with OR 0 with total subarray formula (n*n+1)/2
        // and add to answer.
        ans += (count * (count + 1))/2;
        return ans;
    }

    static int subArrayOrOne(int [] array){
        int Zerocount = 0,len = array.length,ans = 0;
        for(int i = 0; i < len;i++){
            // count no of zero elements
            if(array[i] == 0) Zerocount++;
            else{
                ans += (Zerocount * (Zerocount + 1))/2;
                Zerocount = 0;
            }
            // if encounter 1 calculate subarray with OR 0 with total subarray formula (n*n+1)/2
        }
        // last array exhausted and didn't find 1 then calculate subarray with OR 0 with total subarray formula (n*n+1)/2
        // and add to answer.
        ans += (Zerocount * (Zerocount + 1))/2;
        int noOfOR1SubArray = (len * (len + 1))/2 - ans;
        return noOfOR1SubArray;
    }
}
