package com.div.missionfaang.scaler.advanced.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class StringProbsUsingHash {

    /**
     * Problem Description
     * Given a string A, find the length of the longest substring without repeating characters.
     * <p>
     * Note: Users are expected to solve in O(N) time complexity.
     * <p>
     * Problem Constraints
     * 1 <= size(A) <= 106
     * <p>
     * String consists of lowerCase,upperCase characters and digits are also present in the string A.
     *
     * @param A
     * @return
     */
    private static int lengthOfLongestSubstring(String A) {
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int max = 1;
        for (int i = 0; i < A.length(); i++) {
            if (set.contains(A.charAt(i))) {
                max = Math.max(max, i - start);
                while (A.charAt(start) != A.charAt(i)) {
                    set.remove(A.charAt(start));
                    start++;
                }
                set.remove(A.charAt(start));
                start++;
            }
            set.add(A.charAt(i));
        }
        return Math.max(max, A.length() - start);
    }

    /**
     * Problem Description:
     * <p>
     * Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
     * Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
     * <p>
     * Note:
     * <p>
     * If there is no such window in A that covers all characters in B, return the empty string.
     * If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
     * <p>
     * Problem Constraints
     * 1 <= size(A), size(B) <= 106
     *
     * @param A
     * @param B
     * @return
     */
    private static String minWindow(String A, String B) {
        HashSet<Character> requiredChars = new HashSet<>();
        HashMap<Character, ArrayList<Integer>> frequencyMap = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            requiredChars.add(B.charAt(i));
            ArrayList<Integer> frequencyArray = new ArrayList<>();
            if (frequencyMap.containsKey(B.charAt(i))) {
                frequencyArray = frequencyMap.get(B.charAt(i));
                frequencyArray.set(0, frequencyArray.get(0) + 1);
            } else {
                frequencyArray.add(1);
                frequencyArray.add(0);
            }
            frequencyMap.put(B.charAt(i), frequencyArray);
        }

        if (A.length() == 1) {
            if (frequencyMap.containsKey(A.charAt(0))) {
                return A;
            } else {
                return "";
            }
        }

        if (B.length() == 1) {
            if (A.indexOf(B.charAt(0)) != -1) {
                return B;
            } else {
                return "";
            }
        }

        int start = -1;
        int tempStart = 0;
        int min = Integer.MAX_VALUE;
        int end = 0;
        int lastI = -1;
        for (int i = 0; i < A.length(); ) {
            if (frequencyMap.containsKey(A.charAt(i)) && lastI < i) {
                ArrayList<Integer> frequencyArray = frequencyMap.get(A.charAt(i));
                frequencyArray.set(1, frequencyArray.get(1) + 1);
                if (frequencyArray.get(0) > frequencyArray.get(1)) {
                    requiredChars.add(A.charAt(i));
                } else {
                    requiredChars.remove(A.charAt(i));
                }
            }
            lastI = i;
            if (requiredChars.size() == 0) {
                if (tempStart < 0) {
                    tempStart = 0;
                }
                if (min > (i - tempStart)) {
                    min = i - tempStart;
                    start = tempStart;
                    end = i + 1;
                }
                if (frequencyMap.containsKey(A.charAt(tempStart))) {
                    ArrayList<Integer> frequencyArray = frequencyMap.get(A.charAt(tempStart));
                    frequencyArray.set(1, Math.max(0, frequencyArray.get(1) - 1));
                    if (frequencyArray.get(0) > frequencyArray.get(1)) {
                        requiredChars.add(A.charAt(tempStart));
                    }
                }
                tempStart++;
                if (tempStart == i) {
                    i++;
                }
            } else {
                i++;
            }
        }
        if (requiredChars.size() == 0 && min > (A.length() - start)) {
            end = A.length();
        }
        return (start != -1) ? A.substring(start, end) : "";
    }

    public static void main(String[] args) {
        System.out.println(StringProbsUsingHash.minWindow("AAAAAAAA", "AA"));
        System.out.println(StringProbsUsingHash.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(StringProbsUsingHash.minWindow("w", "o"));
    }
}
