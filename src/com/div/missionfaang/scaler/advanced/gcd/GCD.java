package com.div.missionfaang.scaler.advanced.gcd;

public class GCD {

    /**
     * Scooby has 3 three integers A, B, and C.
     * <p>
     * Scooby calls a positive integer special if it is divisible by B, and it is divisible by C.
     * You need to tell the number of special integers less than or equal to A.
     *
     * @param A
     * @param B
     * @param C
     * @return
     */
    private static int divisorGame(int A, int B, int C) {
        int count = 0;
        long divisor;
        if (B % C == 0) {
            divisor = B;
        } else if (C % B == 0) {
            divisor = C;
        } else {
            divisor = ((long) B * C);
        }
        if (A > divisor) {
            A -= (A % divisor);
            count = (int) (A / divisor);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(GCD.divisorGame(411753753, 1876, 7430));
    }
}
