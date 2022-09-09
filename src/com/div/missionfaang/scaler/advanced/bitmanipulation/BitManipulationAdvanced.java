package com.div.missionfaang.scaler.advanced.bitmanipulation;

import com.div.missionfaang.scaler.intermediate.bitmanipulation.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BitManipulationAdvanced {

    /**
     * Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
     * <p>
     * NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * Solution:
     * <p>
     * XORing each element would cancel out the repeated numbers because A^A == 0.
     *
     * @param A
     * @return
     */
    private static int singleNumber(List<Integer> A) {
        int number = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            number ^= A.get(i);
        }
        return number;
    }

    /**
     * Write a function that takes an integer and returns the number of 1 bits it has.
     *
     * @param A
     * @return
     */
    private static int numSetBits(int A) {
        int count = 0;
        while (A > 0) {
            count++;
            A = A & (A - 1);
        }
        return count;
    }

    private static String addBinary(String A, String B) {
        return BitManipulation.addBinaryStrings(A, B);
    }

    /**
     * Given an array of integers, every element appears thrice except for one, which occurs once.
     * Find that element that does not appear thrice.
     * NOTE: Your algorithm should have a linear runtime complexity.
     * Could you implement it without using extra memory?
     * <p>
     * Idea is to count the bits. If every number is repeated for 3 times, each set-bit of it would
     * also contribute for 3 times. Except for the bits of number which occurs only once.
     * So, if the count of bits at each place contributes to (3 * x) + 1, it should be set in the
     * unique number too. Otherwise, unique number did not contribute to that particular bit.
     * <p>
     * This approach works if the repeated value is odd. If the repeated value is even,
     * XORing each would nullify all the repeated numbers and the unique number remains.
     *
     * @param A
     * @return
     */
    private static int singleNumberII(List<Integer> A) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (Integer integer : A) {
                if ((integer & (1 << i)) > 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans += 1 << i;
            }
        }
        return ans;
    }

    /**
     * You have an array A with N elements. We have two types of operation available on this array :
     * We can split an element B into two elements, C and D, such that B = C + D.
     * We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
     * You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
     * <p>
     * <p>
     * Solution:
     * <p>
     * If any element in the array is even then, it can be made 0. Split that element into two equal parts of A[i]/2 and A[i]/2.
     * XOR of two identical numbers is zero. Therefore, this strategy makes an element 0.
     * If any element is odd. Split it in two-part: 1, A[i]-1. Since A[i]-1 is even, it can be made 0 by the above strategy.
     * Therefore, an odd element can reduce its size to 1.
     * Therefore, two odd elements can be made 0 by following the above strategy and finally XOR them (i.e., 1) as 1 XOR 1 = 0.
     * Therefore, if the number of odd elements in the array is even, the answer is possible.
     * Otherwise, an element of value 1 will be left, and it is impossible to satisfy the condition.
     *
     * @param A
     * @return
     */
    private static String interestingArray(ArrayList<Integer> A) {
        int count = A.size();
        for (Integer integer : A) {
            if ((integer & 1) == 0) {
                count--;
            }
        }
        return ((count & 1) == 0) ? "Yes" : "No";
    }

    /**
     * Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
     * <p>
     * Solution:
     * <p>
     * The minimum XOR would come only if the least significant bits were varying. This is because if there is only 1 bit varying between
     * two numbers and that is towards the left of bits (most significant bit), the value of XOR would be exponential.
     * Consider example
     * 0 ^ 8 ==> 0000 ^ 1000 ==> 1000 ==> 8 since the most significant bit is varying.
     * 4 ^ 5 ==> 0100 ^ 0101 ==> 0001 ==> 1 since the least significant bit is varying.
     * <p>
     * The lease significant bits will be varying only among the closest numbers.
     * <p>
     * Hence, Sorting the array would place the closest number together, and we can find the value in O(N).
     *
     * @param A
     * @return
     */
    private static int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            min = Math.min(min, (A.get(i) ^ A.get(i + 1)));
        }
        return min;
    }

    private static int smallestXOR(int A, int B) {
        int i = 30;
        int j = 0;
        int result = 0;
        while (i > -1 && j < B) {
            int mask = (1 << i);
            if ((A & mask) > 0) {
                result += mask;
                j++;
            }
            i--;
        }
        return result;
    }

    /**
     * We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
     * For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.
     * <p>
     * You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
     *
     * @param A
     * @return
     */
    private static int cntBits(ArrayList<Integer> A) {
        long sum = 0;
        for (int i = 0; i < 32; i++) {
            int countOf1s = 0;
            for (int j = 0; j < A.size(); j++) {
                if ((A.get(j) & 1) != 0) {
                    countOf1s++;
                }
                A.set(j, (A.get(j) >> 1));
            }
            sum = (sum + (2L * (A.size() - countOf1s) * countOf1s) % 1000000007) % 1000000007;
        }
        return (int) (sum % 1000000007);

        /*
         Approach : Calculate XOR for each pair and count the set bits.
         int sum = 0;
         for(int i = 0; i < A.size(); i++){
             for(int j = i + 1; j < A.size(); j++){
                 int xor = A.get(i) ^ A.get(j);
                 while(xor > 0){
                     sum++;
                     xor = xor & (xor - 1);
                 }
             }
         }
         return sum*2;
        */
    }

    public static void main(String[] args) {
        System.out.println(BitManipulationAdvanced.smallestXOR(4, 6));
    }
}
