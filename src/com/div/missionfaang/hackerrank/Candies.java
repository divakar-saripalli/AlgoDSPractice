package com.div.missionfaang.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class Candies {

	// Complete the candies function below.
	static long candies(int n, int[] arr) {
		int currentCandies = 1;
		long totalCandies = 1;

		if (n < 2) {
			return n;
		}

		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				currentCandies++;
			} else {
				currentCandies = 1;
				if (i < n - 1 && arr[i] > arr[i + 1]) {
					currentCandies++;
				}
			}
			System.out.print(currentCandies + " ");
			totalCandies += currentCandies;
		}
		return totalCandies;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			int arrItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			arr[i] = arrItem;
		}

		System.out.println(candies(n, arr));
		scanner.close();
	}
}
