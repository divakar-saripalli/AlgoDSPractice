package com.div.missionfaang.leetcode;

public class MedianOf2SortedArrays {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalLength = nums1.length + nums2.length;
        int[] sortedArray = new int[totalLength / 2 + 1];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i + j < sortedArray.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    sortedArray[k] = nums1[i];
                    i++;
                } else {
                    sortedArray[k] = nums2[j];
                    j++;
                }
            } else if (i < nums1.length) {
                sortedArray[k] = nums1[i];
                i++;
            } else {
                sortedArray[k] = nums2[j];
                j++;
            }
            k++;
        }

        if (totalLength % 2 == 0) {
            if (k > 1) {
                return (sortedArray[sortedArray.length - 1] + sortedArray[sortedArray.length - 2]) / 2.0;
            }
            return sortedArray[0];
        } else {
            return (sortedArray[sortedArray.length - 1]);
        }
    }

    public static void main(String[] args) {
        System.out.println(MedianOf2SortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
