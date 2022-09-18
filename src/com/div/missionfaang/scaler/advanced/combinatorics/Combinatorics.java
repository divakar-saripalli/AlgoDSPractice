package com.div.missionfaang.scaler.advanced.combinatorics;

public class Combinatorics {

    private static int findRank(String A) {
        int sum = 0;
        int mod = 1000003;
        for (int i = 0; i < A.length() - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < A.length(); j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    count++;
                }
            }
            int factorial = 1;
            for (int k = 1; k <= A.length() - i - 1; k++) {
                factorial = ((factorial % mod) * (k % mod)) % mod;
            }
            sum = ((sum % mod) + ((((count % mod) * (factorial % mod)) % mod) % mod)) % mod;
        }
        return (sum + 1) % mod;
    }

    private int computeNcRModuloMatrix(int A, int B, int C) {
        if (A == B || B == 0) {
            return 1;
        }
        if (B == 1) {
            return A;
        }
        return ((computeNcRModuloMatrix(A - 1, B, C) % C) + computeNcRModuloMatrix(A - 1, B - 1, C) % C) % C;
    }

    public static void main(String[] args) {
        System.out.println(Combinatorics.findRank("ZCSFLVHXRYJQKWABGT"));
    }
}
