package com.div.missionfaang.scaler.sorting;

import com.div.missionfaang.scaler.Scaler;

import java.util.*;

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

    private static String largestNumber(List<Integer> A) {
        List<Integer> list = A;
        list.sort(new DigitComparator());
        System.out.println("Sorted array :: " + A);
        boolean validNumber = false;
        StringBuilder result = new StringBuilder();
        for (int i = A.size() - 1; i > -1; i--) {
            result.append(list.get(i));
            if (!validNumber && Integer.parseInt(result.toString()) == 0) {
                result = new StringBuilder();
            } else {
                validNumber = true;
            }
        }
        return (result.toString().isEmpty()) ? "0" : result.toString();
    }

    public int leastPiercingVerticalLine(int A, int B, ArrayList<Integer> C) {
        HashMap<Integer, Integer> lengthsCount = new HashMap<>();
        int currentLength = 0;
        for (Integer integer : C) {
            currentLength += integer;
            if (currentLength < B) {
                if (lengthsCount.containsKey(currentLength)) {
                    lengthsCount.put(currentLength, lengthsCount.get(currentLength) + 1);
                } else {
                    lengthsCount.put(currentLength, 1);
                }
            } else {
                currentLength = 0;
            }
        }

        int mostCommonLength = Integer.MIN_VALUE;
        int keyToLook = 0;
        for (Integer key : lengthsCount.keySet()) {
            if (lengthsCount.get(key) > mostCommonLength) {
                mostCommonLength = lengthsCount.get(key);
                keyToLook = key;
            }
        }

        for (Integer integer : C) {
            currentLength += integer;
            if (currentLength < B) {
                if (lengthsCount.containsKey(currentLength)) {
                    lengthsCount.put(currentLength, lengthsCount.get(currentLength) + 1);
                } else {
                    lengthsCount.put(currentLength, 1);
                }
            } else {
                currentLength = 0;
            }
        }
        return lengthsCount.size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{363123231, 1061335445, 302234324, 400546535, 302143556, 910134425, 2042414166, 901143563};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr);
        System.out.println(SortingProblems.largestNumber(array));
    }
}

class DigitComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        String a1 = String.valueOf(a);
        String b1 = String.valueOf(b);
        long diff = Long.parseLong(a1 + b1) - Long.parseLong(b1 + a1);
        if (diff == 0) {
            return (int) diff;
        }
        return diff > 0 ? 1 : -1;
    }
}