package com.div.missionfaang.scaler.modulararithmetic;

public class ModularArithmetic {
    private static int divisibilityBy8(String A) {
        if (A.isEmpty() || A.isBlank()) {
            return 0;
        }
        if (A.length() < 2 && (Integer.parseInt(A) != 8 && Integer.parseInt(A) != 0)) {
            return 0;
        }

        if (A.length() > 1) {
            if (Integer.parseInt("" + A.charAt(A.length() - 1)) % 2 != 0) {
                return 0;
            }
            int lastTwoDigits = Integer.parseInt(A.substring(A.length() - 2));
            if (lastTwoDigits % 4 != 0 || (lastTwoDigits / 4) % 2 != 0) {
                return 0;
            }
        }
        return 1;
    }

    private static int abAndModulo(int A, int B) {
        int start = Math.max(A, B);
        while (start > 1) {
            if (A % start == B % start) {
                return start;
            }
            start--;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(ModularArithmetic.divisibilityBy8("0"));
    }
}