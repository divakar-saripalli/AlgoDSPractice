package com.div.missionfaang.scaler.arrays;

import com.div.missionfaang.scaler.Scaler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayClass1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 7, 1, 2, 3};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr1);
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

    private static ArrayList<Integer> reverseArray(List<Integer> A) {
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

    private static int timeToEquality(ArrayList<Integer> A) {
        Integer max = Integer.MIN_VALUE;
        for (Integer integer : A) {
            if (integer > max) {
                max = integer;
            }
        }
        int count = 0;
        for (Integer integer : A) {
            count += max - integer;
        }
        return count;
    }

    private static ArrayList<Integer> productArray(ArrayList<Integer> A) {
        ArrayList<Integer> zerothIndices = new ArrayList<>();
        Integer finalProduct = 1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) != 0) {
                finalProduct *= A.get(i);
            } else {
                zerothIndices.add(i);
            }
        }
        ArrayList<Integer> resultantArray = new ArrayList<>();
        if (zerothIndices.size() == 1) {
            for (int i = 0; i < A.size(); i++) {
                resultantArray.add(0);
            }
            resultantArray.set(zerothIndices.get(0), finalProduct);
        } else if (zerothIndices.size() > 1) {
            for (int i = 0; i < A.size(); i++) {
                resultantArray.add(0);
            }
        } else {
            for (Integer element : A) {
                resultantArray.add(finalProduct / element);
            }
        }
        return resultantArray;
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
