package com.div.missionfaang.scaler.intermediate.subsequence;

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

    public static void main(String[] args) {

    }
}
