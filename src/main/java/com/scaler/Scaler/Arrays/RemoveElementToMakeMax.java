package com.scaler.Scaler.Arrays;

public class RemoveElementToMakeMax {
    public static void main(String[] args) {
        removeElement(new int[]{23,47,8,49,47,32,48,4,36,11,8,13,2,10,18,39,31,45,9,30},13);
    }

    static int removeElement(int[] A,int B){
        int len = A.length,count = 0;
        for(int i= 0;i<len;i++){
            if(A[i] > B)
                count++;
        }
        for (int i=0;i<len;i++){
            if(A[i] == B)
                return count;
        }
        return -1;
    }

    static int removeElement1(int[] A,int B){
        int len = A.length,count = 0;
        boolean ispresent = false;
        for(int i= 0;i<len;i++){
            if(A[i] == B)
                 ispresent = true;
            if(A[i] > B)
                count++;
        }
       return ispresent ? count : -1;
    }
}
