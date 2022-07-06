package com.div.missionfaang.practice;

public class AppleSpiralTraversal {

    private static void printSpiralMatrix(int[][] matrix) {

        boolean[][] processedMatrix = new boolean[matrix.length][matrix[0].length];

        if (matrix.length > 0) {
            int row = 0;
            int column = 0;
            boolean isElementAvailable = true;

            while (isElementAvailable) {
                boolean isRightAvailable = true;
                boolean isLeftAvailable = true;
                boolean isDownAvailable = true;
                boolean isUpAvailable = true;

                while (column < matrix[0].length && isRightAvailable) {
                    // Processing row forward
                    if (!processedMatrix[row][column]) {
                        System.out.print(matrix[row][column] + " ");
                        processedMatrix[row][column] = true;
                        column++;
                    }
                }
                column--;
                row++;

                isDownAvailable = processedMatrix[row][column];

                while (row < matrix.length && isDownAvailable) {
                    if (!processedMatrix[row][column]) {
                        System.out.print(matrix[row][column] + " ");
                        processedMatrix[row][column] = true;
                        row++;
                    }
                }
                row--;
                column--;

                isLeftAvailable = processedMatrix[row][column];

                while (column > -1 && isLeftAvailable) {
                    if (!processedMatrix[row][column]) {
                        System.out.print(matrix[row][column] + " ");
                        processedMatrix[row][column] = true;
                        column--;
                    }
                }
                column++;
                row--;

                isUpAvailable = processedMatrix[row][column];

                while (row > -1 && isUpAvailable) {
                    if (!processedMatrix[row][column]) {
                        System.out.print(matrix[row][column] + " ");
                        processedMatrix[row][column] = true;
                        row--;
                    }
                }
                row++;
                column++;

                isRightAvailable = processedMatrix[row][column];

                isElementAvailable = isRightAvailable || isLeftAvailable || isDownAvailable || isUpAvailable;
            }

        } else {
            for (int i = 0; i < matrix[0].length; i++) {
                System.out.print(matrix[0][i] + " ");
            }
        }

    }

    public static void main(String[] ARGS) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        AppleSpiralTraversal.printSpiralMatrix(matrix);
    }

}
