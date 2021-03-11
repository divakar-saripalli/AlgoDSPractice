package com.div.missionfaang.hackerrank;

import java.util.Scanner;

public class DFSConnectedCellGrid {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		System.out.println(getMaxRegionCount(grid));
	}

	public static int getMaxRegionCount(int[][] array) {
		int maxRegionCount = 0;
		boolean[][] markCell = new boolean[array.length][];
		for (int i = 0; i < array.length; i++) {
			markCell[i] = new boolean[array[i].length];
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 1) {
					MarkCellData mcd = new MarkCellData();
					mcd = findRegionCount(array, markCell, i, j, mcd);
					markCell = mcd.getMarkedCell();
					if (mcd.getRegionCount() > maxRegionCount)
						maxRegionCount = mcd.getRegionCount();
				}
			}
		}
		return maxRegionCount;
	}

	private static MarkCellData findRegionCount(int[][] array, boolean[][] markCell, int rowIndex, int columnIndex,
			MarkCellData mcd) {
		if (!markCell[rowIndex][columnIndex]) {
			markCell[rowIndex][columnIndex] = true;
			mcd.setMarkedCell(markCell);
			mcd.setRegionCount(mcd.getRegionCount() + 1);
			if (rowIndex > 0 && columnIndex > 0) {
				if (array[rowIndex - 1][columnIndex - 1] == 1) {
					mcd = findRegionCount(array, markCell, rowIndex - 1, columnIndex - 1, mcd);
				}
			}
			if (columnIndex > 0) {
				if (array[rowIndex][columnIndex - 1] == 1) {
					mcd = findRegionCount(array, markCell, rowIndex, columnIndex - 1, mcd);
				}
			}
			if (rowIndex < array.length - 1 && columnIndex > 0) {
				if (array[rowIndex + 1][columnIndex - 1] == 1) {
					mcd = findRegionCount(array, markCell, rowIndex + 1, columnIndex - 1, mcd);
				}
			}
			if (rowIndex > 0) {
				if (array[rowIndex - 1][columnIndex] == 1) {
					mcd = findRegionCount(array, markCell, rowIndex - 1, columnIndex, mcd);
				}
			}
			if (rowIndex < array.length - 1) {
				if (array[rowIndex + 1][columnIndex] == 1) {
					mcd = findRegionCount(array, markCell, rowIndex + 1, columnIndex, mcd);
				}
			}
			if (rowIndex > 0 && columnIndex < array[rowIndex].length - 1) {
				if (array[rowIndex - 1][columnIndex + 1] == 1) {
					mcd = findRegionCount(array, markCell, rowIndex - 1, columnIndex + 1, mcd);
				}
			}
			if (columnIndex < array[rowIndex].length - 1) {
				if (array[rowIndex][columnIndex + 1] == 1) {
					mcd = findRegionCount(array, markCell, rowIndex, columnIndex + 1, mcd);
				}
			}
			if (rowIndex < array.length - 1 && columnIndex < array[rowIndex].length - 1) {
				if (array[rowIndex + 1][columnIndex + 1] == 1) {
					mcd = findRegionCount(array, markCell, rowIndex + 1, columnIndex + 1, mcd);
				}
			}
		} else {
			mcd.setMarkedCell(markCell);
			mcd.setRegionCount(mcd.getRegionCount());
		}
		return mcd;
	}
}

class MarkCellData {
	private boolean[][] markedCell;

	private int regionCount;

	/**
	 * 
	 * @return
	 */
	public boolean[][] getMarkedCell() {
		return markedCell;
	}

	/**
	 * 
	 * @param markedCell
	 */
	public void setMarkedCell(boolean[][] markedCell) {
		this.markedCell = markedCell;
	}

	/**
	 * 
	 * @return
	 */
	public int getRegionCount() {
		return regionCount;
	}

	/**
	 * 
	 * @param regionCount
	 */
	public void setRegionCount(int regionCount) {
		this.regionCount = regionCount;
	}
}
