package com.div.missionfaang.scaler.intermediate.subsequence;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.Collections;

public class SubsequenceProblems {

    public String littlePonnyAnd2Subsequences(String A) {
        int firstMin = 0;
        char minChar = 'z';
        for (int i = 0; i < A.length() - 1; i++) {
            if (A.charAt(i) < minChar) {
                firstMin = i;
                minChar = A.charAt(i);
            }
        }
        int secondMin = firstMin;
        minChar = 'z';
        for (int i = firstMin + 1; i < A.length(); i++) {
            if (A.charAt(i) < minChar) {
                secondMin = i;
                minChar = A.charAt(i);
            }
        }
        return "" + A.charAt(firstMin) + A.charAt(secondMin);
    }

    public int specialSubsequenceAG(String A) {
        ArrayList<Integer> aIndices = new ArrayList<>();
        ArrayList<Integer> gIndices = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'A') {
                aIndices.add(i);
            } else if (A.charAt(i) == 'G') {
                gIndices.add(i);
            }
        }
        if (gIndices.size() == 0 || aIndices.size() == 0) {
            return 0;
        }
        int gIndicesPointer = 0;
        int subsequenceCount = 0;
        for (Integer aIndex : aIndices) {
            if ((gIndicesPointer < gIndices.size()) && (gIndices.get(gIndicesPointer) < aIndex)) {
                while ((gIndicesPointer < gIndices.size()) && (gIndices.get(gIndicesPointer) < aIndex)) {
                    gIndicesPointer++;
                }
            }
            subsequenceCount += gIndices.size() - gIndicesPointer;
            subsequenceCount %= 1000000007;
        }
        return subsequenceCount;
    }

    public int maxOddEvenSubsequence(ArrayList<Integer> A) {
        int count = 1;
        boolean checkForOdd = (A.get(0) % 2 == 0);
        for (int i = 0; i < A.size(); i++) {
            if (checkForOdd && A.get(i) % 2 != 0) {
                count++;
                checkForOdd = false;
            } else if (!checkForOdd && A.get(i) % 2 == 0) {
                count++;
                checkForOdd = true;
            }
        }
        return count;
    }

    public String findSubSequence(String A, String B) {
        if (A.length() > B.length()) {
            return "NO";
        }
        int i = 0;
        int j = 0;
        while (i < A.length() && j < B.length()) {
            while (j < B.length() && B.charAt(j) != A.charAt(i)) {
                j++;
            }
            i++;
            j++;
        }
        return (i == A.length()) ? "YES" : "NO";
    }

    /**
     * Idea is to consider the bits of each integer which could contribute in the ORing.
     * Count all the consequent 0's and exclude the possible number of sub-arrays.
     * With the remaining sub-arrays, multiply it with the 2^i.
     * <p>
     * For e.g. consider integers 7,2,5,9,1,8
     * 7 ==> 0111
     * 2 ==> 0010
     * 5 ==> 0101
     * 9 ==> 1001
     * 1 ==> 0001
     * 8 ==> 1000
     * <p>
     * If we consider right-most bit, integers 2 & 8 have 0's. So the possible sub-arrays they
     * both together affect are 2. Now add (21 - 2) * (2 ^ 0) = 19 to the sum.
     * In the next right bit, we have 5, 9, 1, 8 with 0's. They contribute to 10 sub-arrays.
     * So add (21 - 10) * (2 ^ 1) = 22 to the total sum.
     * Similar way, for 3rd bit (2nd from left) (21 - 7) * (2 ^ 2) = 56 and for 4th bit also
     * (21 - 7) * (2 ^ 3) = 112
     * Total = 112 + 56 + 22 + 19 = 209
     *
     * @param A List of integers
     * @return int Total sum of ORed value of all possible sub arrays.
     */
    private static int subarrayOr(ArrayList<Integer> A) {
        long sum = 0;
        for (int i = 0; i < 32; i++) {
            long total = (((long) A.size() * (A.size() + 1)) / 2);
            int count = 0;
            for (Integer integer : A) {
                if ((integer & (1 << i)) == 0) {
                    count++;
                } else {
                    total -= ((long) count * (count + 1)) / 2;
                    count = 0;
                }
            }
            total -= ((long) count * (count + 1)) / 2;
            sum += total * (1 << i);
        }
        return (int) (sum);
    }

    private static int sumTheDifference(ArrayList<Integer> A) {
        if (A.size() == 1) {
            return A.get(0);
        }
        Collections.sort(A);
        int sum = 0;
        for (Integer integer : A) {
            sum += integer;
        }
        sum += A.get(A.size() - 1) - A.get(0);
        for (int i = 0; i < A.size(); i++) {
            int diff = A.get(A.size() - 1) - A.get(i);
            for (int j = A.size() - 2; j > i; j--) {
                diff += A.get(j) - A.get(j + 1);
            }
            sum += diff;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{7, 8, 6, 4, 6};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
//        System.out.println(SubsequenceProblems.sumTheDifference(array));
        System.out.println(SubsequenceProblems.sumTheDifference(array));
    }
}
