package com.div.missionfaang.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class Candies {

	// Complete the candies function below.
	static long candies(int n, int[] arr) {
		long totalCandies = 1;
		int[] candies = new int[arr.length];
		if (n < 2) {
			return n;
		}
		candies[0] = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}
		for (int i = n - 2; i > 0; i--) {
			if (arr[i] > arr[i + 1] && candies[i] < candies[i - 1]) {
				candies[i]++;
			}
			totalCandies += candies[i];
		}
		return totalCandies + candies[n - 1];
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
