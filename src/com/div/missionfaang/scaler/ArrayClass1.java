package com.div.missionfaang.scaler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayClass1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 7, 1, 2, 3};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr1);
        System.out.println(ArrayClass1.findBalancingArrayIndices(array));
    }

    private static void rotateArray() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int j = 0; j < N; j++) {
            A[j] = sc.nextInt();
        }
        int B = sc.nextInt();

        B = B % N;
        B = N - B;

        for (int i = 0, j = B - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        for (int i = B, j = A.length - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        for (int j : A) {
            System.out.print(j + " ");
        }
    }

    private static int secondMax(int[] A) {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        for (Integer j : A) {
            if (j > max) {
                min = max;
                max = j;
            } else if (j > min) {
                min = j;
            }
        }
        return (!min.equals(Integer.MIN_VALUE)) ? min : -1;
    }

    private static void minMaxInArray() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] A = new int[T];
        for (int j = 0; j < T; j++) {
            A[j] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j : A) {
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
        }
        System.out.println(max + " " + min);
    }

    private static ArrayList<Integer> reverseArrary(List<Integer> A) {
        ArrayList<Integer> resultArray = new ArrayList<>(A.size());
        for (int j = A.size() - 1; j > -1; j--) {
            resultArray.add(A.get(j));
        }
        return resultArray;
    }

    public static ArrayList<ArrayList<Integer>> multipleLeftRotations(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> finalMatrix = new ArrayList<>();
        for (Integer integer : B) {

            ArrayList<Integer> newList = new ArrayList<>(A);

            int rotations = integer % A.size();
            rotations = A.size() - rotations;

            for (int i = 0, j = rotations - 1; i < j; i++, j--) {
                Integer temp = newList.get(i);
                newList.set(i, newList.get(j));
                newList.set(j, temp);
            }

            for (int i = rotations, j = A.size() - 1; i < j; i++, j--) {
                Integer temp = newList.get(i);
                newList.set(i, newList.get(j));
                newList.set(j, temp);
            }

            for (int i = 0, j = A.size() - 1; i < j; i++, j--) {
                Integer temp = newList.get(i);
                newList.set(i, newList.get(j));
                newList.set(j, temp);
            }
            finalMatrix.add(newList);
        }
        Collections.reverse(finalMatrix);
        return finalMatrix;
    }

    private static void searchElement() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int len = sc.nextInt();
            int[] A = new int[len];
            for (int j = 0; j < len; j++) {
                A[j] = sc.nextInt();
            }
            int B = sc.nextInt();
            int j = 0;
            for (; j < len; j++) {
                if (A[j] == B) {
                    System.out.println(1);
                    break;
                }
            }
            if (j == len) {
                System.out.println(0);
            }
        }
    }

    private static int equilibriumIndex(ArrayList<Integer> A) {
        int index = -1;
        Integer arraySummation = 0;
        for (Integer integer : A) {
            arraySummation += integer;
        }

        Integer leftSum = 0;
        Integer rightSum = arraySummation - A.get(0);

        for (int i = 0; i < A.size() - 1; i++) {
            if (leftSum.equals(rightSum)) {
                index = i;
                break;
            } else {
                leftSum += A.get(i);
                rightSum -= A.get(i + 1);
            }
        }
        if (leftSum == 0 && index == -1) {
            index = A.size() - 1;
        }
        return index;
    }

    private static int pickFromBothSides(ArrayList<Integer> A, int B) {
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(A.get(i) + prefixSum.get(i - 1));
        }

        if (B == A.size()) {
            return prefixSum.get(A.size() - 1);
        }

        int max = (prefixSum.get(A.size() - 1) - prefixSum.get(A.size() - B - 1));
        for (int i = 0; i < B - 1; i++) {
            int startIndex = A.size() - (B - i);
            int endIndex = A.size() - 1;
            int currentSum = prefixSum.get(i) + (prefixSum.get(endIndex) - prefixSum.get(startIndex));
            if (currentSum > max) {
                max = currentSum;
            }
        }
        if (prefixSum.get(B - 1) > max) {
            return prefixSum.get(B - 1);
        }
        return max;
    }

    private static int findBalancingArrayIndices(ArrayList<Integer> A) {
        int count = 0;
        if (A.size() < 3) {
            return 0;
        }

        Integer leftOddSum = 0;
        Integer leftEvenSum = A.get(0);
        Integer rightOddSum = 0;
        Integer rightEvenSum = 0;
        for (int i = 1; i < A.size(); i++) {
            if (i % 2 != 0) {
                rightOddSum += A.get(i);
            } else {
                rightEvenSum += A.get(i);
            }
        }

        if (rightEvenSum.equals(rightOddSum)) {
            count++;
        }

        for (int i = 1; i < A.size() - 1; i++) {

            if (i % 2 != 0) {
                rightOddSum -= A.get(i);
            } else {
                rightEvenSum -= A.get(i);
            }

            if (leftEvenSum + rightOddSum == rightEvenSum + leftOddSum) {
                count++;
            }
            if (i % 2 != 0) {
                leftOddSum += A.get(i);
            } else {
                leftEvenSum += A.get(i);
            }
        }
        if (leftOddSum.equals(leftEvenSum)) {
            count++;
        }
        return count;
    }

    public int goodPair(ArrayList<Integer> A, int B) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) + A.get(j) == B) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
