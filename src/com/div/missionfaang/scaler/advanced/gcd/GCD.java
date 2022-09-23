package com.div.missionfaang.scaler.advanced.gcd;

/**
 * Important GCD formulae:
 * <p>
 * gcd(a. b) == gcd(a, b-a)
 * <p>
 * gcd(a, b) == gcd(a, b%a)
 * <p>
 * lcm(a, b) == (a*b)/gcd(a,b)
 */
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
        int divisor = 0;
        if (B % C == 0) {
            divisor = C;
        } else if (C % B == 0) {
            divisor = B;
        } else {
            divisor = GCD.gcd(B, C);
            divisor *= (B / divisor) * (C / divisor);
        }
        if (A > divisor) {
            A -= (A % divisor);
            count = A / divisor;
        }
        return count;
    }

    private static int gcd(int A, int B) {
        if (A == B) {
            return A;
        }

        if (A == 0) {
            return B;
        }

        if (B == 0) {
            return A;
        }

        if (A == 1 || B == 1) {
            return 1;
        }

        if (B < A) {
            int temp = A;
            A = B;
            B = temp;
        }
        return GCD.gcd(A, B % A);
    }

    public static void main(String[] args) {
        System.out.println(GCD.divisorGame(411753753, 1876, 7430));
    }
}
