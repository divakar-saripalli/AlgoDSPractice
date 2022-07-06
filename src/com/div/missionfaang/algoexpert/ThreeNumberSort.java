package com.div.missionfaang.algoexpert;

import java.util.Arrays;

public class ThreeNumberSort {

    public static int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        int k = 0;
        int j = 0;
        for (int i = 0; i < 3; i++) {
            j = k;
            for (; j < array.length; ) {
                if (array[k] == order[i]) {
                    k++;
                    j++;
                } else {
                    while (j < array.length && array[j] != order[i]) {
                        j++;
                    }
                    if (j < array.length) {
                        array[j] = array[k];
                        array[k] = order[i];
                        k++;
                        System.out.println(Arrays.toString(array));
                    }
                }
                System.out.println("i :: " + i + " j :: " + j + " k :: " + k);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        threeNumberSort(new int[]{1, 0, 0, -1, -1, 0, 1, 1}, new int[]{0, 1, -1});
    }

}
