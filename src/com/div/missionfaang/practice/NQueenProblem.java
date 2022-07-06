package com.div.missionfaang.practice;

import java.util.Arrays;

public class NQueenProblem {

    private static int[][] placeNQueens(int n) {
        int[][] board = new int[n][n];
        NQueenProblem.placeNQueens(board, 0, 0, 1);
        return board;
    }

    private static boolean placeNQueens(int[][] board, int row, int column, int queenIndex) {
        // TODO Auto-generated method stub
        while (true) {
            boolean boardFilled = false;
            for (int i = 0; i < board.length; i++) {
                boardFilled = false;
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 1) {
                        boardFilled = true;
                        break;
                    }
                }
                if (!boardFilled) {
                    break;
                }
            }
            if (boardFilled) {
                return true;
            }

            if (queenIndex > board.length) {
                return true;
            }
            if (row == board.length) {
                return true;
            }
            if (column == board[row].length) {
                return false;
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

            for (int i = row, j = column; j < board[row].length && i > -1; i--, j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            board[row][column] = 1;
            int nextRow = row + 1;
            int nextQueenIndex = queenIndex + 1;
            int nextCol = 0;
            if (nextRow == board.length || nextQueenIndex > board.length) {
                return true;
            }
            while (nextCol != board.length && !NQueenProblem.placeNQueens(board, nextRow, nextCol++, nextQueenIndex)) {
            }
            if (nextCol == board.length) {
                board[row][column] = 0;
                column++;
            } else if (++nextRow == board.length) {
                return true;
            } else {
                return NQueenProblem.placeNQueens(board, nextRow, nextCol, nextQueenIndex);
            }
        }
    }

    public static void main(String[] args) {

        int[][] nQueens = NQueenProblem.placeNQueens(4);
        for (int i = 0; i < nQueens.length; i++) {
            System.out.println(Arrays.toString(nQueens[i]));
        }
    }
}
