package com.scaler.Scaler.Arrays;

public class TotalSubArraySum {
    public static void main(String[] args) {
        subarraySum(new int[]{2, 9, 5});
    }

    public static long subarraySum(int[] A) {
        long len = A.length;
        long total = 0;
        long contri = 0;
        for (int i = 0; i < len; i++) {
            // occurence pf element
            total = (i + 1) * (len - i);
            // total contro of that element
            contri += A[i] * total;
            // sum of all contro of all element
//                totalSum += contri;
        }
        return contri;
    }

    void printTotalSumAllSubArrayWithCarryForward(int[] A) {
        int n = A.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; i++) {
                sum += A[j];
                total += sum;
            }
        }
        System.out.println(total);
    }

    void printSumAllSubArrayWithCarryForward(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; i++) {
                sum += A[j];
                System.out.println(sum);
            }
        }
    }

    void printSumAllSubArrayWithCarryForwardFromIndx(int[] A, int idx) {
        int n = A.length;
        int sum = 0;
        for (int i = idx; i < n; i++) {
            sum += A[i];
            System.out.println(sum);
        }
    }

    void printSumAllSubArray(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; i++) {
                int sum = 0;
                for (int k = 0; k < j; k++) {
                    sum += A[k];
                }
                System.out.println(sum);
            }
        }
    }

    void printAllSubArray(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; i++) {
                for (int k = 0; k < j; k++) {
                    System.out.print(A[k] + " ");
                }
                System.out.println();
            }
        }
    }

}
