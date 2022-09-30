package com.div.missionfaang.scaler.advanced.binarysearch;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

public class BinarySearch3 {

    private static int paint(int A, int B, ArrayList<Integer> C) {
        int mod = 10000003;
        int maxLength = Integer.MIN_VALUE;
        int totalLength = 0;
        for (int boardLength : C) {
            totalLength += boardLength;
            maxLength = Math.max(maxLength, boardLength);
        }

        if (A == 1) {
            long result = (long) totalLength * B;
            return (int) (((result % mod) + mod) % mod);
        }

        while (maxLength <= totalLength) {
            int mid = (maxLength + totalLength) / 2;
            int paintersCount = 0;
            int workload = 0;
            int i = 0;
            for (; i < C.size() && paintersCount <= A; i++) {
                if ((workload + C.get(i)) > mid) {
                    paintersCount++;
                    workload = C.get(i);
                } else {
                    workload += C.get(i);
                }
            }
            if (paintersCount >= A) {
                maxLength = mid + 1;
            } else {
                totalLength = mid - 1;
            }
        }
        long result = (long) maxLength * B;
        return (int) (((result % mod) + mod) % mod);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1000000, 1000000};

        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList(arr1);
        System.out.println(BinarySearch3.paint(1, 1000000, array1));
    }
}
