package com.div.missionfaang.hackerrank;

import java.util.Arrays;

public class QueriesWithFixedLength {

    private static int[] solve(int[] arr, int[] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int currentMin = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int k = 0; k < query; k++) {
                if (arr[k] > max) {
                    max = arr[k];
                }
            }
            currentMin = max;
            for (int j = query; j < arr.length; j++) {

                if (arr[j] < currentMin) {
                    currentMin = arr[j];
                }
            }
            result[i] = currentMin;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(QueriesWithFixedLength.solve(new int[]{33, 11, 44, 11, 55}, new int[]{1, 2, 3, 4, 5})));
    }
}
