package com.div.missionfaang.scaler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PrimerProblems {
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
        int pivot = PrimerProblems.findPivot(A);
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
                                center = String.valueOf(PrimerProblems.getNextIntCharacter(center.charAt(0)));
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
                                char charToChange = PrimerProblems.getNextIntCharacter(left.charAt(k));
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
                        char charToChange = PrimerProblems.getNextIntCharacter(left.charAt(k));
                        left = left.substring(0, k) + charToChange
                                + left.substring(k + 1);
                        k--;
                    }
                } else {
                    left = left.substring(0, left.length() - 1) + PrimerProblems.getNextIntCharacter(left.charAt(left.length() - 1));
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
        int pivot;
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
        return Math.min(oddCount, evenCount);
    }

    public static int maxBalancedBinaryString(String A) {
        int count = 0;
        int onesCount = 0;
        int zerosCount = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') {
                zerosCount++;
            } else {
                onesCount++;
            }
            if (zerosCount == onesCount) {
                count++;
                onesCount = 0;
                zerosCount = 0;
            }
        }
        return count;
    }

    private static int balancedArray(ArrayList<Integer> A) {
        int count = 0;

        if (A.size() < 3) {
            return (A.size() < 2) ? 1 : 0;
        }

        ArrayList<Integer> prefixOdd = new ArrayList<>();
        ArrayList<Integer> prefixEven = new ArrayList<>();
        ArrayList<Integer> suffixOdd = new ArrayList<>();
        ArrayList<Integer> suffixEven = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (i % 2 == 0) {
                if (i < 1) {
                    prefixEven.add(0);
                    prefixOdd.add(A.get(i));
                } else {
                    prefixOdd.add(prefixOdd.get(prefixOdd.size() - 1) + A.get(i));
                    prefixEven.add(prefixEven.get(prefixEven.size() - 1));
                }
            } else {
                prefixOdd.add(prefixOdd.get(prefixOdd.size() - 1));
                prefixEven.add(prefixEven.get(prefixEven.size() - 1) + A.get(i));
            }
        }

        for (int i = A.size() - 1; i > -1; i--) {
            if (i % 2 == 0) {
                if (i == A.size() - 1) {
                    suffixEven.add(0);
                    suffixOdd.add(A.get(i));
                } else {
                    suffixOdd.add(suffixOdd.get(suffixOdd.size() - 1) + A.get(i));
                    suffixEven.add(suffixEven.get(suffixEven.size() - 1));
                }
            } else {
                if (i == A.size() - 1) {
                    suffixOdd.add(0);
                    suffixEven.add(A.get(i));
                } else {
                    suffixOdd.add(suffixOdd.get(suffixOdd.size() - 1));
                    suffixEven.add(suffixEven.get(suffixEven.size() - 1) + A.get(i));
                }
            }
        }

        Collections.reverse(suffixOdd);
        Collections.reverse(suffixEven);

        for (int i = 0; i < A.size(); i++) {
            if (prefixOdd.get(i) + suffixEven.get(i) == prefixEven.get(i) + suffixOdd.get(i)) {
                count++;
            }
        }
        return count;
    }

    private static ArrayList<Integer> ponnyAndMobilePhones(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> resultantArray = new ArrayList<>();
        if (A.size() == 1) {
            for (Integer integer : B) {
                if (integer >= A.get(0)) {
                    resultantArray.add(1);
                }
            }
            return resultantArray;
        }

        Collections.sort(A);
        ArrayList<Integer> prefixSumArray = new ArrayList<>();
        prefixSumArray.add(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            prefixSumArray.add(prefixSumArray.get(i - 1) + A.get(i));
        }

        int mid = A.size() / 2;
        for (Integer integer : B) {
//            while ()

        }

        return resultantArray;
    }

    private static int minimumDistance(String A) {
        char searchChar = 'x';
        int startIndex = 0;
        for (int i = 0; i < A.length(); i++) {
            startIndex = i;
            if (A.charAt(i) == 'x') {
                searchChar = 'o';
                break;
            } else if (A.charAt(i) == 'o') {
                break;
            }
        }
        if (startIndex == A.length() - 1) {
            return -1;
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = startIndex; i < A.length(); i++) {
            if (A.charAt(i) == searchChar) {
                minDistance = Math.min(i - startIndex + 1, minDistance);
                startIndex = i;
                if (searchChar == 'x') {
                    searchChar = 'o';
                } else {
                    searchChar = 'x';
                }
            } else if (A.charAt(i) == 'x' || A.charAt(i) == 'o') {
                startIndex = i;
            }
        }
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance;
    }
}
