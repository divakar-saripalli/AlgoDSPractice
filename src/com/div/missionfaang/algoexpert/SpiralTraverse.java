package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

	public static List<Integer> spiralTraverse(int[][] array) {
		// Write your code here.
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean hasValidValue = true;

		int row = 0;
		int col = 0;

		while (hasValidValue) {
			while (col < array[row].length) {
				if (array[row][col] == Integer.MIN_VALUE) {
					col--;
					row++;
					if (array[row][col] == Integer.MIN_VALUE) {
						hasValidValue = false;
					}
					break;
				}
				list.add(array[row][col]);
				array[row][col] = Integer.MIN_VALUE;
				col++;
			}
//			if (hasValidValue) {
//				col--;
//				row++;
//			}

			while (row < array.length) {
				if (array[row][col] == Integer.MIN_VALUE) {
					row--;
					col--;
					if (array[row][col] == Integer.MIN_VALUE) {
						hasValidValue = false;
					}
					break;
				}
				list.add(array[row][col]);
				array[row][col] = Integer.MIN_VALUE;
				row++;
			}
//			if (hasValidValue) {
//				col--;
//				row--;
//			}

			while (col > -1) {
				if (array[row][col] == Integer.MIN_VALUE) {
					col++;
					row--;
					if (array[row][col] == Integer.MIN_VALUE) {
						hasValidValue = false;
					}
					break;
				}
				list.add(array[row][col]);
				array[row][col] = Integer.MIN_VALUE;
				col--;
			}
//			if (hasValidValue) {
//				col++;
//				row--;
//			}

			while (row > -1) {
				if (array[row][col] == Integer.MIN_VALUE) {
					row++;
					col++;
					if (array[row][col] == Integer.MIN_VALUE) {
						hasValidValue = false;
					}
					break;
				}
				list.add(array[row][col]);
				array[row][col] = Integer.MIN_VALUE;
				row--;
			}
//			if (hasValidValue) {
//				col++;
//				row++;
//			}
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(spiralTraverse(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }).toString());
	}
}
