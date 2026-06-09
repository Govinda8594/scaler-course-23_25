package com.scaler.Scaler.MathDSA.Modulo;

public class DivideNumberInto2PartWhichIsDivisibleByAandB {
    static String stringPartition(String S, int a, int b) {
        // code here
        int[] prefix = new int[S.length()];
        int[] suffix = new int[S.length()];
        prefix[0] = S.charAt(0) - '0';
        suffix[S.length() - 1] = S.charAt(S.length() - 1) - '0';
        for (int i = 1; i < S.length(); i++) {
            prefix[i] = (prefix[i - 1] * 10 + S.charAt(i) - '0') % a;
        }
        int pow = 10;
        for (int i = S.length() - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] + (S.charAt(i) - '0') * pow) % b;
            pow = (pow * 10) % b;
        }
        for (int i = 0; i < S.length() - 1; i++) {
            if ((suffix[i + 1] == 0) && (prefix[i] == 0)) {
                return S.substring(0, i + 1).concat(" ").concat(S.substring(i + 1));
            }
        }
        return "-1";
    }

}
