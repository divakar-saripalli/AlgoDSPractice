package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.Collections;

public class SunsetViews {

    private static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        if (buildings.length < 1) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = buildings[buildings.length - 1];
        if (direction.equals("EAST")) {
            list.add(buildings.length - 1);
            for (int i = buildings.length - 2; i >= 0; i--) {
                if (buildings[i] > buildings[i + 1] && buildings[i] > max) {
                    list.add(i);
                    max = buildings[i];
                }
            }
            Collections.reverse(list);
        } else {
            max = buildings[0];
            list.add(0);
            for (int i = 1; i < buildings.length; i++) {
                if (buildings[i] > buildings[i - 1] && buildings[i] > max) {
                    list.add(i);
                    max = buildings[i];
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(SunsetViews.sunsetViews(new int[]{7, 1, 7, 8, 9, 8, 7, 6, 5, 4, 2, 5}, "EAST"));
    }

}
