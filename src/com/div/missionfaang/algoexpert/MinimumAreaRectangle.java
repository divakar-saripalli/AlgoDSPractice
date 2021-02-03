package com.div.missionfaang.algoexpert;

import java.util.Arrays;

public class MinimumAreaRectangle {

	public int minimumAreaRectangle(int[][] points) {
		// Write your code here.
		int minArea = Integer.MAX_VALUE;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; i++) {
				for (int k = j + 1; k < points.length; i++) {
					for (int l = k + 1; l < points.length; i++) {
						int area = findRectangleArea(points[i], points[j], points[k], points[l]);
						if (minArea > area) {
							minArea = area;
						}
					}
				}
			}
		}

		return (minArea == Integer.MAX_VALUE) ? 0 : minArea;
	}

	private int findRectangleArea(int[] coordinate1, int[] coordinate2, int[] coordinate3, int[] coordinate4) {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	public static int[][] mergeSort(int[][] points) {
		if (points.length > 1) {
			int mid = points.length / 2;
			int[][] left = new int[mid][2];
			int[][] right = new int[points.length - mid][2];
			for (int i = 0; i < left.length; i++) {
				left[i] = points[i];
			}
			for (int i = 0; i < right.length; i++) {
				right[i] = points[mid + i];
			}
			mergeSort(left);
			mergeSort(right);
			int mainArrayCounter = 0;
			int i = 0;
			int j = 0;
			while (i < left.length && j < right.length) {
				if (left[i][0] < right[j][0]) {
					points[mainArrayCounter] = left[i];
					i++;
				} else if (left[i][0] > right[j][0]) {
					points[mainArrayCounter] = right[j];
					j++;
				} else {
					if (left[i][1] < right[j][1]) {
						points[mainArrayCounter] = left[i];
						i++;
					} else if (left[i][1] > right[j][1]) {
						points[mainArrayCounter] = right[j];
						j++;
					}
				}
				mainArrayCounter++;
			}
			while (i < left.length) {
				points[mainArrayCounter] = left[i];
				i++;
				mainArrayCounter++;
			}

			while (j < right.length) {
				points[mainArrayCounter] = right[j];
				j++;
				mainArrayCounter++;
			}
		}
		return points;
	}

	public static void main(String[] args) {

		int[][] points = new int[][] { { 1, 5 }, { 5, 1 }, { 4, 2 }, { 2, 4 }, { 1, 2 }, { 2, 2 }, { 4, 5 }, { 2, 5 },
				{ -1, -2 } };
		points = mergeSort(points);
		for (int i = 0; i < points.length; i++) {
			System.out.println(Arrays.toString(points[i]));
		}

	}

}
