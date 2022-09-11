package com.div.missionfaang.scaler.advanced.modulararithmetic;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

public class ModularArithmeticAdvanced {

    /**
     * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
     * Example:
     * Input : [1, 0]
     * Return : [0, 1]
     * Lets say N = size of the array. Then, following holds true :
     * All elements in the array are in the range [0, N-1]
     * N * N does not overflow for a signed integer
     * <p>
     * For the given array {2, 3, 1, 0} should transform to {1, 0, 3, 2}.
     *
     * @param a
     * @return
     */
    private static ArrayList<Integer> arrange(ArrayList<Integer> a) {
        a.replaceAll(integer -> integer * a.size());
        a.replaceAll(integer -> integer + a.get(integer / a.size()) / a.size());
        a.replaceAll(integer -> integer % a.size());

        return a;
    }

    /**
     * Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
     * <p>
     * Approach : A % M = B % M ==> A % M - B % M = 0 ==> (A - B) % M = 0.
     * (A - B) % M = 0 ==> (A-B) is a factor of M.
     *
     * @param A
     * @param B
     * @return
     */
    private static int abAndModulo(int A, int B) {
        return (Math.abs(A - B));
    }

    private static int pow(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }

        if (B == 0) {
            return 1;
        }

        if (C == 1) {
            return 0;
        }
        if (B == 1) {
            if (A < 0) {
                return (A + C) % C;
            }
            return A;
        }
        long value = (long) (ModularArithmeticAdvanced.pow(A, B / 2, C) % C) * (ModularArithmeticAdvanced.pow(A, B / 2, C) % C) % C;
        if ((B & 1) != 0) {
            value = ((value % C) * (A % C)) % C;
        }
        if (value < 0) {
            value = value + C;
        }
        value = value % C;
        return (int) value;
    }

    /**
     * Problem Description
     * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
     * <p>
     * Since the answer may be large, return the answer modulo (109 + 7).
     *
     * @param A
     * @param B
     * @return
     */
    private static int pairSumDivisibleByM(ArrayList<Integer> A, int B) {
        ArrayList<Integer> freqHM = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            freqHM.add(0);
        }
        for (Integer integer : A) {
            freqHM.set((integer % B), freqHM.get(integer % B) + 1);
        }
        int mod = 1000000007;
        long ans = (((long) freqHM.get(0) * (freqHM.get(0) - 1)) / 2) % mod;
        int i = 1;
        int j = B - 1;
        for (; i < j; i++, j--) {
            ans = (ans + (((long) freqHM.get(i) * freqHM.get(j)) % mod)) % mod;
        }
        if (i == j) {
            ans = (ans + ((((long) freqHM.get(i) * (freqHM.get(i) - 1)) / 2) % mod)) % mod;
        }
        return (int) (ans % mod);
    }

    private static int primeModuloInverse(int A, int B) {
        if (B == 1) {
            return A;
        }
        return ModularArithmeticAdvanced.pow(A, B - 2, B);
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 0};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
        System.out.println(ModularArithmeticAdvanced.arrange(array));
    }
}
