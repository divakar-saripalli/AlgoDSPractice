package com.div.missionfaang.algoexpert;

import java.util.Arrays;

public class SortKSortedArrays {

    // O(n2) solution if k = n
    public static int[] sortKSortedArray(int[] array, int k) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            int minNumber = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length && j <= j + k; j++) {
                if (array[j] < minNumber) {
                    minNumber = array[j];
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = minNumber;
            array[minIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortKSortedArray(new int[]{3, 2, 1, 5, 4, 7, 6, 5}, 3)));
    }
}
