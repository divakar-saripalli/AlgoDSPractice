package com.div.missionfaang.scaler.hashing;

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

    public static void main(String[] args) {

    }
}
