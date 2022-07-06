package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class SameBSTs {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // Write your code here.
        if (arrayOne.size() == arrayTwo.size()) {
            if (arrayOne.size() > 0) {
                Integer rootOne = arrayOne.get(0);
                Integer rootTwo = arrayTwo.get(0);
                if (rootOne == rootTwo) {
                    List<Integer> leftOne = new ArrayList<Integer>();
                    List<Integer> rightOne = new ArrayList<Integer>();
                    List<Integer> leftTwo = new ArrayList<Integer>();
                    List<Integer> rightTwo = new ArrayList<Integer>();
                    for (int i = 1; i < arrayOne.size(); i++) {
                        Integer integer = arrayOne.get(i);
                        if (integer < rootOne) {
                            leftOne.add(integer);
                        } else {
                            rightOne.add(integer);
                        }
                    }
                    for (int i = 1; i < arrayTwo.size(); i++) {
                        Integer integer = arrayTwo.get(i);
                        if (integer < rootTwo) {
                            leftTwo.add(integer);
                        } else {
                            rightTwo.add(integer);
                        }
                    }

                    if (sameBsts(leftOne, leftTwo)) {
                        return sameBsts(rightOne, rightTwo);
                    }
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<Integer>();
        arrayOne.add(10);
        arrayOne.add(15);
        arrayOne.add(8);
        arrayOne.add(12);
        arrayOne.add(94);
        arrayOne.add(81);
        arrayOne.add(5);
        arrayOne.add(2);
        arrayOne.add(11);

        List<Integer> arrayTwo = new ArrayList<Integer>();
        arrayTwo.add(10);
        arrayTwo.add(8);
        arrayTwo.add(5);
        arrayTwo.add(15);
        arrayTwo.add(2);
        arrayTwo.add(12);
        arrayTwo.add(11);
        arrayTwo.add(94);
        arrayTwo.add(81);

        System.out.println(sameBsts(arrayOne, arrayTwo));
    }
}
