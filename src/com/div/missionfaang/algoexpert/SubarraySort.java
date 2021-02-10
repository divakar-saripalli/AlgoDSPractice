package com.div.missionfaang.algoexpert;

import java.util.Arrays;

public class SubarraySort {
	public static int[] subarraySort(int[] array) {
		// Write your code here.
		if (array.length < 2) {
			return new int[] { -1, -1 };
		}
		int i = 1;
		int j = array.length - 1;
		while (i < j) {
			if ((array[i] > array[i - 1]) && (array[j] > array[j - 1])) {
				i++;
				j--;
			} else if (array[i] > array[i - 1]) {
				i++;
			} else if (array[j] > array[j - 1]) {
				j--;
			} else {
				break;
			}
		}
		if (i >= j && array[i] >= array[j]) {
			return new int[] { -1, -1 };
		} else {
			int temp = array[i];
			while (i > 0 && temp <= array[i - 1]) {
				i--;
			}
			j--;
			temp = array[j];
			while (j < array.length - 1 && temp > array[j + 1]) {
				j++;
			}
			return new int[] { i, j };
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(subarraySort(new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 })));
		System.out.println(Arrays.toString(subarraySort(new int[] { 2, 1 })));
		System.out.println(Arrays.toString(subarraySort(new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19 })));
	}
}
