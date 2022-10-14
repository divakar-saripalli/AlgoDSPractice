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

    private static int books(ArrayList<Integer> A, int B) {
        int minPages = Integer.MAX_VALUE;
        int totalPages = 0;
        for (int pages : A) {
            totalPages += pages;
            minPages = Math.min(minPages, pages);
        }

        if (B == 1) {
            return totalPages;
        }

        if (B == A.size()) {
            return minPages;
        }

        while (minPages <= totalPages) {
            int mid = (minPages + totalPages) / 2;
            int studentsCount = 0;
            int currentPages = 0;
            int i = 0;
            for (; i < A.size(); i++) {
                if ((currentPages + A.get(i)) > mid) {
                    studentsCount++;
                    currentPages = A.get(i);
                } else {
                    currentPages += A.get(i);
                }
            }
            if (studentsCount > B) {
                minPages = mid + 1;
            } else {
                totalPages = mid - 1;
            }
        }
        return minPages;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24};

        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList(arr1);
        System.out.println(BinarySearch3.books(array1, 26));
    }
}
