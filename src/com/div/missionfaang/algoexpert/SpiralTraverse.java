package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

	public static List<Integer> spiralTraverse(int[][] array) {
		// Write your code here.
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean allBlocked = false;

		boolean rightBlocked = false;
		boolean downBlocked = false;
		boolean leftBlocked = false;
		boolean upBlocked = false;

		int row = 0;
		int col = 0;

		while (!allBlocked) {
			while (col < array[row].length) {
				if (array[row][col] == Integer.MIN_VALUE) {
					col--;
					row++;
					rightBlocked = true;
					break;
				}
				list.add(array[row][col]);
				array[row][col] = Integer.MIN_VALUE;
				col++;
			}
			if (col == array[row].length) {
				col--;
				row++;
			}

			while (row < array.length) {
				if (row == array.length || array[row][col] == Integer.MIN_VALUE) {
					row--;
					col--;
					downBlocked = true;
					break;
				}
				list.add(array[row][col]);
				array[row][col] = Integer.MIN_VALUE;
				row++;
			}

			if (row == array.length) {
				row--;
				col--;
			}

			while (col > -1) {
				if (array[row][col] == Integer.MIN_VALUE) {
					row--;
					col++;
					leftBlocked = true;
					break;
				}
				list.add(array[row][col]);
				array[row][col] = Integer.MIN_VALUE;
				col--;
			}

			if (col < 0) {
				col++;
				row--;
			}

			while (row > -1) {
				if (array[row][col] == Integer.MIN_VALUE) {
					row++;
					col++;
					upBlocked = true;
					break;
				}
				list.add(array[row][col]);
				array[row][col] = Integer.MIN_VALUE;
				row--;
			}

			if (row < 0) {
				row++;
				col++;
			}

			allBlocked = rightBlocked && leftBlocked && upBlocked && downBlocked;
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(spiralTraverse(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }).toString());
	}
}
