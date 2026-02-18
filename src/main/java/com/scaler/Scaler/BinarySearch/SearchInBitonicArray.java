package com.scaler.Scaler.BinarySearch;
//Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.
//        NOTE:
//        A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
public class SearchInBitonicArray {
    public int leftBitonicArray(int A[], int B, int l, int h){
        int mid=0;
        while(l<=h){
            mid=l+(h-l)/2;
            if(A[mid]==B){
                return mid;
            }

            else if(A[mid]>B){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }

    // finding the element in the right Bitonic array
    public int rightBitonicArray(int A[], int B, int l, int h){
        int mid=0;
        while(l<=h){
            mid=l+(h-l)/2;
            if(A[mid]==B){
                return mid;
            }

            else if(A[mid]>B){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return -1;
    }

    // finding peak element
    public int solve(int[] A, int B) {

        int N=A.length;
        int l=0, h=N-1, mid=0, midx=0, ans=-1;
        while(l<=h){
            mid=l+(h-l)/2;
            if(A[mid]>A[mid-1] && A[mid]>A[mid+1]){
                midx=mid;
                if(A[mid]==B){
                    return mid;
                }
                break;
            }
            else if(A[mid]>A[mid-1]){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        ans=leftBitonicArray(A,B,0,midx-1);
        if(ans==-1){
            ans=rightBitonicArray(A,B,midx+1,N-1);
        }
        return ans;

    }
}
