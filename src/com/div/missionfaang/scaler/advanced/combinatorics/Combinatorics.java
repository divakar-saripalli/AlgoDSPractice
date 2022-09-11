package com.div.missionfaang.scaler.advanced.combinatorics;

public class Combinatorics {

    public static void main(String[] args) {

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
}
