package com.div.missionfaang.scaler.advanced;

import java.util.ArrayList;

public class TwoPointers {

    private static int pairsWithGivenSum(ArrayList<Integer> A, int B) {
        int count = 0;
        for (int i = 0, j = A.size() - 1; i < j; ) {
            if (A.get(i) + A.get(j) == B) {
                count++;
                i++;
                j--;
            } else if (A.get(i) + A.get(j) < B) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }

    private static ArrayList<Integer> subarrayWithGivenSum(ArrayList<Integer> A, int B) {
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(A.get(i) + prefixSum.get(i - 1));
        }

        for (int i = 0, j = 1; i < A.size() && j < A.size(); ) {
            int subArraySum;
            if (i == 0) {
                subArraySum = prefixSum.get(j);
            } else {
                subArraySum = prefixSum.get(j) - prefixSum.get(i - 1);
            }
            if (subArraySum == B) {
                ArrayList<Integer> result = new ArrayList<>();
                while (i < j) {
                    result.add(A.get(i));
                    i++;
                }
                return result;
            }
            if (subArraySum < B) {
                j++;
            } else {
                i++;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {

    }
}
