package com.div.missionfaang.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps {

    private static final Scanner scanner = new Scanner(System.in);

    private static int minimumSwaps(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        int totalSwaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && arr[i] != i + 1) {
                int j = i;
                int currentCycleLength = 0;
                while (!visited[j]) {
                    visited[j] = true;
                    j = arr[j] - 1;
                    currentCycleLength++;
                }
                totalSwaps += currentCycleLength - 1;
            }
        }
        return totalSwaps;
    }

    public static void main(String[] args) throws IOException {
        int n = MinimumSwaps.scanner.nextInt();
        MinimumSwaps.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = MinimumSwaps.scanner.nextLine().split(" ");
        MinimumSwaps.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = MinimumSwaps.minimumSwaps(arr);
        System.out.println("Minimum swaps :: " + res);
        MinimumSwaps.scanner.close();
    }
}
