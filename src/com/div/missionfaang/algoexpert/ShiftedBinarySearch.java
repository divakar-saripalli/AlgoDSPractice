package com.div.missionfaang.algoexpert;

public class ShiftedBinarySearch {

    private static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        if (array.length < 1) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (end + start) / 2;
            int midValue = array[mid];

            if (midValue != target) {
                if (midValue < target) {
                    if (target < array[array.length - 1]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (target > array[0]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            } else {
                return mid;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(ShiftedBinarySearch.shiftedBinarySearch(new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 37, 39, 40, 41, 42}, 72));
//		System.out.println(shiftedBinarySearch(new int[] { 5, 23, 111, 1 }, 111));
    }

}
