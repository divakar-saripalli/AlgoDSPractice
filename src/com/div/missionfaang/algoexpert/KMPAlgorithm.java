package com.div.missionfaang.algoexpert;

public class KMPAlgorithm {
    private static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
        // Write your code here.
        int[] prefixTable = KMPAlgorithm.buildPrefixTable(substring);

        int i = 0;
        int j = 0;

        while (i < string.length() && j < substring.length()) {
            if (string.charAt(i) == substring.charAt(j)) {
                j++;
                i++;
            } else {
                if (j > 0) {
                    j = prefixTable[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j >= substring.length();
    }

    private static int[] buildPrefixTable(String pattern) {
        int i = 0;
        int j = 1;
        int[] patternArray = new int[pattern.length()];
        patternArray[0] = 0;
        while (j < pattern.length()) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                patternArray[j] = patternArray[j - 1] + 1;
                i++;
            } else {
                patternArray[j] = 0;
            }
            j++;
        }
        return patternArray;
    }

    public static void main(String[] args) {
        System.out.println(KMPAlgorithm.knuthMorrisPrattAlgorithm("aefoaefcdaefcdaed", "aefcdaed"));
    }
}
