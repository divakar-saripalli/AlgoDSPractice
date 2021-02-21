package com.div.missionfaang.algoexpert;

import java.util.Arrays;

public class HeapSort {
	public static int[] heapSort(int[] array) {
		int i = array.length;
		while (i > 1) {
			heapify(array, i);
			int temp = array[0];
			array[0] = array[i - 1];
			array[i - 1] = temp;
			i--;
		}
		return array;
	}

	private static int[] heapify(int[] array, int heapLength) {
		for (int i = heapLength / 2; i > -1; i--) {
			int node = array[i];
			int right = Integer.MIN_VALUE;
			int left = Integer.MIN_VALUE;
			if (2 * i + 2 < heapLength) {
				right = array[2 * i + 2];
			}
			if (2 * i + 1 < heapLength) {
				left = array[2 * i + 1];
			}
			if (node < right || node < left) {
				if (left > right) {
					swap(array, i, 2 * i + 1);
				} else {
					swap(array, i, 2 * i + 2);
				}
			}
		}
		return array;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(heapSort(new int[] { 8, 5, 2, 9, 5, 6, 3 })));
		System.out.println(Arrays.toString(heapSort(new int[] { 2, 1, 3 })));
		System.out.println(Arrays.toString(heapSort(new int[] { 2, 1 })));
		System.out.println(Arrays.toString(heapSort(new int[] { 1, 2 })));
		System.out.println(Arrays.toString(
				heapSort(new int[] { -4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, 6, -7, -6, -7, 8 })));
	}
}
