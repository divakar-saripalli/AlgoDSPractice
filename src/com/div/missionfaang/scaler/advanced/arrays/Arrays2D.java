package com.div.missionfaang.scaler.advanced.arrays;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

public class Arrays2D {
    private static int sumOfAllSubMatrices(ArrayList<ArrayList<Integer>> A) {
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 1; j < A.get(i).size(); j++) {
                sum += A.get(i).get(j) * (i + 1) * (j + 1) * (A.size() - i) * (A.get(0).size() - j);
            }
        }
        return sum;
    }

    private static Long maxSumSortedSubMatrix(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Long>> prefixSumMatrix = new ArrayList<>(A.size());
        for (ArrayList<Integer> integers : A) {
            ArrayList<Long> row = new ArrayList<>();
            row.add(Long.valueOf(integers.get(0)));
            prefixSumMatrix.add(row);
        }

        for (int i = 0; i < A.size(); i++) {
            for (int j = 1; j < A.get(i).size(); j++) {
                prefixSumMatrix.get(i).add(prefixSumMatrix.get(i).get(j - 1) + A.get(i).get(j));
            }
        }

        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                prefixSumMatrix.get(i).set(j, prefixSumMatrix.get(i - 1).get(j) + prefixSumMatrix.get(i).get(j));
            }
        }

        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                long sum = prefixSumMatrix.get(A.size() - 1).get(A.get(i).size() - 1);
                if (i > 0) {
                    sum -= prefixSumMatrix.get(i - 1).get(A.get(i).size() - 1);
                }
                if (j > 0) {
                    sum -= prefixSumMatrix.get(A.size() - 1).get(j - 1);
                }
                if (i > 0 && j > 0) {
                    sum += prefixSumMatrix.get(i - 1).get(j - 1);
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    private static int maxSumSubMatrix(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> prefixSumMatrix = new ArrayList<>(A.size());
        for (ArrayList<Integer> integers : A) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(integers.get(0));
            prefixSumMatrix.add(row);
        }

        for (int i = 0; i < A.size(); i++) {
            for (int j = 1; j < A.get(i).size(); j++) {
                prefixSumMatrix.get(i).add(prefixSumMatrix.get(i).get(j - 1) + A.get(i).get(j));
            }
        }

        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                prefixSumMatrix.get(i).set(j, prefixSumMatrix.get(i - 1).get(j) + prefixSumMatrix.get(i).get(j));
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                for (int k = 0; k <= i; k++) {
                    for (int l = 0; l <= j; l++) {
                        int sum = prefixSumMatrix.get(i).get(j);
                        if (k > 0) {
                            sum -= prefixSumMatrix.get(k - 1).get(j);
                        }
                        if (l > 0) {
                            sum -= prefixSumMatrix.get(i).get(l - 1);
                        }
                        if (k > 0 && l > 0) {
                            sum += prefixSumMatrix.get(k - 1).get(l - 1);
                        }
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        return maxSum;
    }

    private static int searchInSortedMatrix(ArrayList<ArrayList<Integer>> A, int B) {
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

    public static void main(String[] args) {
//        int[][] arr1 = new int[][]{
//                {8, 9, 9, 1, 7},
//                {5, 5, 10, 1, 0},
//                {7, 7, 5, 8, 6},
//                {7, 3, 7, 9, 2},
//                {7, 7, 8, 10, 6}
//        };

        int[][] arr1 = new int[][]{
                {-6, -21, 27, 19, 19},
                {0, 0, 5, -21, 19},
                {18, -27, -2, -7, 13},
                {-21, -17, -25, -1, 3},
                {0, -9, -6, -16, -5},
                {29, 9, -25, -7, -25}
        };
        ArrayList<ArrayList<Integer>> matrix = ArrayUtility.convert2DArrayTo2DList(arr1);
        System.out.println(Arrays2D.maxSumSubMatrix(matrix));
    }

    public ArrayList<Integer> subMatrixSumQueries(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        ArrayList<ArrayList<Integer>> prefixSumMatrix = new ArrayList<>(A.size());
        for (ArrayList<Integer> integers : A) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(integers.get(0));
            prefixSumMatrix.add(row);
        }

        for (int i = 0; i < A.size(); i++) {
            for (int j = 1; j < A.get(i).size(); j++) {
                prefixSumMatrix.get(i).add(prefixSumMatrix.get(i).get(j - 1) + A.get(i).get(j));
            }
        }

        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                prefixSumMatrix.get(i).set(j, prefixSumMatrix.get(i - 1).get(j) + prefixSumMatrix.get(i).get(j));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            int sum = prefixSumMatrix.get(D.get(i) - 1).get(E.get(i) - 1);
            if (B.get(i) > 1) {
                sum -= prefixSumMatrix.get(B.get(i) - 2).get(E.get(i) - 1);
            }
            if (C.get(i) > 1) {
                sum -= prefixSumMatrix.get(D.get(i) - 1).get(C.get(i) - 2);
            }
            if (B.get(i) > 1 && C.get(i) > 1) {
                sum += prefixSumMatrix.get(B.get(i) - 2).get(C.get(i) - 2);
            }
            result.add((sum % 1000000007));
        }
        return result;
    }
}
