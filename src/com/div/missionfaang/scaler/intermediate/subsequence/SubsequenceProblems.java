package com.div.missionfaang.scaler.intermediate.subsequence;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

public class SubsequenceProblems {

    public String littlePonnyAnd2Subsequences(String A) {
        int firstMin = 0;
        char minChar = 'z';
        for (int i = 0; i < A.length() - 1; i++) {
            if (A.charAt(i) < minChar) {
                firstMin = i;
                minChar = A.charAt(i);
            }
        }
        int secondMin = firstMin;
        minChar = 'z';
        for (int i = firstMin + 1; i < A.length(); i++) {
            if (A.charAt(i) < minChar) {
                secondMin = i;
                minChar = A.charAt(i);
            }
        }
        return "" + A.charAt(firstMin) + A.charAt(secondMin);
    }

    public int specialSubsequenceAG(String A) {
        ArrayList<Integer> aIndices = new ArrayList<>();
        ArrayList<Integer> gIndices = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'A') {
                aIndices.add(i);
            } else if (A.charAt(i) == 'G') {
                gIndices.add(i);
            }
        }
        if (gIndices.size() == 0 || aIndices.size() == 0) {
            return 0;
        }
        int gIndicesPointer = 0;
        int subsequenceCount = 0;
        for (Integer aIndex : aIndices) {
            if ((gIndicesPointer < gIndices.size()) && (gIndices.get(gIndicesPointer) < aIndex)) {
                while ((gIndicesPointer < gIndices.size()) && (gIndices.get(gIndicesPointer) < aIndex)) {
                    gIndicesPointer++;
                }
            }
            subsequenceCount += gIndices.size() - gIndicesPointer;
            subsequenceCount %= 1000000007;
        }
        return subsequenceCount;
    }

    public int maxOddEvenSubsequence(ArrayList<Integer> A) {
        int count = 1;
        boolean checkForOdd = (A.get(0) % 2 == 0);
        for (int i = 0; i < A.size(); i++) {
            if (checkForOdd && A.get(i) % 2 != 0) {
                count++;
                checkForOdd = false;
            } else if (!checkForOdd && A.get(i) % 2 == 0) {
                count++;
                checkForOdd = true;
            }
        }
        return count;
    }

    public String findSubSequence(String A, String B) {
        if (A.length() > B.length()) {
            return "NO";
        }
        int i = 0;
        int j = 0;
        while (i < A.length() && j < B.length()) {
            while (j < B.length() && B.charAt(j) != A.charAt(i)) {
                j++;
            }
            i++;
            j++;
        }
        return (i == A.length()) ? "YES" : "NO";
    }

    private static int subarrayOr(ArrayList<Integer> A) {
        long sum = 0;
        for (int i = 0; i < 32; i++) {
            long total = (((long) A.size() * (A.size() + 1)) / 2);
            int count = 0;
            for (Integer integer : A) {
                if ((integer & (1 << i)) == 0) {
                    count++;
                } else {
                    total -= ((long) count * (count + 1)) / 2;
                    count = 0;
                }
            }
            total -= ((long) count * (count + 1)) / 2;
            sum += total * (1 << i);
        }
        return (int) (sum);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
        System.out.println(SubsequenceProblems.subarrayOr(array));
    }
}
