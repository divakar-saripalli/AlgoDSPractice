package com.div.missionfaang.scaler.advanced.arrays;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

public class Arrays2D {
    private static int sumOfAllSubMatrices(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> prefixSumMatrix = new ArrayList<>(A.size());

        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 1; j < A.get(i).size(); j++) {
                sum += A.get(i).get(j) * (i + 1) * (j + 1) * (A.size() - i) * (A.get(0).size() - j);
            }
        }

//        for (ArrayList<Integer> integers : A) {
//            ArrayList<Integer> row = new ArrayList<>();
//            row.add(integers.get(0));
//            prefixSumMatrix.add(row);
//        }
//
//        for (int i = 0; i < A.size(); i++) {
//            for (int j = 1; j < A.get(i).size(); j++) {
//                prefixSumMatrix.get(i).add(prefixSumMatrix.get(i).get(j - 1) + A.get(i).get(j));
//            }
//        }
//
//        for (int i = 1; i < A.size(); i++) {
//            for (int j = 0; j < A.get(i).size(); j++) {
//                prefixSumMatrix.get(i).set(j, prefixSumMatrix.get(i - 1).get(j) + prefixSumMatrix.get(i).get(j));
//            }
//        }
//
//        for (int i = 0; i < A.size(); i++) {
//            for (int j = 0; j < A.get(i).size(); j++) {
//                for (int k = 0; k < A.size(); k++) {
//                    for (int l = 0; l < A.get(k).size(); l++) {
//                        sum += prefixSumMatrix.get(i).get(j);
//                        if (i > 0) {
//                            sum -= prefixSumMatrix.get(i - 1).get(l);
//                        }
//                        if (j > 0) {
//                            sum -= prefixSumMatrix.get(k).get(j - 1);
//                        }
//                        if (i > 0 && j > 0) {
//                            sum += prefixSumMatrix.get(i - 1).get(j - 1);
//                        }
//                    }
//                }
//            }
//        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                {8, 9, 9, 1, 7},
                {5, 5, 10, 1, 0},
                {7, 7, 5, 8, 6},
                {7, 3, 7, 9, 2},
                {7, 7, 8, 10, 6}
        };
        ArrayList<ArrayList<Integer>> matrix = ArrayUtility.convert2DArrayTo2DList(arr1);
        System.out.println(Arrays2D.sumOfAllSubMatrices(matrix));
    }

    public int searchInSortedMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int i = 0;
        int j = A.get(0).size() - 1;
        while (j > -1 && i < A.size()) {
            if (A.get(i).get(j) == B) {
                while (j > -1 && A.get(i).get(j) == B) {
                    j--;
                }
                return (((i + 1) * 1009) + (j + 2));
            } else if (A.get(i).get(j) < B) {
                i++;
            } else {
                j--;
            }
        }
        return -1;
    }
}
