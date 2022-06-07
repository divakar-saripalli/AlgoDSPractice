package com.div.missionfaang.practice;

public class MicrosoftMedianOfKSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int medianOfKSortedArrays(int[][] kSortedArrays) {
		int k = kSortedArrays.length;

		if (kSortedArrays.length == 1) {
			return kSortedArrays[0][kSortedArrays[0].length / 2];
		}
		int n = kSortedArrays[0].length;
		int[] arrayIndexPointers = new int[n];

		boolean isOddLength = false;
		if (n % 2 != 0 && k % 2 != 0) {
			isOddLength = true;
		}
		int[] finalSortedArray = new int[2];

		int counter = 0;
		while (counter < (n * k / 2)) {
			int currentMin = Integer.MAX_VALUE;
			int indexToIncrease = 0;
			for (int j = 0; j < arrayIndexPointers.length; j++) {
				if (kSortedArrays[j][arrayIndexPointers[j]] < currentMin) {
					indexToIncrease = j;
				}
			}
			currentMin = kSortedArrays[indexToIncrease][arrayIndexPointers[indexToIncrease]];
			arrayIndexPointers[indexToIncrease]++;
			counter++;
			if (isOddLength) {
				finalSortedArray[0] = currentMin;
			} else {
				if (counter < (n * k / 2) - 1) {
					finalSortedArray[0] = currentMin;
				} else {
					finalSortedArray[1] = currentMin;
				}
			}
		}

		if (isOddLength) {
			return finalSortedArray[0];
		} else {
			return ((finalSortedArray[0] + finalSortedArray[1]) / 2);
		}
	}
}