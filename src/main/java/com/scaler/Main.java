package com.scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main1(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
//        Scanner sc=new Scanner(System.in);
//        int T=sc.nextInt();
//        ArrayList<Integer> arr = new ArrayList<>(T);
//        for(int j=0; j<T; j++){
//            arr.add(sc.nextInt());
//        }
//        arr.remove(sc.nextInt()-1);
//        for(Integer i : arr){
//            System.out.print((int)i+" ");
//        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
        }
        String s = "sfsdf";
        Integer f = 5;
        int[] A = {6, 43, 5, 232, 8, 64, 8, 3, 5, 3};
        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
        if (A.length > 1) {
            for (int k = 0; k + 1 < A.length; k++) {
                if (A[k + 1] < A[k]) {
                    System.out.println(A[k + 1]);
//                        System.out.println(Math.max(5,7));
                    break;
                }
            }
        }
        System.out.print(-1);
        String B = "16";
        String digit = B.substring(B.length() - 2, B.length());
        int num = Integer.valueOf(digit);
        if (num % 8 == 0) {
//            return 1;
        }
//        return 0;
    }

    public static void main2(String[] args) {
//        reduced_String(3,"geegsforgeeeks");
        printKClosest(new int[]{1, 3, 13, 17, 18}, 5, 2, 2);
    }
    //    public static int reverseString(String A) {
//        String odd = "", even = "";
//        int len = A.length();
//        for (int i = 0; i < len; i++) {
//            if (A.charAt(i) % 2 == 0) even = even + A.charAt(i);
//            else odd = odd + A.charAt(i);
//        }
//        Arrays.sort(odd.toCharArray());
//        Arrays.sort(even.toCharArray());
//        int l1 = odd.length(), l2 = even.length();
//        if (Math.abs(odd.charAt(l1 - 1) - even.charAt(0)) != 1) return 1;
//        if (Math.abs(even.charAt(l2 - 1) - odd.charAt(0)) != 1) return 1;
//        return 0;
//    }

    static int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        int targetIdx = floorIndexBinarySearch(arr, x);
        int res[] = new int[k];
        int left = targetIdx;
        int right = targetIdx + 1;
        int i = 0;
        if (arr[targetIdx] == x) {
            left = targetIdx - 1;
        }
        while (i < k && left >= 0 && right < arr.length) {
            if (x - arr[left] < arr[right] - x) {
                res[i++] = arr[left--];
            } else {
                res[i++] = arr[right++];
            }
        }
        while (i < k && left >= 0) {
            res[i++] = arr[left--];
        }
        while (i < k && right < arr.length) {
            res[i++] = arr[right++];
        }
        return res;
    }

    static private int floorIndexBinarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[low] > target) {
            return low;
        }
        if (arr[high] < target) {
            return high;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static String reduced_String(int k, String s) {
        // Your code goes here
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (char ch : s.toCharArray()) {
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == ch) {
                count++;
            } else {
                count = 1;
            }
            if (count == k) {
                while (ans.length() > 0 && ans.charAt(ans.length() - 1) == ch) {
                    ans.deleteCharAt(ans.length() - 1);
                }
                count = 1;
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    static Long[] distributeCandies(int N, int K) {
        // code here
        Long[] ans = new Long[K];
        Arrays.fill(ans, 0);
        int count = 0;
        int ind = 1;
        while (N > 0) {
            int f1 = (ind - 1) * K;
            int f2 = ind * K;
            int sum1 = (f1 * (f1 + 1)) / 2;
            int sum2 = (f2 * (f2 + 1)) / 2;
            int res = sum2 - sum1;
            if (res <= N) {
                count++;
                N -= res;
                ind++;
            } else {
                int i = 0;
                int term = ((ind - 1) * K) + 1;
                while (N > 0) {
                    if (term <= N) {
                        ans[i] = Long.valueOf(term);
                        N -= term;
                        term++;
                    } else {
                        ans[i] = Long.valueOf(N);
                        N = 0;
                    }
                    i++;
                }
            }
        }
        for (int i = 0; i < K; i++) {
            ans[i] = ans[i] + (count * (i + 1)) + (K * (count * (count - 1)) / 2);
        }
        return ans;
    }

    public static void main(String[] args) {
        smallestNumber(2, 6);
    }

    public static String smallestNumber(int s, int d) {
        StringBuilder res = new StringBuilder();
        int i = 1;
        while (i <= d) {
            int num = Math.max(s - (d - i) * 9, 0);
            if (num > 9) {
                return "-1";
            }
            if (i == 1 && num == 0) {
                num = 1;
            }
            res.append((char) (num + '0'));
            s -= num;
            i++;
        }
        return res.toString();
    }

    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> li = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < B.length; i++) {
            if (hm.containsKey(B[i])) {
                if (hm.get(B[i]) > 0) {
                    li.add(B[i]);
                    hm.put(B[i], hm.get(B[i]) - 1);
                }
            }
        }
        int[] arr = new int[li.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = li.get(i);
        }
        return arr;
    }

    class Pair {
        int idx;
        int num;

        Pair(int i, int val) {
            idx = i;
            num = val;
        }

    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
