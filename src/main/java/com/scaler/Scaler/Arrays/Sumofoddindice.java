package com.scaler.Scaler.Arrays;

public class Sumofoddindice {
	public static void main(String[] args) {
//		oddPFArray()
	}
    public static int[] oddPFArray(int[] A, int[][] B) {
     int len = A.length;
		int Blen = B.length;
		int[] oddPrefixArray = new int[len];
		int[] ans = new int[Blen];
		oddPrefixArray[0] = 0;
		for (int i = 1; i < len; i++) {
			if (i % 2 != 0) {
				oddPrefixArray[i] = oddPrefixArray[i - 1] + A[i];
				
			} else oddPrefixArray[i] = oddPrefixArray[i - 1];
				
		}
		for (int i = 0; i < Blen; i++) {
			int l = B[i][0];
			int r = B[i][1];
			if (l == 0)
				ans[i] = oddPrefixArray[r];
			else ans[i] = oddPrefixArray[r] - oddPrefixArray[l-1];

		}
		return ans;
	}
}
