package com.div.missionfaang.practice;

import java.util.Arrays;

public class Array90DegreeRotation {

    private static void rotate90(int[][] a, int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
        }

        System.out.println("=====================================");

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = a[j][i];
                a[j][i] = a[n - 1 - j][i];
                a[n - 1 - j][i] = temp;
            }
        }

        System.out.println("=====================================");

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Array90DegreeRotation.rotate90(a, 3);
    }

}
