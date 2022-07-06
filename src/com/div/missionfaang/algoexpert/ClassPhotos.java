package com.div.missionfaang.algoexpert;

import java.util.ArrayList;

public class ClassPhotos {
    public static ArrayList<Integer> heapSort(ArrayList<Integer> array) {
        int i = array.size();
        while (i > 0) {
            heapify(array, i);
            swap(array, 0, i - 1);
            i--;
        }
        return array;
    }

    private static ArrayList<Integer> heapify(ArrayList<Integer> array, int heapLength) {
        for (int i = heapLength / 2; i > -1; i--) {
            int node = array.get(i);
            int right = Integer.MIN_VALUE;
            int left = Integer.MIN_VALUE;
            if (2 * i + 2 < heapLength) {
                right = array.get(2 * i + 2);
            }
            if (2 * i + 1 < heapLength) {
                left = array.get(2 * i + 1);
            }
            if (node < right || node < left) {
                if (left > right) {
                    swap(array, i, 2 * i + 1);
                } else {
                    swap(array, i, 2 * i + 2);
                }
            }
        }
        return array;
    }

    public static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
        if (redShirtHeights.size() == blueShirtHeights.size() && redShirtHeights.size() > 0) {

            redShirtHeights = heapSort(redShirtHeights);
            blueShirtHeights = heapSort(blueShirtHeights);

            if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
                for (int i = 1; i < redShirtHeights.size(); i++) {
                    if (redShirtHeights.get(i) < blueShirtHeights.get(i)) {
                        return false;
                    }
                }
            } else if (redShirtHeights.get(0) < blueShirtHeights.get(0)) {
                for (int i = 1; i < redShirtHeights.size(); i++) {
                    if (redShirtHeights.get(i) > blueShirtHeights.get(i)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        }
        return false;
    }
}
