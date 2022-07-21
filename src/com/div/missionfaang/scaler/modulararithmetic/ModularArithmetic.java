package com.div.missionfaang.scaler.modulararithmetic;

public class ModularArithmetic {

    private static int divisibilityBy8(String A) {
        int result = 1;
        if (A.isEmpty() || A.isBlank()) {
            result = 0;
        } else if (A.length() < 2 && (Integer.parseInt(A) != 8 && Integer.parseInt(A) != 0)) {
            result = 0;
        } else if (A.length() > 1) {
            if (Integer.parseInt("" + A.charAt(A.length() - 1)) % 2 != 0) {
                result = 0;
            } else {
                int digitsToConsider;
                if (A.length() < 3) {
                    digitsToConsider = Integer.parseInt(A);
                } else {
                    digitsToConsider = Integer.parseInt(A.substring(A.length() - 3));
                }
                if (digitsToConsider % 4 != 0 || (digitsToConsider / 4) % 2 != 0) {
                    result = 0;
                }
            }
        }
        return result;
    }

    private static int concatenateThreeNumbers(int A, int B, int C) {
        int result;
        if (A <= B) {
            result = ModularArithmetic.ifALessThanBAndC(A, B, C);
        } else {
            result = ModularArithmetic.ifALessThanBAndC(B, A, C);
        }
        return result;
    }

    private static int ifALessThanBAndC(int A, int B, int C) {
        int result;
        if (A <= C) {
            result = A;
            result *= 100;
            if (B <= C) {
                result += B;
                result *= 100;
                result += C;
            } else {
                result += C;
                result *= 100;
                result += B;
            }
        } else {
            result = C;
            result *= 100;
            result += A;
            result *= 100;
            result += B;
        }
        return result;
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
//        System.out.println(ModularArithmetic.divisibilityBy8("0"));
        System.out.println(ModularArithmetic.concatenateThreeNumbers(74, 86, 54));
    }
}