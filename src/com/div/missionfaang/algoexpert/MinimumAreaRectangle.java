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

	public static void main(String[] args) {

		int[][] points = new int[][] { { 1, 5 }, { 5, 1 }, { 4, 2 }, { 2, 4 }, { 1, 2 }, { 2, 2 }, { 4, 5 }, { 2, 5 },
				{ -1, -2 } };
		for (int i = 0; i < points.length; i++) {
			System.out.println(Arrays.toString(points[i]));
		}

	}

}
