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
      if( gIndices.isEmpty() || aIndices.isEmpty() )
      {
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

    public int maxOddEvenSubsequence( ArrayList<Integer> A )
    {
        int count = 1;
        boolean checkForOdd = (A.get( 0 ) % 2 == 0);
        for( Integer integer_ : A )
        {
            if( checkForOdd && integer_ % 2 != 0 )
            {
                count++;
                checkForOdd = false;
            }
            else if( !checkForOdd && integer_ % 2 == 0 )
            {
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

    /**
     * Given an integer array, A of size N.
     * You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence,
     * find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.
     * <p>
     * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
     * <p>
     * NOTE: Subsequence can be non-contiguous.
     * <p>
     * Approach:
     * <p>
     * Consider an array [3, 8, 2, 7, 5]
     * The possible number of subsequences would be 2^n ==> 2^5 in this case. They are
     * [ [], [2], [2, 3], [2, 3, 5], [2, 3, 5, 7], [2, 3, 5, 7, 8], [2, 3, 5, 8], [2, 3, 7],
     * [2, 3, 7, 8], [2, 3, 8], [2, 5], [2, 5, 7], [2, 5, 7, 8], [2, 5, 8], [2, 7], [2, 7, 8],
     * [2, 8], [3], [3, 5], [3, 5, 7], [3, 5, 7, 8], [3, 5, 8], [3, 7], [3, 7, 8], [3, 8], [5],
     * [5, 7], [5, 7, 8], [5, 8], [7], [7, 8], [8] ]
     * <p>
     * Weather we consider subsequences [3, 8] or [3, 8, 7, 5], the highest and least would
     * remain 8 and 3 respectively.
     * <p>
     * Given that sorting the array will not make any difference in finding the difference between
     * highest and least, because the all the subsequences would contain all the elements.
     * <p>
     * After sorting the array, the array would look like [2, 3, 5, 7, 8]
     * <p>
     * Now consider the sub-array [2, 3, 5, 7], we can have 2^2 subsequences with 2 as least and 7 as highest. They are
     * [2, 7], [2, 3, 7], [2, 5, 7], [2, 3, 5, 7].
     * <p>
     * To generalize it, 2^(j - i - 1) subsequences.
     * <p>
     * So the contribution of (7 - 2) would be 2^(3 - 0 - 1) * (7 - 2) ==> 2^2 * 5
     * <p>
     * Now to find the contribution of all the possible difference between max and min of all subsequences,
     * consider a sorted array [a, b, c, d].
     * <p>
     * 2^2(d - a) + 2^1(d - b) + 2^0(d - c) + 2^1(c - a) + 2^0(b - a) + 2^0(c - b). 
     * <p>
     * This becomes 2^2(d - a) + 2^1(d - b + c - a) + 2^0(d - c + b - a + c - b).
     * <p>
     * This becomes 2^2(d - a) + 2^1(d - b + c - a) + 2^0(d - a). 
     * <p>
     * This becomes d(2^2 + 2^1 + 2^0) + c(2^1) - b(2^1) - a(2^2 + 2^1 + 2^0).
     * <p>
     * This can be written as d(2^3 - 1) + 2c(2^1 - 1) - 2b(2^1 - 1) - a(2^3 - 1).
     * <p>
     * This becomes (2^3*d + 2^2*c + 2^1*b + 2^0*a) - (2^3*a + 2^2*b + 2^1*c + 2^0*d)
     *
     * @param A
     * @return
     */
    private static int sumTheDifference(ArrayList<Integer> A) {
        if (A.size() == 1) {
            return A.get(0);
        }
        Collections.sort(A);
        int maxSum = 0;
        int minSum = 0;
        int mod = 1000000007;
        // The loop multiplies the sum every time.
        // Consider an array [a, b, c]
        // The required equation is 2^2a + 2b+ c
        // First iteration ==> ((0x2) + a) % mod.
        // Since mod is very large, lets not consider it. 
        // 1st iteration ==> a
        // 2nd iteration ==> (2xa) + b ==> 2a + b
        // 3rd iteration ==> 2x(2a + b) + c ==> 2^2a + 2b + c
        for (Integer integer : A) {
            minSum = minSum * 2;
            minSum = (minSum + integer) % mod;
        }

        // Same loop as above one.
        for (int j = A.size() - 1; j > -1; j--) {
            maxSum = maxSum * 2;
            maxSum = (maxSum + A.get(j)) % mod;
        }
        return (maxSum - minSum + mod) % mod;
    }

    /**
     * Given a set of distinct integers A, return all possible subsets.
     * <p>
     * NOTE:
     * <p>
     * Elements in a subset must be in non-descending order.
     * The solution set must not contain duplicate subsets.
     * Also, the subsets should be sorted in ascending ( lexicographic ) order.
     * The list is not necessarily sorted.
     * <p>
     * Input : A = [1, 2, 3]
     * <p>
     * Output :
     * <p>
     * [
     * []
     * [1]
     * [1, 2]
     * [1, 2, 3]
     * [1, 3]
     * [2]
     * [2, 3]
     * [3]
     * ]
     * <p>
     *
     *
     * @param A
     * @return
     */
    private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        ArrayList<Integer> currentList = new ArrayList<>();
        SubsequenceProblems.subsets(A, result, currentList, 0);
        result.add(0, currentList);
        return result;
    }

    private static int subSequenceSumProblem(ArrayList<Integer> A, int B) {
        return (SubsequenceProblems.subSequenceSum(A, B, 0, 0) == B) ? 1 : 0;
    }

    private static int subSequenceSum(ArrayList<Integer> A, int B, int currentIndex, int currentSum) {
        if (currentIndex < A.size()) {
            int value = SubsequenceProblems.subSequenceSum(A, B, currentIndex + 1, currentSum);
            if (value == B) {
                return value;
            }
            currentSum += A.get(currentIndex);

            value = SubsequenceProblems.subSequenceSum(A, B, currentIndex + 1, currentSum);
            if (value == B) {
                return value;
            }
        }
        return currentSum;
    }

    private static void subsets(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentList, int currentIndex) {
        if (currentIndex < A.size()) {
            currentList = new ArrayList<>(currentList);
            SubsequenceProblems.subsets(A, result, currentList, currentIndex + 1);
            currentList.add(A.get(currentIndex));
            SubsequenceProblems.subsets(A, result, currentList, currentIndex + 1);
            result.add(0, currentList);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 8, 2, 7, 5};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
//        System.out.println(SubsequenceProblems.sumTheDifference(array));
        System.out.println(SubsequenceProblems.subsets(array));
    }
}
