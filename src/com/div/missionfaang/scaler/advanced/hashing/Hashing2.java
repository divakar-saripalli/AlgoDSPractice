package com.div.missionfaang.scaler.advanced.hashing;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Hashing2 {

    /**
     * Problem Description
     * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i])
     * for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
     * <p>
     * Find and return the number of unordered quadruplet (i, j, k, l) such that
     * (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle
     * with the rectangle having all the sides parallel to either x-axis or y-axis.
     *
     * @param A
     * @param B
     * @return
     */
    private static int countRectangles(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            set.add(A.get(i) + "," + B.get(i));
        }
        int diagonalsCount = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < B.size(); j++) {
                String point1 = A.get(i) + "," + B.get(i);
                String point2 = A.get(j) + "," + B.get(j);
                String point3 = A.get(i) + "," + B.get(j);
                String point4 = A.get(j) + "," + B.get(i);
                if (!point1.equals(point2)) {
                    if (!point1.equals(point3) &&
                            !point2.equals(point4) &&
                            !point1.equals(point4) &&
                            !point2.equals(point3) &&
                            set.contains(point3) && set.contains(point4)) {
                        diagonalsCount++;
                    }
                }
            }
        }
        return (diagonalsCount > 1) ? diagonalsCount / 2 : diagonalsCount;
    }

    public static void main(String[] args) {

        int[] a = new int[]{9, 5, 1, 1, 3, 7, 7, 9, 6, 9, 2, 8};
        int[] b = new int[]{8, 1, 5, 3, 8, 5, 4, 5, 2, 2, 7, 9};

        ArrayList<Integer> A = ArrayUtility.convertArrayToList(a);
        ArrayList<Integer> B = ArrayUtility.convertArrayToList(b);
        System.out.println(Hashing2.countRectangles(A, B));

    }

    /**
     * Problem Description
     * Given two arrays of integers A and B of size N each,
     * where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
     * <p>
     * Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j])
     * and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
     * <p>
     * NOTE: The answer may be large so return the answer modulo (109 + 7).
     *
     * @param A
     * @param B
     * @return
     */
    public int countRightTriangles(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Long> xAxis = new HashMap<>();
        HashMap<Integer, Long> yAxis = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (xAxis.containsKey(A.get(i))) {
                xAxis.put(A.get(i), xAxis.get(A.get(i)) + 1);
            } else {
                xAxis.put(A.get(i), 1L);
            }

            if (yAxis.containsKey(B.get(i))) {
                yAxis.put(B.get(i), yAxis.get(B.get(i)) + 1);
            } else {
                yAxis.put(B.get(i), 1L);
            }
        }

        long count = 0;
        for (int i = 0; i < A.size(); i++) {
            count += (xAxis.get(A.get(i)) - 1) * (yAxis.get(B.get(i)) - 1);
        }
        return (int) (count % 1000000007);
    }
}
