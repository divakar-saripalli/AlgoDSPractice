package com.div.missionfaang.scaler.arrays;

import com.div.missionfaang.scaler.Scaler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayClass1 {

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

    private static int longestConsecutiveOnesWith1Swap(String A) {
        int totalOnes;
        int maxOnes;
        int leftOnes = 0;
        int rightOnes = 0;
        if (!A.contains("1")) {
            return 0;
        }

        if (!A.contains("0")) {
            return A.length();
        }

        if (A.indexOf('0') == A.lastIndexOf('0')) {
            return A.length() - 1;
        }

        for (int i = 0; i < A.length() && A.charAt(i) == '1'; i++) {
            leftOnes++;
        }
        for (int i = leftOnes + 1; i < A.length() && A.charAt(i) == '1'; i++) {
            rightOnes++;
        }
        maxOnes = leftOnes + rightOnes + 1;
        totalOnes = leftOnes + rightOnes;

        for (int i = totalOnes + 1; i < A.length(); ) {
            leftOnes = rightOnes;
            rightOnes = 0;
            int j = i + 1;
            while (j < A.length() && A.charAt(j) != '0') {
                j++;
                rightOnes++;
            }
            totalOnes += rightOnes;
            maxOnes = Math.max(maxOnes, leftOnes + rightOnes + 1);
            i = j;
        }

        return Math.min(totalOnes, maxOnes);
    }

    private static ArrayList<Integer> alternatingSubarrays(ArrayList<Integer> A, int B) {
        ArrayList<Integer> indices = new ArrayList<>();

        if (B == 0) {
            for (int i = 0; i < A.size(); i++) {
                indices.add(i);
            }
            return indices;
        }

        if (A.size() < 3) {
            return indices;
        }

        int start = 0;
        int length = (2 * B) + 1;
        int currentLength = 1;
        int i = start;

        while (start < A.size() - 1 && i < A.size() - 1) {
            if (A.get(i).equals(A.get(i + 1))) {
                i++;
                start = i;
                currentLength = 1;
                continue;
            }
            currentLength++;
            if (currentLength == length) {
                indices.add(start + B);
                start++;
                currentLength--;
            }
            i++;
        }

        return indices;
    }

    private static void starPattern() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //logic to print the first half pattern
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i + 1; j++) {
                System.out.print("*");
            }
            //loop calculates space
            for (int k = 1; k <= 2 * i - 2; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= N - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //logic to print the second half pattern
        for (int i = N; i >= 1; i--) {
            for (int j = i; j <= N; j++) {
                System.out.print("*");
            }
            //loop calculates space
            for (int k = 1; k <= (2 * i) - 2; k++) {
                System.out.print(" ");
            }
            for (int j = i; j <= N; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static int christmasTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 3) {
            int cost = 0;
            if (A.get(0) < A.get(1) && A.get(1) < A.get(2)) {
                for (Integer integer : B) {
                    cost += integer;
                }
                return cost;
            } else {
                return -1;
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i < A.size() - 1; i++) {
            int j = i - 1;
            int k = j + 1;
            int leftLeastCost = Integer.MAX_VALUE;
            int rightLeastCost = Integer.MAX_VALUE;
            while (j > -1) {
                if (A.get(j) < A.get(i)) {
                    leftLeastCost = Math.min(leftLeastCost, B.get(j));
                }
                j--;
            }
            while (k < A.size()) {
                if (A.get(k) > A.get(i)) {
                    rightLeastCost = Math.min(rightLeastCost, B.get(k));
                }
                k++;
            }
            int currentCost = Integer.MAX_VALUE;
            if (leftLeastCost < Integer.MAX_VALUE && rightLeastCost < Integer.MAX_VALUE) {
                currentCost = leftLeastCost + rightLeastCost + B.get(i);
            }
            minCost = Math.min(minCost, currentCost);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 9, 10, 4, 7, 8};
        int[] arr2 = new int[]{5, 6, 4, 7, 2, 5};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr1);
        ArrayList<Integer> array1 = Scaler.convertArrayToList(arr2);
//        System.out.println(ArrayClass1.alternatingSubarrays(array, 1));
//        ArrayClass1.starPattern();
//        System.out.println(ArrayClass1.longestConsecutiveOnesWith1Swap("0000000010"));
        System.out.println(ArrayClass1.christmasTree(array, array1));
    }
}