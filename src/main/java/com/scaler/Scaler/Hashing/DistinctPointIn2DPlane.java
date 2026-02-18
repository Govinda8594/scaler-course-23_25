package com.scaler.Scaler.Hashing;

import java.util.HashSet;

public class DistinctPointIn2DPlane {

    static String[] getDistinct(int[] x, int[] y) {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < x.length; i++) {
            set.add(x[i] + "@" + y[i]);
        }
        return set.toArray(new String[0]);
    }
}
