package com.div.missionfaang.educative;

public class ReplacingOnes {

    public static int findLength(int[] arr, int k) {
        // TODO: Write your code here
        if (arr.length <= k) {
            return arr.length;
        }
        int zerosCount = 0;
        int startIndex = 0;
        int endIndex = 0;
        int maxLength = Integer.MIN_VALUE;
        while (endIndex < arr.length) {
            if (arr[endIndex] == 0) {
                zerosCount++;
            }
            if (zerosCount > k) {
                if ((endIndex - startIndex) > maxLength) {
                    maxLength = endIndex - startIndex - 1;
                }
                if (arr[startIndex] == 0) {
                    zerosCount--;
                }
                startIndex++;
            }
            endIndex++;
        }
        return ((endIndex - startIndex) > maxLength) ? (endIndex - startIndex) : maxLength;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));

    }

}
