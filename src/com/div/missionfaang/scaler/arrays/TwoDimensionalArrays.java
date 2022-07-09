package com.div.missionfaang.scaler.arrays;

import java.util.ArrayList;

public class TwoDimensionalArrays {

    private static ArrayList<ArrayList<Integer>> addMatrices(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                A.get(i).set(j, A.get(i).get(j) + B.get(i).get(j));
            }
        }
        return A;
    }

    private static ArrayList<Integer> columnSum(ArrayList<ArrayList<Integer>> A) {
        if (A.size() == 1) {
            return A.get(0);
        }
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                A.get(i).set(j, A.get(i - 1).get(j) + A.get(i).get(j));
            }
        }
        return A.get(A.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> generateSpiralMatrix(int A) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < A; j++) {
                matrix.get(i).add(0);
            }
        }
        int cellValue = 1;
        boolean done = false;
        int i = 0;
        int j = 0;
        while (!done) {
            boolean processed = false;
            while (j <= A - 1 && matrix.get(i).get(j) == 0) {
                matrix.get(i).set(j, cellValue++);
                j++;
                processed = true;
            }
            j--;
            i++;
            while (i <= A - 1 && matrix.get(i).get(j) == 0) {
                matrix.get(i).set(j, cellValue++);
                i++;
                processed = true;
            }
            i--;
            j--;
            while (j > -1 && matrix.get(i).get(j) == 0) {
                matrix.get(i).set(j, cellValue++);
                j--;
                processed = true;
            }
            j++;
            i--;
            while (i > -1 && matrix.get(i).get(j) == 0) {
                matrix.get(i).set(j, cellValue++);
                i--;
                processed = true;
            }
            i++;
            j++;
            done = !processed;
        }
        return matrix;
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            System.out.println(row);
        }
    }

    private static ArrayList<ArrayList<Integer>> convert2DArrayTo2DList(int[][] arr) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int[] row : arr) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int element : row) {
                list.add(element);
            }
            matrix.add(list);
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{3, 12, 11, 11, 11, 15}, {3, 12, 11, 11, 11, 15}};
        ArrayList<ArrayList<Integer>> matrix = TwoDimensionalArrays.convert2DArrayTo2DList(arr1);
        TwoDimensionalArrays.printMatrix(TwoDimensionalArrays.addMatrices(matrix, matrix));
        System.out.println(TwoDimensionalArrays.columnSum(matrix));
    }
}