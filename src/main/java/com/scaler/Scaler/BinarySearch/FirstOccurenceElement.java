package com.scaler.Scaler.BinarySearch;

import java.util.ArrayList;

public class FirstOccurenceElement {
    public static void main(String[] args) {
        int ans = getfrequency(new int[]{0, 5, 5, 6, 7, 7, 7, 8}, 8);
    }
    static int getFirstOccurence(int[] array, int k) {
        int low = 0, high = array.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    static int getFloorElement(int[] array, int k) {
        int low = 0, high = array.length - 1, ans = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < k) {
                ans = array[mid];
                low = mid + 1;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                return array[mid];
            }
        }
        return ans;
    }

    static int getlastOccurence(int[] array, int k) {
        int low = 0, high = array.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    static int getfrequency(int[] array, int k) {
        int i = getFirstOccurence(array, k);
        int j = getlastOccurence(array, k);
        return j - i + 1;
    }

////////////////////////////////////////////////////////////////////////////////////////
    ArrayList<Integer> find(int arr[], int n, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = n-1;
        list.add(-1);
        list.add(-1);

        while(left <= right) {
            if(arr[left] == x && arr[right] == x) {
                list.add(0,left);
                list.add(1,right);
                break;
            }
            if(arr[left] != x ) left++;

            if(arr[right] != x ) right--;
        }
        return list;
    }

}
