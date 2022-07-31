package com.div.missionfaang.scaler.strings;

import java.util.ArrayList;

public class StringProblems {
    private static ArrayList<Character> toLower(ArrayList<Character> A) {
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 65 && A.get(i) <= 90) {
                A.set(i, (char) (A.get(i) + 32));
            }
        }
        return A;
    }

    private static ArrayList<Character> toUpper(ArrayList<Character> A) {
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 97 && A.get(i) <= 122) {
                A.set(i, (char) (A.get(i) - 32));
            }
        }
        return A;
    }

    private static int isAlphaNumeric(ArrayList<Character> A) {
        for (Character character : A) {
            if (!(character >= 97 && character <= 122) &&
                    !(character >= 65 && character <= 90) &&
                    !(character >= 48 && character <= 57)) {
                return 0;
            }
        }
        return 1;
    }

    private static String stringOperations(String A) {
        StringBuilder sb = new StringBuilder(A);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 97 || sb.charAt(i) == 101 || sb.charAt(i) == 105 || sb.charAt(i) == 111 || sb.charAt(i) == 117) {
                sb.replace(i, i + 1, "#");
            }
            if (sb.charAt(i) >= 65 && sb.charAt(i) <= 90) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        return sb.toString() + sb;
    }

    private static int countOccurrences(String A) {
        int count = 0;
        for (int i = 0; i < A.length() - 2; i++) {
            if (A.charAt(i) == 'b' && A.charAt(i + 1) == 'o' && A.charAt(i + 2) == 'b') {
                count++;
                i++;
            }
        }
        return count;
    }

    private static String reverseSentenceByWord(String A) {
        StringBuilder s = new StringBuilder(A);
        s.reverse();
        int start = 0;
        for (int i = start; i < A.length(); i++) {
            if (s.charAt(i) == ' ') {
                StringBuilder substring = new StringBuilder(s.substring(start, i));
                substring.reverse();
                s.replace(start, i, String.valueOf(substring));
                start = i + 1;
            }
        }
        return s.toString();
    }

    private static int changeCharacter(String A, int B) {
        int count = 0;
        int mask = (int) (Math.pow(2, 26) - 1);
        for (int i = 0, j = 0; i < A.length() && j < B; i++) {
            int currentCharNumber = A.charAt(i) - 97;
            int validator = 1 << currentCharNumber;
            int andResult = mask & validator;
            if ((andResult >> currentCharNumber) % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    private static String longestCommonPrefix(ArrayList<String> A) {
        if (A.size() < 2) {
            return A.toString();
        }
        boolean isCommon = true;
        int charPosition = -1;
        while (isCommon) {
            charPosition++;
            for (int i = 1; i < A.size(); i++) {
                if (A.get(0).charAt(charPosition) != A.get(i).charAt(charPosition)) {
                    isCommon = false;
                    break;
                }
            }
        }
        return A.get(0).substring(0, charPosition + 1);
    }

    public static void main(String[] args) {
        System.out.println(StringProblems.stringOperations("lLdfRVCgbkND"));
    }
}