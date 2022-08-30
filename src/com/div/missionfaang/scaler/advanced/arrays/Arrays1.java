package com.div.missionfaang.scaler.advanced.arrays;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class Arrays1 {

    private static ArrayList<Integer> beggarsOutsideTemple(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> beggarsPots = new ArrayList<>(A);
        for (int i = 0; i < A; i++) {
            beggarsPots.add(0);
        }
        for (ArrayList<Integer> pots : B) {
            beggarsPots.set(pots.get(0) - 1, beggarsPots.get(pots.get(0) - 1) + pots.get(2));
            if (pots.get(1) < A) {
                beggarsPots.set(pots.get(1), beggarsPots.get(pots.get(1)) + (pots.get(2) * -1));
            }
        }

        for (int i = 1; i < A; i++) {
            beggarsPots.set(i, beggarsPots.get(i) + beggarsPots.get(i - 1));
        }
        return beggarsPots;
    }

    public int kadaneAlgorithm(List<Integer> A) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (Integer integer : A) {
            sum += integer;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    private static int trap(List<Integer> A) {

        if (A.size() < 3) {
            return 0;
        }

        List<Integer> leftMaxArray = new ArrayList<>();
        List<Integer> rightMaxArray = new ArrayList<>();
        int sum = 0;

        leftMaxArray.add(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            leftMaxArray.add(Math.max(leftMaxArray.get(i - 1), A.get(i)));
        }

        rightMaxArray.add(A.get(A.size() - 1));
        for (int i = A.size() - 2; i > -1; i--) {
            rightMaxArray.add(0, Math.max(rightMaxArray.get(0), A.get(i)));
        }

        for (int i = 0; i < A.size(); i++) {
            sum += Math.min(leftMaxArray.get(i), rightMaxArray.get(i)) - A.get(i);
        }
        return sum;
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        boolean carry = false;
        int i = A.size();
        do {
            i--;
            if (i < 0) {
                if (carry) {
                    A.add(0, 1);
                }
                break;
            }
            if (A.get(i) == 9) {
                A.set(i, 0);
                carry = true;
            } else {
                A.set(i, A.get(i) + 1);
                carry = false;
            }
        } while (carry);
        int leadingZeros = 0;
        for (Integer integer : A) {
            if (integer != 0) {
                break;
            }
            leadingZeros++;
        }
        if (i > 0) {
            A.subList(0, leadingZeros).clear();
        }
        return A;
    }

    private static ArrayList<Integer> maxNonNegativeSubArray(ArrayList<Integer> A) {
        int maxCount = 0;
        int count = 0;
        int start = -1;
        int end = -1;
        int maxStart = -1;
        int maxEnd = -1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > -1) {
                count++;
                if (start == -1) {
                    start = i;
                }
                end = i;
            } else if (maxCount < count) {
                maxCount = count;
                maxStart = start;
                maxEnd = end;
                start = -1;
                count = 0;
            } else if ((maxCount == count) &&
                    ((maxEnd - maxStart < end - start))) {
                maxStart = start;
                maxEnd = end;
                start = -1;
                count = 0;
            }
        }
        if (start > 0 && maxCount <= count) {

            maxStart = start;
            maxEnd = end;
        }
        if (maxStart >= 0) {
            return new ArrayList<>(A.subList(maxStart, maxEnd + 1));
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{756898537, -1973594324, -2038664370, -184803526, 1424268980};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
        System.out.println(Arrays1.maxNonNegativeSubArray(array));
    }
}
