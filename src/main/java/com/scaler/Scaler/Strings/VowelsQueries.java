package com.scaler.Scaler.Strings;

public class VowelsQueries {
    public static void main(String[] args) {
            int[][] queries = new int[][]{{0, 4}, {2, 5}};
        optimized("aebcouir",queries);
    }

    static int[] getVowelsQueries(int[][] Queries,String A){
        int len = A.length();
        int[] prefix = new int[len];
        if(A.charAt(0) == 'a' || A.charAt(0) == 'e' || A.charAt(0) == 'i' || A.charAt(0) == 'o'|| A.charAt(0) == 'u')
            prefix[0] = 1;
        for(int i = 1; i < len; i++){
            if(A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o'|| A.charAt(i) == 'u'){
                prefix[i] = prefix[i-1] + 1;
            }else prefix[i] = prefix[i-1];
        }
        int[] ans = new int[Queries.length];
        for (int i = 0; i <Queries.length;i++){
            int l = Queries[i][0] , r = Queries[i][1];
            if(l == 0)
                ans[i] = prefix[r];
            else ans[i] = prefix[r] - prefix[l-1];
        }
        return ans;
    }

    static int[] optimized(String A, int[][] B) {
        int len = B.length, strlen = A.length();
        int[] prefixarr = new int[strlen + 1];
        int[] ans = new int[len];
        for (int i = 0; i < strlen; i++) {
            if (A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o'
                    || A.charAt(i) == 'u'
            ) {
                prefixarr[i + 1] = prefixarr[i] + 1;
            } else prefixarr[i + 1] = prefixarr[i];
        }
        for (int i = 0; i < len; i++) {
            int l = B[i][0], r = B[i][1];
            ans[i] = prefixarr[r + 1] - prefixarr[l];
        }
        return ans;
    }
}
