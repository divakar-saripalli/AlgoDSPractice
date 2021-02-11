package com.div.missionfaang.algoexpert;

public class IndexEqualsValue {
	public int indexEqualsValue(int[] array) {
		// Write your code here.
		int start = 0;
		int end = array.length - 1;
		int minIndex = array.length;
		while (start < end) {
			int mid = (end - start) / 2;
			if (array[mid] == mid) {
				if (mid < minIndex) {
					minIndex = mid;
					end = mid;
				}
			} else if (array[mid] < mid) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return (minIndex != array.length) ? minIndex : -1;
	}

	public static void main(String[] args) {
		IndexEqualsValue iev = new IndexEqualsValue();
		System.out.println(iev.indexEqualsValue(new int[] { -5, -3, 0, 3, 4, 5, 9 }));
	}

	public static int quickselect(int[] array, int k) {
		int min3 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int min1 = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (min1 > array[i]) {
				min3 = min2;
				min2 = min1;
				min1 = array[i];
			} else if (min2 > array[i]) {
				min3 = min2;
				min2 = array[i];
			} else if (min3 > array[i]) {
				min3 = array[i];
			}
		}
		return min3;
	}
}
