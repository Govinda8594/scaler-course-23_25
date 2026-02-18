package com.scaler.Scaler.BinarySearch;

import java.util.List;
//There are two sorted arrays A and B of sizes N and M respectively.
//        Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
//        NOTE:
//        The overall run time complexity should be O(log(m+n)).
//        IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
public class MedianOfTwoSortedArray {
        public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
            int m = a.size();
            int n = b.size();
            if (m > n) {
                return findMedianSortedArrays(b, a);
            }
            int partition = (m + n + 1) / 2;
            int low = 0, high = m;
            while (low <= high) {
                int cut1 = (low + high) / 2;
                int cut2 = partition - cut1;
                int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a.get(cut1 - 1);
                int r1 = (cut1 == m) ? Integer.MAX_VALUE : a.get(cut1);
                int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b.get(cut2 - 1);
                int r2 = (cut2 == n) ? Integer.MAX_VALUE : b.get(cut2);
                if (l1 <= r2 && l2 <= r1) {
                    int total = m + n;
                    int maxLeft = Math.max(l1, l2);
                    int minRight = Math.min(r1, r2);
                    if (total % 2 == 0)
                        return (double)(0.5 * (maxLeft + minRight));
                    return maxLeft;
                } else if (l1 > r2) {
                    high = cut1 - 1;
                } else {
                    low = cut1 + 1;
                }
            }
            return (double) 0.0;
        }

    public double findMedianSortedArrays2(final List<Integer> a, final List<Integer> b) {
        if(b.size()<a.size()) return findMedianSortedArrays(b,a);
        int n1=a.size();
        int n2=b.size();
        int low=0,high=n1;
        while(low<=high){
            int cut1=(low+high)>>1;
            int cut2=(n1+n2+1)/2-cut1;
            int left1=cut1==0?Integer.MIN_VALUE:a.get(cut1-1);
            int left2=cut2==0?Integer.MIN_VALUE:b.get(cut2-1);
            int right1=cut1==n1?Integer.MAX_VALUE:a.get(cut1);
            int right2=cut2==n2?Integer.MAX_VALUE:b.get(cut2);
            if(left1<=right2&& left2<=right1){
                if((n1+n2)%2==0){
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }
                else{
                    return(Math.max(left1,left2));
                }
            }
            else if(left1> right2){
                high=cut1-1;
            }
            else{
                low=cut1+1;
            }
        }
        return 0.0;

    }
}
