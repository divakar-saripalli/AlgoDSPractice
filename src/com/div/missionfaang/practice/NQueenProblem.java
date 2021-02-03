package com.div.missionfaang.practice;

import java.util.Arrays;

public class NQueenProblem {

	public static int[][] placeNQueens(int n) {
		int[][] board = new int[n][n];
		placeNQueens(board, 0, 0, 1);
		return board;
	}

	private static boolean placeNQueens(int[][] board, int row, int column, int queenIndex) {
		// TODO Auto-generated method stub
		while (true) {
			for (int i = 0; i < board[row].length; i++) {
				if (board[row][i] == 1) {
					return false;
				}
			}
			for (int i = 0; i < board.length; i++) {
				if (board[i][column] == 1) {
					return false;
				}
			}
			for (int i = row, j = column; i > -1 && j > -1; i--, j--) {
				if (board[i][j] == 1) {
					return false;
				}
			}

			for (int i = row, j = column; i < board[row].length && j > -1; i++, j--) {
				if (board[i][j] == 1) {
					return false;
				}
			}
			board[row][column] = 1;

			int nextRow = row + 1;
			int nextCol = 0;
			int nextQueenIndex = queenIndex + 1;
			if (queenIndex == board.length) {
				return true;
			}

			if (nextRow < board.length) {
				if (!placeNQueens(board, nextRow, nextCol, nextQueenIndex)) {
					nextCol++;
					placeNQueens(board, nextRow, nextCol, nextQueenIndex);
				} else {
					return true;
				}
			} else {
				board[row][column] = 0;
				column++;
			}
		}
	}

	public static void main(String[] args) {

		int[][] nQueens = placeNQueens(4);
		for (int i = 0; i < nQueens.length; i++) {
			System.out.println(Arrays.toString(nQueens[i]));
		}
	}
}
