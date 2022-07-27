package com.div.missionfaang.scaler.sorting;

import com.div.missionfaang.scaler.Scaler;

import java.util.ArrayList;
import java.util.Collections;

public class SortingProblems {

    private static int elementRemoval(ArrayList<Integer> A) {
        Collections.sort(A);
        Collections.reverse(A);
        ArrayList<Integer> prefixSum = new ArrayList<>();
        int sum = 0;
        for (Integer integer : A) {
            sum += integer;
        }
        prefixSum.add(sum);
        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(prefixSum.get(i - 1) - A.get(i - 1));
        }
        sum = prefixSum.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (prefixSum.get(i) < prefixSum.get(i - 1)) {
                sum += prefixSum.get(i);
            }
        }
        return sum;
    }

    private static int nobleInteger(ArrayList<Integer> A) {
        Collections.sort(A);
        Collections.reverse(A);
        int lastIndex = 0;
        if (A.get(0) == 0) {
            return 1;
        }
        for (int i = 1; i < A.size(); i++) {
            if (!A.get(i).equals(A.get(i - 1))) {
                lastIndex = i;
            }
            if (A.get(i) == lastIndex) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 7, 0, 9, 3, 6, 0, 6};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr);
        System.out.println(SortingProblems.nobleInteger(array));
    }
}