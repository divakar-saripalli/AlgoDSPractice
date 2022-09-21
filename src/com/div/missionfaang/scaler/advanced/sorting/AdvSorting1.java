package com.div.missionfaang.scaler.advanced.sorting;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class AdvSorting1 {

    private static int kthsmallest(List<Integer> A, int B) {
        int count = 0;
        int lastMin = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            int min = Math.max(A.get(i), lastMin + 1);
            int j = i + 1;
            int minCount = 1;
            for (; j < A.size(); j++) {
                if (min > A.get(j) && A.get(j) > lastMin) {
                    min = A.get(j);
                    minCount = 1;
                } else if (min == A.get(j)) {
                    minCount++;
                }
            }
            lastMin = min;
            count += minCount;
            if (count >= B) {
                return min;
            }
        }
        return 0;
    }

    private static int maxMod(ArrayList<Integer> A) {
        Integer max = 0;
        int secondMax = 0;
        for (Integer element : A) {
            if (element > max) {
                secondMax = max;
                max = element;
            } else if (element > secondMax && element < max) {
                secondMax = element;
            }
        }
        return secondMax % max;
    }

    public static void main(String[] args) {
//        int[] arr1 = new int[]{8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        int[] arr1 = new int[]{94, 87, 100, 11, 23, 98, 17, 35, 43, 66, 34, 53, 72, 80, 5, 34, 64, 71, 9, 16, 41, 66, 96};

        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
        System.out.println(AdvSorting1.kthsmallest(array, 9));
    }
}
