package com.div.missionfaang.algoexpert;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] array) {
		if (array.length < 3) {
			if (array.length > 1 && array[0] > array[1]) {
				int temp = array[0];
				array[0] = array[1];
				array[1] = temp;
			}
			return array;
		} else {
			int mid = array.length / 2;
			int[] leftArray = new int[mid];
			int[] rightArray = new int[array.length - mid];
			System.arraycopy(array, 0, leftArray, 0, mid);
			System.arraycopy(array, mid, rightArray, 0, array.length - mid);
			int[] array1 = mergeSort(leftArray);
			int[] array2 = mergeSort(rightArray);
			int[] resultantArray = new int[array1.length + array2.length];
			int i = 0;
			int j = 0;
			int k = 0;

			while (i + j < resultantArray.length) {
				if (i < array1.length && j < array2.length) {
					if (array1[i] < array2[j]) {
						resultantArray[k++] = array1[i++];
					} else {
						resultantArray[k++] = array2[j++];
					}
				} else if (i < array1.length) {
					resultantArray[k++] = array1[i++];
				} else {
					resultantArray[k++] = array2[j++];
				}
			}

			return resultantArray;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 2, 4, 1, 6, 5, 9, 7 };
		System.out.println(Arrays.toString(mergeSort(array)));
	}
}
