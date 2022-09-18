package com.div.missionfaang.scaler.advanced.recursion;

import java.util.ArrayList;

public class AdvRecursion2 {

    private static int kthSymbol(int A, int B) {
        if (A == 1 || B == 0) {
            return 0;
        }
        int value = AdvRecursion2.kthSymbol(A - 1, B / 2);
        if (B % 2 != 0) {
            return value;
        } else {
            return 1 - value;
        }
    }

    private static ArrayList<Integer> grayCode(int a) {
        if (a == 1) {
            ArrayList<Integer> start = new ArrayList<>();
            start.add(0);
            start.add(1);
            return start;
        }
        ArrayList<Integer> result = AdvRecursion2.grayCode(a - 1);
        for (int i = result.size() - 1; i > -1; i--) {
            result.add(result.get(i) + (1 << (a - 1)));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(AdvRecursion2.kthSymbol(2, 2));
    }
}
