package com.div.missionfaang.practice;

public class PositiveIndex {

    public static void main(String[] args) {

        int[] array = {5, 3, 2, 1, 1, 4};

        int mid = array.length / 2;
        int i = mid;
        int j = mid + 1;
        int currentmax = 0;
        for (; i > -1 && j < array.length; ) {
            if (array[i] < array[j]) {
                currentmax = j - i;
                i--;
            } else {
                if (j == array.length - 1 && i > 0) {
                    i--;
                } else {
                    j++;
                }
            }
        }

        System.out.println("Current Max :: " + currentmax);
    }

}
