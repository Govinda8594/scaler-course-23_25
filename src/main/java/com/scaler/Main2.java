package com.scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    static int minSteps(int[] A, int N, int K) {
        // code here
        Arrays.sort(A);
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0)
                p[i] = A[i];
            else
                p[i] = p[i - 1] + A[i];
        }

        int ans = Integer.MAX_VALUE, start = 0;

        for (int i = 0; i < N; i++) {
            int ind = findUpper(A, A[i] + K, i, N - 1);
            if (ind == -1)
                ind = N;
            if (i > 0 && A[i] != A[i - 1])
                start = p[i - 1];
            ans = Math.min(ans, start + (p[N - 1] - p[ind - 1]) - ((A[i] + K) * (N - ind)));
        }
        return ans;
    }

    static int findUpper(int[] arr, int target, int s, int e) {
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] > target) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    static void main(String[] args) {
//        checkCompressed("GEEKSFORGEEKS", "G12S");
//        closestPalindrome(489);
        List<String> as = Arrays.asList("cats", "cat", "and", "sand", "dog");
//        wordBreak(5, as, "catsanddog");
        wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
        max_Books(new int[]{2, 8, 12, 9, 19, 4, 15, 15, 2, 3, 8}, 11, 10);

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int i = 0, j = 1, n = s.length();
        boolean isPresent = false;
        while (j <= n) {
            if (wordDict.contains(s.substring(i, j))) {
                i = j;
                j++;
                isPresent = true;
            } else {
                j++;
                isPresent = false;
            }
        }
        return isPresent;
    }

    static long max_Books(int[] arr, int n, int k) {
        // Your code here
        long ans = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k)
                count += arr[i];
            else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        if (count != 0)
            ans = Math.max(ans, count);
        return ans;
    }

    static int checkCompressed(String S, String T) {
        // code here
        int i = 0, j = 0;
        while (i < S.length() && j < T.length()) {
            char c = S.charAt(i);
            char ch = T.charAt(j);
            if (c == ch) {
                i++;
                j++;
            } else if (Character.isDigit(ch)) {
                String temp = "";
                while (j < T.length() && Character.isDigit(T.charAt(j))) {
                    temp = temp + T.charAt(j);
                    j += 1;
                }
                i += Integer.parseInt(temp);
            } else {
                return 0;
            }
        }
        if (i == S.length() && j == T.length()) return 1;
        return 0;
    }

    static String secondSmallest(int S, int D) {
        // code here
        if (D == 1)
            return Integer.toString(S);
        int[] num = new int[D]; // create an array to store the digits of the number
        for (int i = D - 1; i > 0; i--) { // loop from D-1 to 1
            int d = Math.min(S - 1, 9); // calculate the maximum digit value that can be placed at the current index
            num[i] = d; // store the digit in the array
            S -= d; // subtract the digit value from the sum
        }
        if (S > 9) { // if the remaining sum is greater than 9, it means there is no possible number with given sum and number of digits
            return "-1";
        }
        num[0] = S; // store the remaining sum at the first index
        for (int i = D - 1; i > 0; i--) { // loop from D-1 to 1
            if (num[i] != 0 && num[i - 1] != 9) { // if the current digit and the previous digit are not equal to 0 and 9 respectively
                num[i] -= 1; // decrement the current digit
                num[i - 1] += 1; // increment the previous digit
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < D; j++) {
                    sb.append(num[j]); // construct the final string using StringBuilder
                }
                return sb.toString(); // return the second smallest number
            }
        }
        return "-1"; // if no second smallest number is possible, return -1
    }

    public static long closestPalindrome(long num) {
        if (num < 10)
            return num;
        String str = Long.toString(num);
        int len = str.length();
        long left = Long.parseLong(str.substring(0, (len + 1) / 2));
        long res = getPalindrom(left, (len % 2) != 0);
        res = getCloser(num, res, getPalindrom(left + 1, true));
        res = getCloser(num, res, getPalindrom(left + 1, false));
        res = getCloser(num, res, getPalindrom(left - 1, true));
        res = getCloser(num, res, getPalindrom(left - 1, false));
        return res;
    }

    private static long getPalindrom(long left, boolean skipFirst) {
        long res = left;
        left = skipFirst ? left / 10 : left;
        while (left != 0) {
            res = res * 10 + left % 10;
            left = left / 10;
        }
        return res;
    }

    private static long getCloser(long num, long prev, long next) {
        if (Math.abs(num - prev) > Math.abs(num - next) ||
                (Math.abs(num - prev) == Math.abs(num - next) && next < prev)) {
            return next;
        }
        return prev;
    }

    public static ArrayList<ArrayList<Integer>> AllSubsets(int[] arr, int n) {
        // your code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        res.add(subset);
        subset(0, arr, n, subset, res);
        res.sort((o1, o2) -> o1.size() - o2.size());
        return res;
    }

    static void subset(int i, int[] arr, int n, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> res) {
        if (i == n) {
            // if(!res.contains(subset))
            res.add(new ArrayList<Integer>(subset));
            return;
        }

        for (int j = i; j < n; j++) {
            subset.add(arr[j]);
            subset(j + 1, arr, n, subset, res);
            subset.remove(subset.size() - 1);
        }

    }

    static List<String> wordBreak(int n, List<String> dict, String s) {
        // code here
        List<String> res = new ArrayList<>();
        buildString(dict, s, "", res);
        return res;
    }

    static void buildString(List<String> dict, String s, String sentence, List<String> res) {
        if (s.length() == 0) {
            res.add(sentence.substring(0, sentence.length() - 1));
        }
        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i + 1);
            if (dict.contains(word)) {
                String temp = s.substring(i + 1);
                buildString(dict, temp, sentence + word + " ", res);
            }
        }
    }

    static int zigzagSequence(int n, int[][] M) {
        // code here
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = -1;
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, recursion(0, j, n, M, dp));
        }
        return ans;

    }

    static int recursion(int i, int j, int n, int[][] mat, int[][] dp) {
        if (i == n - 1)
            return mat[i][j];
        if (dp[i][j] == -1) {
            for (int k = 0; k < n; k++) {
                if (j != k) {
                    dp[i][j] = Math.max(dp[i][j], recursion(i + 1, k, n, mat, dp) + mat[i][j]);
                }
            }

        }
        return dp[i][j];
    }


    public List<String> find_permutation(String S) {
        // Code here
        int n = S.length();
        ArrayList<String> ans = new ArrayList<>();
        solve(S.toCharArray(), 0, n, ans);
//        Arrays.sort();
        return ans;
    }

    void solve(char[] S, int idx, int n, ArrayList<String> ans) {
        if (idx == n - 1) {
            String ch = "";
            for (int x = 0; x < n; x++) {
                ch += S[x];
            }
            ans.add(ch);
        }
        for (int i = 0; i < n; i++) {
            swap(idx, i, S, n);
            solve(S, idx + 1, n, ans);
            swap(idx, i, S, n);
        }
    }

    void swap(int i, int j, char[] S, int n) {
        if (i > n)
            return;
        char ch = S[j];
        System.out.println(i + "," + j);
        S[j] = S[i];
        S[i] = ch;
    }

    int min_sprinklers(int[] gallery, int n) {
        // code here
        ArrayList<Pair2> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (gallery[i] == -1)
                continue;
            int start = Math.max(0, i - gallery[i]);
            int end = Math.min(n - 1, i + gallery[i]);
            list.add(new Pair2(start, end));
        }
        Collections.sort(list, (a, b) -> a.start - b.start);
        int target = 0, i = 0, tap = 0;
        while (target < n) {
            int rightmax = -1;
            while (i < list.size()) {
                if (list.get(i).start <= target) {
                    rightmax = Math.max(rightmax, list.get(i).end);
                    i++;
                } else break;
            }
            if (rightmax < target)
                return -1;
            tap++;
            target = rightmax + 1;
        }
        return tap;
    }

    class Pair {
        int row;
        int col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    class Pair2 {
        int start;
        int end;

        Pair2(int s, int e) {
            start = s;
            end = e;
        }
    }


}
