package com.div.missionfaang.scaler.advanced.sorting;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.Collections;

public class AdvSorting3 {

    /**
     * Given an array A of non-negative integers of size N.
     * Find the minimum sub-array Al, Al+1 ,..., Ar such that
     * if we sort(in ascending order) that sub-array,
     * then the whole array should get sorted.
     * If A is already sorted, output -1.
     * <p>
     * Approach: Find the max index where the value is lesser than numbers to its left.
     * Similarly, find the min index where the value is greater than numbers to its right.
     *
     * @param A
     * @return
     */
    private static ArrayList<Integer> maxUnsortedSubarray(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int lastMax = Integer.MIN_VALUE;
        for (int i = 1; i < A.size(); i++) {
            if ((A.get(i - 1) > A.get(i)) || lastMax > A.get(i)) {
                max = i;
                lastMax = Math.max(lastMax, A.get(i - 1));
            }
        }

        int min = Integer.MAX_VALUE;
        int lastMin = Integer.MAX_VALUE;
        for (int i = A.size() - 2; i > -1; i--) {
            if ((A.get(i + 1) < A.get(i)) || lastMin < A.get(i)) {
                min = i;
                lastMin = Math.min(lastMin, A.get(i + 1));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
            result.add(min);
            result.add(max);
        } else {
            result.add(-1);
        }
        return result;
    }

    /**
     * Given an array of integers A of size N where N is even.
     * <p>
     * Divide the array into two subsets such that
     * <p>
     * 1.Length of both subset is equal.
     * 2.Each element of A occurs in exactly one of these subset.
     * Magic number = sum of absolute difference of corresponding elements of subset.
     * <p>
     * Note: You can reorder the position of elements within the subset to find the value of the magic number.
     * <p>
     * For Ex:-
     *  <p>
     * subset 1 = {1, 5, 1},
     *  <p>
     * subset 2 = {1, 7, 11}
     *  <p>
     * Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
     *  <p>
     * Return an array B of size 2, where
     *  <p>
     * B[0] = maximum possible value of Magic number modulo 109 + 7,
     *  <p>
     * B[1] = minimum possible value of a Magic number modulo 109 + 7.
     * <p>
     * Approach: 
     * <p>
     * Step 1: Sort the array.
     * <p>
     * Step 2: Minimum possible magic number. 
     *  <p>
     *          This could be calculated by considering the adjacent numbers in the sorted array
     * <p>
     *          as they would be having the least difference. This implies that every alternate
     * <p>
     *          elements in the array form a subset.
     * <p>
     * Step 3: Maximum possible magic number.
     *  <p>
     *          This could be calculated by the difference of rightmost and leftmost cells of array
     * <p>
     *          and converging to the middle. This implies that the array is divided exactly half
     * <p>
     *          but one of the subarray is reversed and summation is performed.
     *
     * @param A
     * @return
     */
    private static ArrayList<Integer> maxAndMinMagic(ArrayList<Integer> A) {
        Collections.sort(A);
        int minSum = 0;
        int mod = 1000000007;
        for (int i = 0; i < A.size() - 1; i += 2) {
            minSum = ((minSum % mod) + (Math.abs(A.get(i + 1) - A.get(i)) % mod)) % mod;
        }
        int maxSum = 0;
        for (int i = A.size() - 1, j = 0; i > j; i--, j++) {
            maxSum = ((maxSum % mod) + (Math.abs(A.get(i) - A.get(j)) % mod)) % mod;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(maxSum);
        result.add(minSum);
        return result;
    }

    public static void main(String[] args) {
//        int[] arr1 = new int[]{3, 3, 4, 5, 5, 9, 11, 13, 14, 15, 15, 16, 15, 20, 16};
//        int[] arr1 = new int[]{1, 1};
//        int[] arr1 = new int[]{1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19};
        int[] arr1 = new int[]{-98, 54, -52, 15, 23, -97, 12, -64, 52, 85};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
        System.out.println(AdvSorting3.maxAndMinMagic(array));
    }

    public ArrayList<Integer> quickSort(ArrayList<Integer> A) {
        return null;
    }

    public ArrayList<Integer> quickSort(ArrayList<Integer> A, int start, int end) {
        return null;
    }

    public ArrayList<Integer> rearrange(ArrayList<Integer> A, int start, int end) {
        int tempStart = start;
        int tempEnd = end;
        int pivot = (end - start) / 2;
        while (start < end) {
            if (A.get(start) < A.get(pivot)) {
                start++;
            }
            if (A.get(end) > A.get(pivot)) {
                end--;
            }

            if (tempStart == start && tempEnd == end) {
                A.set(tempStart, A.get(end));
                A.set(tempEnd, A.get(start));
            }
            tempStart = start;
            tempEnd = end;
        }
        return A;
    }
}
