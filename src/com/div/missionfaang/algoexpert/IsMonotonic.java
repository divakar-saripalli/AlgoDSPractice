package com.div.missionfaang.algoexpert;

public class IsMonotonic {

	public static boolean isMonotonic(int[] array) {
		// Write your code here.
		if (array.length < 3) {
			return true;
		}

		boolean lesser = false;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != array[i + 1]) {
				if (array[i] < array[i + 1]) {
					lesser = true;
				}
				break;
			}

		}
		if (lesser) {
			for (int i = 0; i < array.length - 1; i++) {
				if (!(array[i] <= array[i + 1]))
					return false;
			}
		} else {
			for (int i = 0; i < array.length - 1; i++) {
				if (!(array[i] >= array[i + 1]))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] { 1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11 }));
	}

}
