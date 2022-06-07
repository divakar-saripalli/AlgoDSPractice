package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public static List<Integer> mergeSort(List<Integer> array) {
		if (array.size() < 3) {
			if (array.size() > 1 && array.get(0) > array.get(1)) {
				Integer temp = array.get(0);
				array.set(0, array.get(1));
				array.set(1, temp);
			}
			return array;
		} else {
			int mid = array.size() / 2;
			List<Integer> leftArray = array.subList(0, mid);
			List<Integer> rightArray = array.subList(mid, array.size());
			List<Integer> array1 = mergeSort(leftArray);
			List<Integer> array2 = mergeSort(rightArray);
			List<Integer> resultantArray = new ArrayList<>(array1.size() + array2.size());
			int i = 0;
			int j = 0;

			while (i + j < array1.size() + array2.size()) {
				Integer resultantArrayNextValue = 0;
				if (i < array1.size() && j < array2.size()) {
					if (array1.get(i) < array2.get(j)) {
						resultantArrayNextValue = array1.get(i++);
					} else {
						resultantArrayNextValue = array2.get(j++);
					}
				} else if (i < array1.size()) {
					resultantArrayNextValue = array1.get(i++);
				} else {
					resultantArrayNextValue = array2.get(j++);
				}

				resultantArray.add(resultantArrayNextValue);
			}
			return resultantArray;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 2, 4, 1, 6, 5, 9, 7 };
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(1);
		list.add(6);
		list.add(5);
		list.add(9);
		list.add(7);
		System.out.println(Arrays.toString(mergeSort(array)));
		System.out.println(mergeSort(list).toString());
	}
}
