package com.div.missionfaang.scaler;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUtility {
    public static ArrayList<Integer> convertArrayToList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }

    public static ArrayList<String> convertArrayToList(String[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static ArrayList<ArrayList<Integer>> convert2DArrayTo2DList(int[][] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int[] i : arr) {
          ArrayList<Integer> newList = convertArrayToList( i );
            list.add(newList);
        }
        return list;
    }
}
