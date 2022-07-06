package com.div.missionfaang.algoexpert;

import java.util.ArrayList;

public class PatternMatchers {

    public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        ArrayList<Integer> indexesOfPattern = findIndexesOfFirstLetter(pattern);
        ArrayList<Integer> indexesOfInputString = findIndexesOfFirstLetter(str);
        return new String[]{};
    }

    private static ArrayList<Integer> findIndexesOfFirstLetter(String pattern) {
        // TODO Auto-generated method stub
        if (pattern.length() == 0) {
            return new ArrayList<Integer>();
        } else {
            ArrayList<Integer> indexes = new ArrayList<>();
            indexes.add(0);
            char c = pattern.charAt(0);
            for (int i = 1; i < pattern.length(); i++) {
                if (pattern.charAt(i) == c) {
                    indexes.add(i);
                }
            }
            return indexes;
        }
    }

}
