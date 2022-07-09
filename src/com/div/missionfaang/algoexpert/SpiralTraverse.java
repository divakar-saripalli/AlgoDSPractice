package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    private static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        boolean done = false;
        int i = 0;
        int j = 0;
        while (!done) {
            boolean processed = false;
            while (j <= array.length - 1 && array[i][j] != Integer.MIN_VALUE) {
                list.add(array[i][j]);
                array[i][j] = Integer.MIN_VALUE;
                j++;
                processed = true;
            }
            j--;
            i++;
            while (i <= array.length - 1 && array[i][j] != Integer.MIN_VALUE) {
                list.add(array[i][j]);
                array[i][j] = Integer.MIN_VALUE;
                i++;
                processed = true;
            }
            i--;
            j--;
            while (j > -1 && array[i][j] != Integer.MIN_VALUE) {
                list.add(array[i][j]);
                array[i][j] = Integer.MIN_VALUE;
                j--;
                processed = true;
            }
            j++;
            i--;
            while (i > -1 && array[i][j] != Integer.MIN_VALUE) {
                list.add(array[i][j]);
                array[i][j] = Integer.MIN_VALUE;
                i--;
                processed = true;
            }
            i++;
            j++;
            done = !processed;
        }

        return list;
    }

    private static ArrayList<ArrayList<Integer>> generateSpiralMatrix(int A) {
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

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> spiralMatrix = SpiralTraverse.generateSpiralMatrix(6);
        System.out.println(spiralMatrix);
        int[][] spiralMatrixArray = spiralMatrix.stream().map(u -> u.stream().mapToInt(i -> i).toArray())
                .toArray(int[][]::new);
        System.out.println(SpiralTraverse.spiralTraverse(spiralMatrixArray));
    }
}