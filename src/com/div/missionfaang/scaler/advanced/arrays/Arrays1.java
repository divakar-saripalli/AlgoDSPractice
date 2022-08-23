package com.div.missionfaang.scaler.advanced.arrays;

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

    public static void main(String[] args) {

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

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        boolean carry = false;
        int i = A.size();
        do {
            i--;
            if (i < 0) {
                if (!carry) {
                    break;
                } else {
                    A.add(0, 1);
                    break;
                }
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
}
