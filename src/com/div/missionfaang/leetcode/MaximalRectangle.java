package com.div.missionfaang.leetcode;

import java.util.Arrays;

public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
		int maxRect = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix.length - 1; j++) {
				if (matrix[i][j] == '1') {
					int startRow = i;
					int startCol = j;
					int maxPossibleLength = 1;
					int maxPossibleBreadth = 1;
					for (int k = startCol + 1; k < matrix[i].length; k++) {
						if (matrix[i][k] == '1') {
							maxPossibleLength++;
							startCol = k;
						} else {
							break;
						}
					}

					for (int k = startRow + 1; k < matrix.length; k++) {
						if (matrix[k][j] == '1') {
							maxPossibleBreadth++;
							startRow = k;
						} else {
							break;
						}
					}
					int possibleLength = 1;
					int possibleBreadth = 1;
					do {
						for (int k = startCol + 1; k < maxPossibleLength; k++) {
							if (matrix[i][k] == '1') {
								possibleLength++;
								startCol = k;
							} else {
								break;
							}
						}

						for (int k = startRow + 1; k < maxPossibleBreadth; k++) {
							if (matrix[k][j] == '1') {
								possibleBreadth++;
								startRow = k;
							} else {
								break;
							}
						}
						maxRect = Math.max((startRow - i) * (startCol - j), maxRect);
					} while (possibleLength != 0 && possibleBreadth != 0);
				}
			}
		}
		return maxRect;
	}

	public static void main(String[] args) {
		char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println(maximalRectangle(matrix));
	}
}
