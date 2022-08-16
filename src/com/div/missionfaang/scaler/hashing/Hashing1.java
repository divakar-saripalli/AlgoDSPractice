package com.div.missionfaang.scaler.hashing;

import com.div.missionfaang.scaler.Scaler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Hashing1 {

    private static ArrayList<Integer> commonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
         ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(A);
        Collections.sort(B);
        for (int i = 0, j = 0; i < A.size() && j < B.size(); ) {
            if (A.get(i).equals(B.get(j))) {
                result.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            }
        }
        return result;
    }

    private static int firstRepeatingElement(ArrayList<Integer> A) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (Integer integer : A) {
            if (set.containsKey(integer)) {
                set.put(integer, set.get(integer) + 1);
            } else {
                set.put(integer, 1);
            }
        }

        for (Integer integer : A) {
            if (set.get(integer) > 1) {
                return integer;
            }
        }

        return -1;
    }

    private static int kOccurrences(int A, int B, ArrayList<Integer> C) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        boolean found = false;
        for (Integer integer : C) {
            if (!map.containsKey(integer)) {
                map.put(integer, 1);
            } else {
                map.put(integer, map.get(integer) + 1);
            }
        }

        for (Integer integer : C) {
            if (map.containsKey(integer) && map.get(integer) == B) {
                sum += integer;
                sum %= ((int) Math.pow(10, 9)) + 7;
                found = true;
                map.remove(integer);
            }
        }

        if (found) {
            return (sum);
        }
        return -1;
    }

    private static ArrayList<Integer> codingContestVowelsInRange(String A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> prefixSum = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o' || A.charAt(i) == 'u') {
                count++;
            }
            prefixSum.add(count);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (ArrayList<Integer> integers : B) {
            if (integers.get(0) > 0) {
                list.add(prefixSum.get(integers.get(1)) - prefixSum.get(integers.get(0) - 1));
            } else {
                list.add(prefixSum.get(integers.get(1)));
            }
        }
        return list;
    }

//    private static ArrayList<Integer> largestContinuousSubsequenceZeroSum(ArrayList<Integer> A) {
//
//    }

    private static int checkPalindrome(String A) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            if (set.contains(A.charAt(i))) {
                set.remove(A.charAt(i));
            } else {
                set.add(A.charAt(i));
            }
        }
        return set.size() > 1 ? 0 : 1;
    }


    public int colorful(int A) {
        return 1;
    }

    private static int subarrayWithZeroSum(ArrayList<Integer> A) {
        if (A.size() == 1) {
            return (A.get(0) == 0) ? 1 : 0;
        }
        if (A.size() == 2) {
            return ((A.get(0) + A.get(1)) == 0) ? 1 : 0;
        }
        ArrayList<Long> prefixSum = new ArrayList<>();
        prefixSum.add(Long.valueOf(A.get(0)));
        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(A.get(i) + prefixSum.get(i - 1));
        }

        HashSet<Long> set = new HashSet<>();
        set.add(prefixSum.get(0));
        for (int i = 1; i < prefixSum.size(); i++) {
            if (set.contains(prefixSum.get(i)) || prefixSum.get(i) == 0) {
                return 1;
            } else {
                set.add(prefixSum.get(i));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{96, -71, 18, 66, -39, -32, -16, -83, -11, -92, 55, 66, 93, 5, 50, -45, 66, -28, 69, -4, -34, -87, -32, 7, -53, 33, -12, -94, -80, -71, 48, -93, 62};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr1);

//        int[][] arr2 = new int[][]{{0, 2}};
//        ArrayList<ArrayList<Integer>> arrayLists = Scaler.convert2DArrayTo2DList(arr2);
        System.out.println(Hashing1.subarrayWithZeroSum(array));
    }
}
