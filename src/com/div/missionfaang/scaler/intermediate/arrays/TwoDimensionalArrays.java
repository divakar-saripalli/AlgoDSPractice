package com.div.missionfaang.scaler.intermediate.arrays;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    private static int mainDiagnoalSum(List<ArrayList<Integer>> A) {
        int sum = 0;
        for (int i = 0, j = A.size() - 1; i < A.size(); i++, j--) {
            sum += A.get(i).get(i);
            if (i != j) {
                sum += A.get(i).get(j);
            }
        }
        return sum;
    }

    private static ArrayList<ArrayList<Integer>> rowToColumnZero(ArrayList<ArrayList<Integer>> A) {
        HashSet<Integer> rowsToZero = new HashSet<>();
        HashSet<Integer> columnsToZero = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if (A.get(i).get(j) == 0) {
                    rowsToZero.add(i);
                    columnsToZero.add(j);
                }
            }
        }
        rowsToZero.forEach(row -> {
            for (int j = 0; j < A.get(0).size(); j++) {
                A.get(row).set(j, 0);
            }
        });
        columnsToZero.forEach(column -> {
            for (int j = 0; j < A.get(0).size(); j++) {
                A.get(j).set(column, 0);
            }
        });
        return A;
    }

    private static ArrayList<Integer> rowSum(ArrayList<ArrayList<Integer>> A) {
        if (A.size() == 1) {
            return A.get(0);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int j = 0; j < A.size(); j++) {
            result.add(0);
        }
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                result.set(i, result.get(i) + A.get(i).get(j));
            }
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> antiDiagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int j = i, k = 0; j > -1 && k < A.size(); j--, k++) {
                currentRow.add(A.get(k).get(j));
            }
            for (int j = currentRow.size(); j < A.size(); j++) {
                currentRow.add(0);
            }
            result.add(currentRow);
        }
        for (int i = 1; i < A.size(); i++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int j = i, k = A.size() - 1; j < A.size() && k > -1; j++, k--) {
                currentRow.add(A.get(j).get(k));
            }
            for (int j = currentRow.size(); j < A.size(); j++) {
                currentRow.add(0);
            }
            result.add(currentRow);
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> matrixTranspose(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.get(0).size(); i++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            result.add(currentRow);
            for (ArrayList<Integer> integers : A) {
                currentRow.add(integers.get(i));
            }
        }
        return result;
    }

    private static void rotateMatrixBy90Degree(ArrayList<ArrayList<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = i, k = 0; j > k; j--, k++) {
                int temp = A.get(k).get(j);
                A.get(k).set(j, A.get(j).get(k));
                A.get(j).set(k, temp);
            }
        }
        for (int i = 1; i < A.size(); i++) {
            for (int j = i, k = A.size() - 1; j < k; j++, k--) {
                int temp = A.get(k).get(j);
                A.get(k).set(j, A.get(j).get(k));
                A.get(j).set(k, temp);
            }
        }
        for (ArrayList<Integer> integers : A) {
            for (int j = 0, k = integers.size() - 1; j < k; j++, k--) {
                int temp = integers.get(j);
                integers.set(j, integers.get(k));
                integers.set(k, temp);
            }
        }
        for (ArrayList<Integer> integers : A) {
            System.out.print(integers);
        }
    }

    private static ArrayList<ArrayList<Integer>> matrixScalerMultiplication(ArrayList<ArrayList<Integer>> A, int B) {
        for (ArrayList<Integer> integers : A) {
            integers.replaceAll(integer -> integer * B);
        }
        return A;
    }

    private static int minorDiagnoalSum(List<ArrayList<Integer>> A) {
        int sum = 0;
        for (int i = A.size() - 1, j = 0; i > j; i--, j++) {
            sum += A.get(i).get(j) + A.get(j).get(i);
        }
        if (A.size() % 2 != 0) {
            sum += A.get(A.size() / 2).get(A.size() / 2);
        }
        return sum;
    }


    private static ArrayList<ArrayList<Integer>> matrixMultiplication(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> integers : A) {
            ArrayList<Integer> newRow = new ArrayList<>();
            result.add(newRow);
            for (int j = 0; j < B.get(0).size(); j++) {
                int resultantCell = 0;
                for (int k = 0; k < B.size(); k++) {
                    resultantCell += integers.get(k) * B.get(k).get(j);
                }
                newRow.add(resultantCell);
            }
        }
        return result;
    }

    private static int areMatricesSame(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if (!A.get(i).get(j).equals(B.get(i).get(j))) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
//        int[][] arr1 = new int[][]{{3, 12, 11, 11, 11, 15}, {3, 12, 11, 11, 11, 15}};
//        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr1 = new int[][]{{1, 2}, {3, 4}};
        ArrayList<ArrayList<Integer>> matrix = ArrayUtility.convert2DArrayTo2DList(arr1);
//        TwoDimensionalArrays.printMatrix(TwoDimensionalArrays.addMatrices(matrix, matrix));
//        System.out.println(TwoDimensionalArrays.columnSum(matrix));
//        System.out.println(TwoDimensionalArrays.antiDiagonal(matrix));
//        System.out.println(TwoDimensionalArrays.matrixTranspose(matrix));
        TwoDimensionalArrays.rotateMatrixBy90Degree(matrix);
    }
}