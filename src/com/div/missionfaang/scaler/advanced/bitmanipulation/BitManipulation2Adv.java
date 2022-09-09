package com.div.missionfaang.scaler.advanced.bitmanipulation;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

public class BitManipulation2Adv {

    /**
     * Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.
     *
     * @param A
     * @param B
     * @return
     */
    private static int smallestXOR(int A, int B) {
        int i = 31;
        int j = 0;
        int result = 0;
        int firstI = -1;
        while (i > -1 && j < B) {
            int mask = (1 << i);
            if ((A & mask) >= 1) {
                result += mask;
                j++;
                if (firstI == -1) {
                    firstI = i;
                }
            }
            i--;
        }
        i = 0;
        while (j < B && i < firstI) {
            int mask = (1 << i);
            if ((A & mask) == 0) {
                result += mask;
                j++;
            }
            i++;
        }
        while (j < B) {
            result = result << 1;
            result = result | 1;
            j++;
        }
        return result;
    }

    /**
     * Given an integer A.
     * Two numbers, X and Y, are defined as follows:
     * <p>
     * X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
     * Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
     * Find and return the XOR of X and Y.
     * <p>
     * NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
     * <p>
     * NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
     *
     * @param A
     * @return
     */
    private static int strangeEquality(int A) {
        int greatestSmall = 0;
        int i = 0;
        for (; i < 32 && A > 0; i++) {
            if ((A & 1) == 0) {
                greatestSmall += (1 << i);
            }
            A = A >> 1;
        }
        int smallestBig = (1 << i);
        return greatestSmall ^ smallestBig;
    }

    /**
     * Divide two integers without using multiplication, division and mod operator.
     * Return the floor of the result of the division.
     * Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
     * NOTE: INT_MAX = 2^31 - 1
     * <p>
     * Problem Constraints
     * -231 <= a, b <= 231-1
     * b != 0
     *
     * @param A
     * @param B
     * @return
     */
    private static int divide(int A, int B) {
        boolean positive = A >= 0;
        if (B < 0) {
            positive = !positive;
        }
        long a = A;
        long b = B;
        if (a < 0) {
            if (a == Integer.MIN_VALUE) {
                a = Integer.MAX_VALUE;
            } else {
                a = a * -1;
            }
        }
        if (b < 0) {
            b = b * -1;
        }
        long dividend = 0;
        for (int i = 31; i >= 0; i--) {
            if ((b << i) <= a) {
                dividend += (1L << i);
                a -= (b << i);
            }
        }
        if (dividend >= Integer.MAX_VALUE) {
            if (positive) {
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;
        }
        if (positive) {
            return (int) dividend;
        }
        return (int) (dividend * -1);
//        while (b != 1 && b != Integer.MAX_VALUE && b != 0) {
//            if ((a & 1) != 0) {
//                a++;
//            }
//            if ((b & 1) != 0) {
//                b++;
//            }
//            a = a >> 1;
//            b = b >> 1;
//        }
    }

    /**
     * Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
     * <p>
     * Return the count modulo 109 + 7.
     *
     * @param A
     * @return
     */
    private static int countTotalSetBits(int A) {
        long sum = 0;
        int mod = 1000000007;
        while (A > 0) {
            int temp = A;
            int count = 0;
            // Find the maximum 2 power value which is less than A.
            while (temp > 1) {
                count++;
                temp = temp >> 1;
            }
            // Compute the 1's till the above calculated 2 power, as it can be done recursively.
            sum = ((sum % mod) + (BitManipulation2Adv.countTotalSetBitsFrom2Power(1 << count) + 1) % mod) % mod;
            // Subtract the above calculated 2 power from A.
            A -= (1 << count);
            // Add the remaining value A to the total sum because the left most significant bit will be discarded in
            // further calculations.
            sum = ((sum % mod) + (A % mod));
        }
        return (int) (sum % mod);
    }

    private static int countTotalSetBitsFrom2Power(int A) {
        int mod = 1000000007;
        if (A == 0) {
            return 0;
        }
        return (((A >> 1) % mod) + ((BitManipulation2Adv.countTotalSetBitsFrom2Power(A >> 1) * 2) % mod)) % mod;
    }

    /**
     * Reverse the bits of an 32 bit unsigned integer A.
     *
     * @param a
     * @return
     */
    private static long reverse(long a) {
        long result = 0;
        boolean add1 = ((a & 1) == 1);
        for (int i = 0, j = 31; i < 32; i++, j--) {
            if ((a & 1) != 0) {
                if (i == 0) {
                    result += (1L << j) - 1;
                } else {
                    result += 1L << j;
                }
            }
            a = a >> 1;
        }
        return (add1) ? result + 1 : result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{7, 11, 13, 27, 45};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
        System.out.println(BitManipulation2Adv.divide(Integer.MIN_VALUE, 1));
    }
}
