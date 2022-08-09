package com.div.missionfaang.scaler.hashing;

import com.div.missionfaang.scaler.Scaler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Hashing1 {

    private static ArrayList<Integer> commonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
//        HashMap<Integer, Integer> array1NumbersCountMap = new HashMap<>();
//        HashMap<Integer, Integer> array2NumbersCountMap = new HashMap<>();
//
//        for (Integer integer : A) {
//            if (!array1NumbersCountMap.containsKey(integer)) {
//                array1NumbersCountMap.put(integer, 1);
//            } else {
//                array1NumbersCountMap.put(integer, array1NumbersCountMap.get(integer) + 1);
//            }
//        }
//
//        for (Integer integer : B) {
//            if (!array2NumbersCountMap.containsKey(integer)) {
//                array2NumbersCountMap.put(integer, 1);
//            } else {
//                array2NumbersCountMap.put(integer, array2NumbersCountMap.get(integer) + 1);
//            }
//        }
//
//        ArrayList<Integer> result = new ArrayList<>();
//
//        Set<Integer> array1Keys = array1NumbersCountMap.keySet();
//        
//        for (Integer integer : array1Keys){
//            if(array1NumbersCountMap.get(integer).equals(array2NumbersCountMap.get(integer))){
//                result.add(integer);
//            }
//        }
//        
//        return result;

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

    public int colorful(int A) {
        return 1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 0, 1};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr1);

        int[][] arr2 = new int[][]{{0, 2}};
        ArrayList<ArrayList<Integer>> arrayLists = Scaler.convert2DArrayTo2DList(arr2);
        System.out.println(Hashing1.codingContestVowelsInRange("eaucqt", arrayLists));
    }
}
