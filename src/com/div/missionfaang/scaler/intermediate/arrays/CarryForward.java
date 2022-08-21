package com.div.missionfaang.scaler.intermediate.arrays;

import com.div.missionfaang.scaler.Scaler;

import java.util.ArrayList;
import java.util.HashSet;

public class CarryForward {
    private static int closestMinMax(ArrayList<Integer> A) {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        for (Integer j : A) {
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
        }
        if (min.equals(max)) {
            return 1;
        }
        int currentMinIndex = -1;
        int currentMaxIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).equals(min)) {
                currentMinIndex = i;
                if (currentMaxIndex != -1) {
                    minDistance = Math.min(minDistance, Math.abs(currentMaxIndex - currentMinIndex));
                }
            } else if (A.get(i).equals(max)) {
                currentMaxIndex = i;
                if (currentMinIndex != -1) {
                    minDistance = Math.min(minDistance, Math.abs(currentMaxIndex - currentMinIndex));
                }
            }
        }
        return minDistance;
    }

    private static int specialSubsequences(String A) {
        int M = 1000000007;
        int count = 0;
        int aCount = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'A') {
                aCount = (aCount + 1) % M;
            }
        }

        for (int i = A.length() - 1; i > -1; i--) {
            if (A.charAt(i) == 'A') {
                aCount--;
            } else if (A.charAt(i) == 'G') {
                count = (count + aCount) % M;
            }
        }

        return count;
    }

    private static int bulbs(ArrayList<Integer> A) {
        int checkFor = 0;
        int count = 0;
        for (Integer integer : A) {
            if (integer.equals(checkFor)) {
                count++;
                checkFor = Math.abs(checkFor - 1);
            }
        }
        return count;
    }

    private static int amazingSubArrays(String A) {
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'a' ||
                    A.charAt(i) == 'e' ||
                    A.charAt(i) == 'i' ||
                    A.charAt(i) == 'o' ||
                    A.charAt(i) == 'u' ||
                    A.charAt(i) == 'A' ||
                    A.charAt(i) == 'E' ||
                    A.charAt(i) == 'I' ||
                    A.charAt(i) == 'O' ||
                    A.charAt(i) == 'U') {
                count += A.length() - i;
            }
        }
        return count;
    }

    private static ArrayList<Integer> leaderInArray(ArrayList<Integer> A) {
        if (!A.isEmpty()) {
            HashSet<Integer> set = new HashSet<>();
            set.add(A.get(A.size() - 1));
            Integer max = A.get(A.size() - 1);
            for (int i = A.size() - 2; i > -1; i--) {
                if (A.get(i) > max && !set.contains(A.get(i))) {
                    set.add(A.get(i));
                    max = A.get(i);
                }
            }
            return new ArrayList<>(set);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 7, 1, 2, 3};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr1);
        System.out.println(CarryForward.specialSubsequences("ABCGAG"));
    }

}
