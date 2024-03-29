package com.div.missionfaang.algoexpert;

import java.util.Arrays;

public class QuickSelect {

    public static int quickselect(int[] array, int k) {
        int i = 0;
        int j = k;

        while (i < k || j < array.length) {
            if (i < k && j < array.length) {
                if (array[i] < array[k - 1] && array[j] > array[k - 1]) {
                    i++;
                    j++;
                } else if (array[i] > array[k - 1] && array[j] < array[k - 1]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j++;
                } else if (array[i] > array[k - 1]) {
                    int temp = array[i];
                    array[i] = array[k - 1];
                    array[k - 1] = temp;
                    i++;
                } else if (array[j] < array[k - 1]) {
                    int temp = array[j];
                    array[j] = array[k - 1];
                    array[k - 1] = temp;
                    j++;
                } else if (array[i] < array[k - 1]) {
                    i++;
                } else if (array[j] > array[k - 1]) {
                    j++;
                }
            } else if (i < k) {
                if (array[i] > array[k - 1]) {
                    int temp = array[i];
                    array[i] = array[k - 1];
                    array[k - 1] = temp;
                }
                i++;
            } else if (j < array.length) {
                if (array[j] < array[k - 1]) {
                    int temp = array[j];
                    array[j] = array[k - 1];
                    array[k - 1] = temp;
                }
                j++;
            }
        }
        boolean recall = false;
        for (int i2 = 0, j2 = k; i2 < k - 1 || j2 < array.length; ) {
            if (i2 < k - 1) {
                if (array[i2] < array[k - 1]) {
                    i2++;
                } else {
                    recall = true;
                    break;
                }
            }
            if (j2 < array.length) {
                if (array[j2] > array[k - 1]) {
                    j2++;
                } else {
                    recall = true;
                    break;
                }
            }
        }
        if (recall) {
            return quickselect(array, k);
        }
        return array[k - 1];
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 61, 71, 72, 73, 0, 1, 21, 33, 37, 39, 40, 41, 42};
//		System.out.println(quickselect(array, 3));

        for (int i = 1; i < array.length; i++) {
            quickselect(array, i);
        }

        System.out.println(Arrays.toString(array));
    }
}
