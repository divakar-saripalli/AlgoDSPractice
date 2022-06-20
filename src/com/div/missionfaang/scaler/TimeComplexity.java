package com.div.missionfaang.scaler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TimeComplexity {

    static int calcLoops(int n) {
        int count = 0;
        for (int i = n; i > 0; i /= 2) {
            for (int j = 0; j < i; j++) {
                count += 1;
            }
        }
        return count;
    }

    private static int search(List<Integer> A, int B) {
        if (A.isEmpty()) {
            return -1;
        }
        if (A.size() < 2) {
            return A.get(0) == B ? 0 : -1;
        }
        if (B == A.get(0)) {
            return 0;
        }
        if (B == A.get(A.size() - 1)) {
            return A.size() - 1;
        }
        boolean isGreaterThanFirstElem = (B > A.get(0));
        boolean isLesserThanLastElem = (B < A.get(A.size() - 1));
        int pivot = TimeComplexity.findPivot(A);
        int start = (isGreaterThanFirstElem) ? 0 : pivot + 1;
        int end = (isLesserThanLastElem) ? A.size() - 1 : pivot;
        while (start <= end && start < A.size() && end > -1) {
            int mid = (end + start) / 2;
            Integer midValue = A.get(mid);
            if (midValue == B) {
                return mid;
            }
            if (midValue > B) {
                end = mid - 1;
            }
            if (midValue < B) {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int findPivot(List<Integer> A) {
        int start = 0;
        int end = A.size() - 1;
        Integer lastValue = A.get(A.size() - 1);
        Integer firstValue = A.get(0);
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            Integer midValue = A.get(mid);
            if ((midValue < lastValue) && (mid > 0 && midValue > A.get(mid - 1))) {
                end = mid;
            } else if (midValue > firstValue && midValue < A.get(mid + 1)) {
                start = mid;
            } else {
                break;
            }
        }
        return mid;
    }

    private static int maxMod(ArrayList<Integer> A) {
        Integer max = 0;
        int secondMax = 0;
        for (Integer element : A) {
            if (element > max) {
                secondMax = max;
                max = element;
            } else if (element > secondMax && element < max) {
                secondMax = element;
            }
        }
        return secondMax % max;
    }

    public static int pairCount(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            Integer idxIValue = A.get(i);
            for (int j = i + 1; j < A.size(); j++) {
                if (Objects.equals(idxIValue, A.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int subArraySumZero(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 0;
        } else if (A.size() == 1) {
            return A.get(0) == 0 ? 1 : 0;
        }
        Collections.sort(A);
        int pivot = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > -1) {
                pivot = i;
                break;
            }
        }
        if (A.get(pivot) == 0) {
            return 1;
        }
        int i = pivot - 1;
        int j = pivot;
        int negativeSum = A.get(i);
        int positiveSum = A.get(j);
        while (i > -1 && j < A.size()) {
            if (negativeSum + positiveSum == 0) {
                return 1;
            }
            if (Math.abs(negativeSum) > positiveSum) {
                j++;
                if (j < A.size()) {
                    positiveSum += A.get(j);
                }
            } else {
                i--;
                if (i > -1) {
                    negativeSum += A.get(i);
                }
            }
        }
        return 0;
    }

    private static ArrayList<Integer> commonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 0 || B.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(A);
        Collections.sort(B);
        int iIdx = 0;
        int jIdx = 0;
        for (int i = 0, j = 0; ((i < A.size() && j < B.size()) || iIdx < A.size() || jIdx < B.size()); ) {
            if (i == A.size() && iIdx < i - 1) {
                iIdx++;
                i = iIdx;
            }
            if (j == B.size() && jIdx < j - 1) {
                jIdx++;
                j = jIdx;
            }
            if (i == A.size() || j == B.size()) {
                return list;
            }
            if (Objects.equals(A.get(i), B.get(j))) {
                list.add(A.get(i));
                i++;
                j++;
                iIdx = i;
                jIdx = j;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return list;
    }

    private static String nextSmallestPalindrome(String A) {
        String left;
        String right;
        String center = "";

        int mid = A.length() / 2;
        left = A.substring(0, mid);
        if (A.length() % 2 != 0) {
            center = String.valueOf(A.charAt(mid));
            right = A.substring(mid + 1);
        } else {
            right = A.substring(mid);
        }

        boolean isAll9s = true;
        for (int i = 0, j = A.length() - 1; i < j; i++, j--) {
            if (A.charAt(i) != '9' || A.charAt(j) != '9') {
                isAll9s = false;
                break;
            }
        }

        if (A.length() == 1) {
            return "11";
        }

        if (isAll9s) {
            StringBuilder result = new StringBuilder("1");
            for (int i = 0; i < A.length() - 1; i++) {
                result.append("0");
            }
            return result + "1";
        } else {
            int i = left.length() - 1;
            int j = 0;
            boolean shouldContinue = true;
            while (i > -1 && j < right.length() && shouldContinue) {
                char leftValue = left.charAt(i);
                char rightValue = right.charAt(j);
                if (leftValue != rightValue) {
                    if (leftValue > rightValue) {
                        StringBuilder strToCopy = new StringBuilder(left.substring(0, i + 1)).reverse();
                        right = right.substring(0, j);
                        right += strToCopy.toString();
                        return left + center + right;
                    } else {
                        boolean updateLeft = true;
                        if (!center.equals("")) {
                            if (center.equals("9")) {
                                center = "0";
                            } else {
                                updateLeft = false;
                                center = String.valueOf(TimeComplexity.getNextIntCharacter(center.charAt(0)));
                                StringBuilder strToCopy = new StringBuilder(left.substring(0, i + 1)).reverse();
                                right = right.substring(0, j);
                                right += strToCopy.toString();
                            }
                        }
                        if (updateLeft) {
                            int k = left.length() - 1;
                            boolean carryForward = true;
                            while (k >= i && carryForward) {
                                if (left.charAt(k) != '9') {
                                    carryForward = false;
                                }
                                char charToChange = TimeComplexity.getNextIntCharacter(left.charAt(k));
                                left = left.substring(0, k) + charToChange
                                        + left.substring(k + 1);
                                k--;
                                shouldContinue = false;
                            }
                        }
                    }
                }
                i--;
                j++;
            }
            if (i < 0) {
                if (left.charAt(left.length() - 1) == '9') {
                    int k = left.length() - 1;
                    boolean carryForward = true;
                    while (k >= i && carryForward) {
                        if (left.charAt(k) != '9') {
                            carryForward = false;
                        }
                        char charToChange = TimeComplexity.getNextIntCharacter(left.charAt(k));
                        left = left.substring(0, k) + charToChange
                                + left.substring(k + 1);
                        k--;
                    }
                } else {
                    left = left.substring(0, left.length() - 1) + TimeComplexity.getNextIntCharacter(left.charAt(left.length() - 1));
                }
            }
        }

        right = new StringBuilder(left).reverse().toString();

        return left + center + right;
    }

    private static char getNextIntCharacter(char c) {
        switch (c) {
            case '0':
                return '1';
            case '1':
                return '2';
            case '2':
                return '3';
            case '3':
                return '4';
            case '4':
                return '5';
            case '5':
                return '6';
            case '6':
                return '7';
            case '7':
                return '8';
            case '8':
                return '9';
            case '9':
            default:
                return '0';
        }
    }

    private static int minimumAppendsPalindrome(String A) {
        int i = 0;
        int j = A.length() - 1;
        int pivot = i;
        while (i < j) {
            if (A.charAt(i) == A.charAt(j)) {
                pivot = i;
                while (i < j) {
                    if (A.charAt(i) == A.charAt(j)) {
                        i++;
                        j--;
                    } else {
                        break;
                    }
                }
                if (i >= j) {
                    return pivot;
                } else {
                    i = pivot + 1;
                    j = A.length() - 1;
                }
            } else {
                i++;
            }
        }
        return A.length() - 1;
    }

    private static ArrayList<Integer> prefixMatching(ArrayList<String> A, String B) {
        ArrayList<Integer> indices = new ArrayList<>();
        int i = 0;
        for (String string : A) {
            if (string.length() >= B.length()) {
                String substring = string.substring(0, B.length());
                if (substring.equalsIgnoreCase(B)) {
                    if (indices.size() < 1) {
                        indices.add(i);
                        indices.add(i);
                    } else {
                        indices.set(1, i);
                    }
                }
            }
            i++;
        }
        if (indices.size() < 2) {
            indices.add(-1);
            indices.add(-1);
        }
        return indices;
    }

    private static ArrayList<Integer> convertArrayToList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }

    public static int checkIfRectangle(int A, int B, int C, int D) {
        if (A == B && A == C && A == D) {
            return 1;
        }
        if ((A == B && C == D) || (A == C && B == D) || (A == D && B == C)) {
            return 1;
        }
        return 0;
    }

    public static String longestSubsequenceVowels(String A) {
        StringBuilder vowelsSubString = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char character = A.charAt(i);
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                vowelsSubString.append(character);
            }
        }
        return vowelsSubString.toString();
    }

    public static int sumOfAdjIsEven(ArrayList<Integer> A) {
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return (oddCount < evenCount) ? oddCount : evenCount;
    }

    public static void main(String[] args) {
        //        int[] arr = { 186, 192, 193, 202, 204, 2, 3, 6, 10, 11, 12, 17, 21, 28, 29, 30, 31, 32, 37, 38, 39, 40, 41, 47, 49, 50, 51, 52, 55, 57, 58, 59, 60, 65, 67, 68, 71, 72, 74,
        //                        77, 78, 80, 82, 83, 88, 89, 90, 94, 100, 107, 108, 109, 111, 112, 114, 115, 116, 118, 119, 121, 123, 124, 126, 129, 133, 134, 135, 137, 138, 144, 147, 148,
        //                        150, 151, 154, 156, 159, 161, 163, 165, 166, 167, 168, 169, 174, 178, 180, 182, 183, 185 };
        //        ArrayList<Integer> list = TimeComplexity.convertArrayToList(arr);
        //        System.out.println(TimeComplexity.findPivot(list));
        //        System.out.println(TimeComplexity.search(list, 6));
        //        System.out.println(generateMatrix(1));
        //        ArrayList<String> A = new ArrayList<>();
        //        A.add("aaaaa");
        //        A.add("aaab");
        //        A.add("ab");
        //        A.add("b");
        //        System.out.println(TimeComplexity.prefixMatching(A, "b"));
        //
        //        arr = new int[] { 683, 354, 95, 937, 78, 246, 319, 516, 913, 112 };
        //        list = TimeComplexity.convertArrayToList(arr);
        //        System.out.println(TimeComplexity.maxMod(list));
        //
        //        System.out.println(TimeComplexity.nextSmallestPalindrome("2345745"));
        //        System.out.println(TimeComplexity.nextSmallestPalindrome("999"));
        //        System.out.println(TimeComplexity.nextSmallestPalindrome("1001"));
        //
        //        int[] arr = new int[] { 2, 1, 4, 10 };
        //        int[] arr1 = new int[] { 3, 6, 2, 10, 10 };
        //        ArrayList<Integer> A = TimeComplexity.convertArrayToList(arr);
        //        ArrayList<Integer> B = TimeComplexity.convertArrayToList(arr1);
        //        System.out.println(TimeComplexity.commonElements(A, B));

//        System.out.println(TimeComplexity.nextSmallestPalindrome("1342451"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("1342421"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("1349421"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("134451"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("13951"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("139951"));
        System.out.println(TimeComplexity.nextSmallestPalindrome("4026061117300483012903885770893074783710083450145995410543800173874703980775883092103840037111606204"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("138851"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("1389851"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("1299941"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("13799751"));
//        System.out.println(TimeComplexity.nextSmallestPalindrome("1367997651"));
    }

}
